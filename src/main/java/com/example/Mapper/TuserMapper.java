package com.example.Mapper;

import com.example.Damain.Tuser;

import java.util.List;

public interface TuserMapper {

    /**【获取所有用户信息】**/
    public List<Tuser> ListUser(String realName);

    /**【通过ID拿到用户信息】**/
    public Tuser selectUserByID(String userID);

    /**【通过登录名精确查找用户信息】**/
    public Tuser selectUserByUserName(String userName);

    /**【用户登录信息验证】**/
    public Tuser validateUserData(String userName , String password);

    /**【通过ID修改用户信息】**/
    public void updateUserByID(String realName,String phone,String address,String sex,String password,String userName,
                               String isAdmin,String status,String userID);

    /**【新增用户】**/
    public void insertNewUser(String userName , String realName , String password , String sex , String phone ,
                              String isAdmin , String address , String status);

    /**【通过ID删除用户】**/
    public void deleteUserByUserID(String userID);


}
