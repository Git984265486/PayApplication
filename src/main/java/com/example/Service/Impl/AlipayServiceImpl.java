package com.example.Service.Impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;

import com.alipay.api.response.AlipayTradeQueryResponse;
import com.example.ConfigPay.AlipayConfig;
import com.example.Damain.Tcharge;
import com.example.Service.AlipayService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AlipayServiceImpl  implements AlipayService {


    /**【下单】**/
    @Override
    public String create(Tcharge chargeInfo) {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,
                AlipayConfig.format,AlipayConfig.charset,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.sign_type);

        //创建PC场景下单并支付请求对象
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request

        //设置同步返回地址，HTTP/HTTPS开头字符串
        alipayRequest.setReturnUrl(AlipayConfig.return_url);

        //支付宝服务器主动通知商户服务器里指定的页面http/https路径。
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);//在公共参数中设置回跳和通知地址

        //商户订单号，不能为空
        String out_trade_no = chargeInfo.getOrderNumber();

        //付款金额，不能为空，单位:元
        String total_amount = chargeInfo.getTotalAmount();

        //订单名称，不能为空
        String subject = "待支付订单车牌号:" + chargeInfo.getCarNo();

        //商品描述，可空
        String body = "支付订单:" + chargeInfo.getOrderNumber();

        //该笔订单最晚付款时间，逾期关闭交易。取值范围:1m~15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //填充业务参数
        String form="";
        try {
            //调用SDK生成表单
            //form = alipayClient.pageExecute(alipayRequest).getBody();
            AlipayTradePagePayResponse responseData = alipayClient.pageExecute(alipayRequest);
            form = responseData.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }

    /**【异步通知】**/
    @Override
    public String notifyUrl(HttpServletRequest request) {
        String payStatus = "fail";
        Map<String , String > parmas = new HashMap<>();
        Map<String , String []> requestParmas = request.getParameterMap();

        for (Iterator<String> iter = requestParmas.keySet().iterator(); iter.hasNext() ; ){
            String name = iter.next();
            String [] values = requestParmas.get(name);
            String valStr = "";
            for (int i = 0 ; i < values.length ; i ++){
                valStr = (i == values.length - 1) ? valStr + values[i] : valStr + values[i] + ",";
            }
            parmas.put(name , valStr);
            //System.out.println("【异步通知的值】" + name + "\t\t:" + valStr);
        }

        //签名验证
        boolean signVerified = false;

        try {
            signVerified = AlipaySignature.rsaCheckV1(parmas,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.charset,AlipayConfig.sign_type);
        }catch (AlipayApiException e){
            System.out.println("【异步签名异常】" + e.getErrMsg());
        }
        //签名验证通过
        if (signVerified){
            System.out.println("【异步通知签名验证】" + signVerified);
            String trade_status = request.getParameter("trade_status");//交易状态
            String out_trade_no = request.getParameter("out_trade_no");//商户订单号
            //System.out.println("【异步通知商户订单号】" + out_trade_no + "\t\t【异步通知交易状态】" + trade_status);
            if (trade_status.equals("TRADE_SUCCESS")){  //判断订单交易状态
                payStatus = out_trade_no;
            }
        }
        return payStatus;
    }

    /**【同步跳转】**/
    @Override
    public void returnUrl(HttpServletRequest request) throws UnsupportedEncodingException {
        Map<String , String > params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //System.out.println("<--同步回调的值-->" + name + "\t\t" + valueStr);
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.charset,AlipayConfig.sign_type);
        }catch (Exception e){
            System.out.println("报错：" + e.getMessage());
            e.printStackTrace();
        }

        if(signVerified) {

            System.out.println("<--同步回调签名验证-->" + signVerified);
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            request.setAttribute("out_trade_no", out_trade_no);
            request.setAttribute("trade_no", trade_no);
            request.setAttribute("total_amount", total_amount);

            //System.out.println("<--同步回调系统订单号-->" + out_trade_no + "\t\t<--同步回调支付宝交易号-->" + trade_no);
            //系统处理根据支付宝回调更改订单状态或者其他关联表的数据
        }else{
            request.setAttribute("reason", "验签失败");
        }
        request.setAttribute("signVerified", signVerified);
    }

    /**【交易查询】**/
    @Override
    public String queryOrder(String orderNumber) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,
                AlipayConfig.format,AlipayConfig.charset,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.sign_type);
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":\"" + orderNumber + "\"," +
                "\"trade_no\":\"" + "" + "\"," +
                "\"org_pid\":\"" + "" + "\"," +
                "      \"query_options\":[" +
                "        \"TRADE_SETTLE_INFO\"" +
                "      ]" +
                "  }");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        System.out.println("【查询返回交易状态】" + response.getTradeStatus());
        return response.getTradeStatus();
    }


}
