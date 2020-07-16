package com.example.Service;

import com.example.Damain.Tuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TuserService {

    /**【获取所有用户信息】**/
    public List<Tuser> ListUser(String realName);

    /**【通过ID拿到用户信息】**/
    public Tuser selectUserByID(String userID);

    /**【通过登录名精确查找用户信息】**/
    public Tuser selectUserByUserName(String userName);

    /**【用户登录信息验证】**/
    public Tuser validateUserData(Tuser user);

    /**【通过ID修改用户信息】**/
    public void updateUserByID(Tuser user);

    /**【新增用户】**/
    public void insertNewUser(Tuser user);

    /**【通过ID删除用户】**/
    public void deleteUserByUserID(String userID);
}
