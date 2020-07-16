package com.example.Controller;

import com.alipay.api.AlipayApiException;
import com.example.Damain.Tcharge;
import com.example.Service.AlipayService;
import com.example.Service.TchargeService;
import com.example.Utils.PayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@CrossOrigin
@Controller
public class AlipayController {

    @Autowired
    private AlipayService payService;

    @Autowired
    private TchargeService chargeService;

    /**【支付宝下单返回付款二维码】**/
    @GetMapping("/pay")
    @ResponseBody
    public String alipayQrcode(@RequestParam(value="FormVal",defaultValue="") String FormVal){
        System.out.println("阿里支付接收表单提交的数据：" + FormVal);
        Tcharge chargeInfo = PayUtils.getPayInfo(FormVal);  //订单信息
        PayUtils.ListChargeInfo(chargeInfo);
        chargeService.insertChargeData(chargeInfo);
        String result = payService.create(chargeInfo);
        return result;
    }

    /**【支付宝异步通知，支付宝支付后，会回调该接口】**/
    @PostMapping(value = "/notify_url")
    public String notifyUrl(HttpServletRequest request){
        String orderNumber = payService.notifyUrl(request);
        System.out.println("【异步通知返回的订单号】" + orderNumber);
        if (!orderNumber.equals("fail")){
            Tcharge chargeInfo = chargeService.selectDataByOrderNumber(orderNumber);
            if (chargeInfo != null){
                chargeInfo.setPayStatus("已支付");
                chargeService.updateChargeData(chargeInfo);
                System.out.println("【异步通知订单更新完成！】");
            }else {
                System.out.println("【异步通知订单更新失败！】");
            }
        }
        return "recordTab";
    }

    /**【同步跳转，告诉你是否调用成功，不能拿来判断支付成功】**/
    @GetMapping(value = "/return_url")
    public String returnUrl(HttpServletRequest request) throws UnsupportedEncodingException {
        payService.returnUrl(request);
        return "Index";
    }

    /**【支付宝交易状态查询】**/
    @RequestMapping(value = "/requestQuery")
    @ResponseBody
    public String requestQuery() throws AlipayApiException {
       return payService.queryOrder("ON20200715094351625");
    }

}
