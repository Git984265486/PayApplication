package com.example.Controller;

import com.example.Damain.Tuser;
import com.example.Service.TuserService;
import com.example.Utils.TuserUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
public class TuserController {
    @Autowired
    private TuserService userService;

    /**【列出所有用户】**/
    @RequestMapping("/ListUser")
    @ResponseBody
    public Map<String , Object> ListUser(@RequestParam(value = "realName",defaultValue = "") String realName,
                                         @RequestParam(value = "page",defaultValue = "1") int page,
                                         @RequestParam(value = "limit",defaultValue = "10")int size){
        Map<String , Object> map = new HashMap<>();
        PageHelper.startPage(page,size);        //List<Tuser> listUser = userService.ListUser(realName);
        PageInfo<Tuser> list = new PageInfo<>(userService.ListUser(realName));
        map.put("count",list.getTotal());
        map.put("listUser",list.getList());
        return map;
    }

    /**【通过用户ID返回用户信息】**/
    @RequestMapping("/selectUserByID")
    @ResponseBody
    public Map<String , Object> selectUserByID(@RequestParam(value = "userID",defaultValue = "") String userID){
        Map<String , Object> map = new HashMap<>();
        //System.out.println("前台传过来的用户ID：" + userID);
        String selectResult = "selectFail";
        Tuser user = userService.selectUserByID(userID);
        if (user != null){
            selectResult = "selectSuccess";
        }
        map.put("result",selectResult);
        map.put("userData",user);
        return map;
    }

    /**【账号登录验证】**/
    @RequestMapping("/validateUser")
    @ResponseBody
    public Map<String , Object> validateUser(@RequestParam(value = "loginVal",defaultValue = "") String loginVal){
        Map<String , Object> map = new HashMap<>();
        String validateResult = "validateFail";
        System.out.println("用户登录验证信息：" + loginVal);
        Tuser validateUser = TuserUtils.validateUserData(loginVal);
        Tuser userData = userService.validateUserData(validateUser);
        if (userData != null){
            validateResult = "validateSuccess";
        }
        map.put("result",validateResult);
        map.put("userData",userData);
        return map;
    }

    /**【修改个人信息】**/
    @RequestMapping("/editPersonalInfo")
    @ResponseBody
    public Map<String , Object> editPersonalInfo(@RequestParam(value = "personalData",defaultValue = "")String personalData){
        Map<String , Object> map = new HashMap<>();
        String editResult = "editFail";
        Tuser user =null;
        if (personalData.contains("newPassWord")){
            user = TuserUtils.editPersonalData(personalData);
        }else if (personalData.contains("status")){
            user = TuserUtils.managerPersonalData(personalData);
        }
        if (user != null){
            userService.updateUserByID(user);
            editResult = "editSuccess";
        }
        map.put("result",editResult);
        map.put("editData",user);
        return map;
    }

    /**【新增用户】**/
    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String , Object> insertUser(@RequestParam(value = "insertUserData",defaultValue = "") String insertUserData,
                                           @RequestParam(value = "page",defaultValue = "1") int page,
                                           @RequestParam(value = "limit",defaultValue = "10")int size){
        Map<String , Object> map = new HashMap<>();
        String insertResult = null;
        Tuser user = TuserUtils.insetNewUser(insertUserData);

        Tuser validateUser = userService.selectUserByUserName(user.getUserName());
        if (validateUser != null){
            System.out.println("新增用户失败，用户登录名已存在！");
            insertResult = "userExists";
        }else{
            userService.insertNewUser(user);
            insertResult = "insertSuccess";
        }
        PageHelper.startPage(page,size);
        List<Tuser> listUser = userService.ListUser("");
        PageInfo<Tuser> list = new PageInfo<>(listUser);
        map.put("listUser" , list.getList());
        map.put("count" , list.getTotal());
        map.put("result" , insertResult);
        return map;
    }

    /**【删除用户】**/
    @RequestMapping("/deleteUser")
    @ResponseBody
    public Map<String , Object> deleteUser(@RequestParam(value = "userID",defaultValue = "") String userID){
        Map<String , Object> map = new HashMap<>();
        String deleteResult = "deleteFail";
        if (!userID.equals("")){
            PageHelper.startPage(1,10);
            userService.deleteUserByUserID(userID);
            deleteResult = "deleteSuccess";
            List<Tuser> listUser = userService.ListUser("");
            PageInfo<Tuser> list = new PageInfo<>(listUser);
            map.put("listUser" , list.getList());
            map.put("count" , list.getTotal());
        }
        map.put("result" , deleteResult);
        return map;
    }
}
