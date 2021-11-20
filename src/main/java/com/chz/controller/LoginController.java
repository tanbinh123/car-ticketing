package com.chz.controller;

import com.alibaba.fastjson.JSONObject;
import com.chz.Result.Result;
import com.chz.pojo.Admin;
import com.chz.pojo.User;
import com.chz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author snicker
 * @date 2021/11/10 16:39
 * @Describe
 */
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录
     * @param jsonObject
     * @return
     */
    @PostMapping("/login")
    @GetMapping("/login")
    @ResponseBody
    public Result login(@RequestBody JSONObject jsonObject){
        User user = new User();
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("username");
        user.setPassword(password);
        user.setUsername(username);
        Result result = loginService.loginIN(user);
        return result;
    }

    /**
     * 用户注册
     * @param userData
     * @return
     */
    @PostMapping("/regist")
    public Result registUser(@RequestBody User userData){
        return loginService.registUser(userData);
    }

    /**
     * 管理员登录
     * @param jsonObject
     * @return
     */
    @PostMapping("/loginAdmin")
    @GetMapping("/loginAdmin")
    @ResponseBody
    public Result loginAdmin(@RequestBody JSONObject jsonObject){
        Admin admin = new Admin();
        String password = jsonObject.getString("password");
        String username = jsonObject.getString("username");
        admin.setPassword(password);
        admin.setUsername(username);
        Result result = loginService.loginAdminIn(admin);
        return result;
    }



}
