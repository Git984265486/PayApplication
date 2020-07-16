package com.example.Damain;

import lombok.Data;

@Data
public class Tcharge {

    private String autoID;          //自增ID
    private String orderNumber;     //订单号
    private String ownerName;       //车主姓名
    private String ownerPhone;      //车主电话
    private String totalAmount;     //总金额
    private String payType;         //支付方式
    private String payStatus;       //支付状态
    private String carNo;           //车牌号码
    private String carType;         //车辆类型
    private String registrTime;     //车辆注册时间
    private String operater;        //操作人员
    private String operatTime;      //操作时间
    private String remark;          //备注

}
