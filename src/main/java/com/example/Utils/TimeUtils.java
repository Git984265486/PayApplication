package com.example.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    /**【拿到当前系统时间】**/
    public static String getNowTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        String TimeStr = format.format(time);
        System.out.println("TimeUtils.subTimeStr ---> TimeStr:" + TimeStr);
        return TimeStr;
    }

    /**【截取字符串 timeStr 从 start 开始到 end 结束】**/
    public static String subTimeStr(String timeStr , int start , int end){
        String returnStr = null;
        if (!timeStr.equals("")){
            if (timeStr.length() >= end){
                returnStr = timeStr.substring(start,end);
            }else {
                returnStr = "Error:OverSize";
            }
        }
        System.out.println("TimeUtils.subTimeStr ---> returnStr:" + returnStr);
        return returnStr;
    }

    /**【获取时间戳作为订单号】**/
    public static String getTimeLong(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String timeLong = format.format(date);
        System.out.println("TimeUtils.subTimeStr ---> timeLong:" + timeLong);
        return timeLong;
    }
}
