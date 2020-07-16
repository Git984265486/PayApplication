package com.example.Damain;

import lombok.Data;

@Data
public class Tuser {

    private String userID;      //用户id
    private String userName;    //用户名
    private String realName;    //真实姓名
    private String password;    //密码
    private String sex;         //性别
    private String phone;       //电话
    private String isAdmin;     //是否是管理员
    private String address;     //住址
    private String status;      //账号状态

}
