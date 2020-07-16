package com.example.Utils;

import com.example.Damain.Tcharge;
import net.sf.json.JSONObject;

public class PayUtils {

    /**【将支付宝下单JSON数据解析到实体类中】**/
    public static Tcharge getPayInfo(String payInfo){
        Tcharge charge = null;
        if (!payInfo.equals("")){
            charge = new Tcharge();
            JSONObject jsonData = JSONObject.fromObject(payInfo);
            charge.setCarNo(jsonData.getString("carNo"));           //车牌号码
            charge.setCarType(jsonData.getString("carType"));       //车辆类型
            charge.setOwnerName(jsonData.getString("name"));        //车主姓名
            charge.setOwnerPhone(jsonData.getString("phone"));      //车主电话
            charge.setTotalAmount(jsonData.getString("totalAmount"));//总金额
            String registrTime = jsonData.getString("selData");
            charge.setRegistrTime(TimeUtils.subTimeStr(registrTime,0,10));  //车辆注册时间
            charge.setOperater(jsonData.getString("operater"));     //操作人员
            charge.setPayStatus("未支付");                               //支付状态
            charge.setOrderNumber("ON"+TimeUtils.getTimeLong());        //订单号
            charge.setOperatTime(TimeUtils.getNowTime());               //操作时间
            charge.setPayType(jsonData.getString("payType"));      //支付类型
            charge.setRemark(jsonData.getString("remark"));        //备注信息
        }
        return charge;
    }


    /**【将前端编辑收费信息JSON数据解析到实体类中】**/
    public static Tcharge editChargeData(String editVal){
        Tcharge chargeInfo = null;
        if (!editVal.equals("")){
            chargeInfo = new Tcharge();
            JSONObject jsonData = JSONObject.fromObject(editVal);
            chargeInfo.setAutoID(jsonData.getString("autoID"));
            chargeInfo.setOrderNumber(jsonData.getString("orderNumber"));
            chargeInfo.setOwnerName(jsonData.getString("ownerName"));
            chargeInfo.setOwnerPhone(jsonData.getString("ownerPhone"));
            chargeInfo.setTotalAmount(jsonData.getString("totalAmount"));
            chargeInfo.setPayType(jsonData.getString("payType"));
            chargeInfo.setPayStatus(jsonData.getString("payStatus"));
            chargeInfo.setCarNo(jsonData.getString("carNo"));
            chargeInfo.setCarType(jsonData.getString("carType"));
            chargeInfo.setRegistrTime(jsonData.getString("registrTime"));
            chargeInfo.setOperater(jsonData.getString("operater"));
            chargeInfo.setRemark(jsonData.getString("remark"));
            chargeInfo.setOperatTime(TimeUtils.getNowTime());
        }
        return chargeInfo;
    }



    /**【后台打印收费信息】**/
    public static void ListChargeInfo(Tcharge chargeInfo){
        if (chargeInfo != null){
            System.out.println("PayUtils.LogChargeInfo ---> 自增编号:" + chargeInfo.getAutoID());
            System.out.println("PayUtils.LogChargeInfo ---> 车牌号码:" + chargeInfo.getCarNo());
            System.out.println("PayUtils.LogChargeInfo ---> 车辆类型:" + chargeInfo.getCarType());
            System.out.println("PayUtils.LogChargeInfo ---> 车主姓名:" + chargeInfo.getOwnerName());
            System.out.println("PayUtils.LogChargeInfo ---> 车主电话:" + chargeInfo.getOwnerPhone());
            System.out.println("PayUtils.LogChargeInfo ---> 收费金额:" + chargeInfo.getTotalAmount());
            System.out.println("PayUtils.LogChargeInfo ---> 支付类型:" + chargeInfo.getPayType());
            System.out.println("PayUtils.LogChargeInfo ---> 注册时间:" + chargeInfo.getRegistrTime());
            System.out.println("PayUtils.LogChargeInfo ---> 操作时间:" + chargeInfo.getOperatTime());
            System.out.println("PayUtils.LogChargeInfo ---> 操作人员:" + chargeInfo.getOperater());
            System.out.println("PayUtils.LogChargeInfo ---> 订单编号:" + chargeInfo.getOrderNumber());
            System.out.println("PayUtils.LogChargeInfo ---> 支付状态:" + chargeInfo.getPayStatus());
            System.out.println("PayUtils.LogChargeInfo ---> 备注信息:" + chargeInfo.getRemark());
        }else {
            System.out.println("PayUtils.LogChargeInfo : 收费信息内容为空!");
        }
    }

}
