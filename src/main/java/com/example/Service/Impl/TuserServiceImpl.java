package com.example.Service.Impl;

import com.example.Damain.Tuser;
import com.example.Mapper.TuserMapper;
import com.example.Service.TuserService;
import com.example.Utils.TuserUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuserServiceImpl implements TuserService {

    @Autowired
    private TuserMapper userMapper;

    /**【获取所有用户信息】**/
    @Override
    public List<Tuser> ListUser(String realName) {
        return userMapper.ListUser(realName);
    }

    /**【通过ID拿到用户信息】**/
    @Override
    public Tuser selectUserByID(String userID) {
        return userMapper.selectUserByID(userID);
    }

    /**【通过登录名精确查找用户信息】**/
    @Override
    public Tuser selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    /**【用户登录信息验证】**/
    @Override
    public Tuser validateUserData(Tuser user) {
        return userMapper.validateUserData(user.getUserName(),user.getPassword());
    }

    /**【通过ID修改用户信息】**/
    @Override
    public void updateUserByID(Tuser user) {
        userMapper.updateUserByID(user.getRealName(),user.getPhone(),user.getAddress(),user.getSex(),user.getPassword(),
                user.getUserName(),user.getIsAdmin(),user.getStatus(),user.getUserID());
    }

    /**【新增用户】**/
    @Override
    public void insertNewUser(Tuser user) {
        userMapper.insertNewUser(user.getUserName(),user.getRealName(),user.getPassword(),user.getSex(),user.getPhone(),
                user.getIsAdmin(),user.getAddress(),user.getStatus());
    }

    /**【通过ID删除用户】**/
    @Override
    public void deleteUserByUserID(String userID) {
        userMapper.deleteUserByUserID(userID);
    }
}
