package com.example.Utils;

import com.example.Damain.Tuser;
import net.sf.json.JSONObject;

public class TuserUtils {

    /**【用户登录验证JSON数据】**/
    public static Tuser validateUserData(String loginVal){
        Tuser userInfo = null;
        if (!loginVal.equals("")){
            userInfo = new Tuser();
            JSONObject jsonData = JSONObject.fromObject(loginVal);
            userInfo.setUserName(jsonData.getString("username"));
            userInfo.setPassword(jsonData.getString("password"));
        }
        return userInfo;
    }

    /**【用户自行编辑个人信息】**/
    public static Tuser editPersonalData(String personalData){
        Tuser userData = null;
        if (!personalData.equals("")){
            System.out.println("【用户自行修改信息】" + personalData);
            userData = new Tuser();
            JSONObject validateData = JSONObject.fromObject(personalData);
            String realName = validateData.getString("realName");
            String phone = validateData.getString("phone");
            String address = validateData.getString("address");
            String sex = validateData.getString("sex");
            String userID = validateData.getString("userID");
            String oldPass = validateData.getString("oldPass");
            String newPass = validateData.getString("newPass");
            String newPassWord = validateData.getString("newPassWord");

            userData.setRealName(realName);
            userData.setAddress(address);
            userData.setPhone(phone);
            userData.setSex(sex);
            userData.setUserID(userID);
            userData.setPassword(newPassWord);
        }
        return userData;
    }

    /**【管理员编辑个人信息】**/
    public static Tuser managerPersonalData(String personalData){
        Tuser userData = null;
        if (!personalData.equals("")){
            System.out.println("【管理员修改用户信息】" + personalData);
            userData = new Tuser();
            JSONObject validateData = JSONObject.fromObject(personalData);
            userData.setRealName(validateData.getString("realName"));
            userData.setUserName(validateData.getString("userName"));
            userData.setAddress(validateData.getString("address"));
            userData.setPhone(validateData.getString("phone"));
            userData.setSex(validateData.getString("sex"));
            userData.setIsAdmin(validateData.getString("isAdmin"));
            userData.setStatus(validateData.getString("status"));
            userData.setUserID(validateData.getString("userID"));
            if (personalData.contains("resetPassWord")){
                userData.setPassword(validateData.getString("resetPassWord"));
            }else {
                userData.setPassword(validateData.getString("password"));
            }
        }
        return userData;
    }

    /**【新增用户】**/
    public static Tuser insetNewUser(String insertUserData){
        Tuser user = null;
        if (!insertUserData.equals("")){
            user = new Tuser();
            System.out.println("【插入数据用户信息】" + insertUserData);
            JSONObject insertData = JSONObject.fromObject(insertUserData);
            user.setRealName(insertData.getString("realName"));
            user.setUserName(insertData.getString("userName"));
            user.setAddress(insertData.getString("address"));
            user.setPhone(insertData.getString("phone"));
            user.setSex(insertData.getString("sex"));
            user.setStatus(insertData.getString("status"));
            user.setIsAdmin(insertData.getString("isAdmin"));
            if (insertUserData.contains("resetPassWord")){
                user.setPassword(insertData.getString("resetPassWord"));
            }else{
                user.setPassword(insertData.getString("password"));
            }
        }
        LogUserAllData(user);
        return user;
    }


    /**【打印用户所有信息】**/
    public static void LogUserAllData(Tuser user){
        if (user != null){
            System.out.println("TuserUtils.LogUserAllData --->用户名\t" + user.getUserName());
            System.out.println("TuserUtils.LogUserAllData --->密码\t" + user.getPassword());
            System.out.println("TuserUtils.LogUserAllData --->电话\t" + user.getPhone());
            System.out.println("TuserUtils.LogUserAllData --->真实姓名\t" + user.getRealName());
            System.out.println("TuserUtils.LogUserAllData --->性别\t" + user.getSex());
            System.out.println("TuserUtils.LogUserAllData --->是否是管理员\t" + user.getIsAdmin());
            System.out.println("TuserUtils.LogUserAllData --->用户识别ID\t" + user.getUserID());
            System.out.println("TuserUtils.LogUserAllData --->用户住址\t" + user.getAddress());
            System.out.println("TuserUtils.LogUserAllData --->账号状态\t" + user.getStatus());
        }else{
            System.out.println("TuserUtils.LogUserAllData --->\t用户不存在！");
        }
    }
}
