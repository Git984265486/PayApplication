package com.example.Service;

import com.alipay.api.AlipayApiException;
import com.example.Damain.Tcharge;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface AlipayService {

    /**【生成订单】**/
    public String create(Tcharge chargeInfo);

    /**【异步通知会返回一个request】**/
    public String notifyUrl(HttpServletRequest request);

    /**【同步跳转】**/
    public void returnUrl(HttpServletRequest request) throws UnsupportedEncodingException;

    /**【交易查询】**/
    public String queryOrder(String orderNumber) throws AlipayApiException;
}
