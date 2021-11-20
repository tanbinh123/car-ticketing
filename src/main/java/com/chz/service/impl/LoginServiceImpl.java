package com.chz.service.impl;

import com.chz.Result.Result;
import com.chz.dao.AdminDao;
import com.chz.dao.UserDao;
import com.chz.pojo.Admin;
import com.chz.pojo.User;
import com.chz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author snicker
 * @date 2021/11/10 16:37
 * @Describe
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminDao adminDao;

    @Override
    public Result loginIN(User userData) {
        Result result = new Result();
        User user=userDao.getUserByUsername(userData.getUsername());

        if(user==null){
            result.setData(null);
            result.setMsg("用户不存在");
            result.setStateCode(404);
            return result;
        }
        if(!user.getPassword().equals(userData.getPassword())){
            result.setMsg("密码错误");
            result.setStateCode(404);
            return result;
        }
        result.setStateCode(200);
        result.setMsg("登录成功");
        result.setData(user);
        return result;
    }

    @Override
    @Transactional
    public Result registUser(User userData) {
        Result result = new Result();
        if(userDao.insertUserRegisterInfo(userData)==1){
            result.setStateCode(200);
            result.setMsg("注册成功");
            result.setData(userData.getUsername());
        }else {
            result.setStateCode(400);
            result.setMsg("注册失败，用户名已经存在");
            result.setData(false);
        }

        return result;
    }


    @Override
    public Result


    loginAdminIn(Admin adminData) {
        Result result = new Result();
        Admin admin = adminDao.getAdminByUsername(adminData.getUsername());

        if(admin==null){
            result.setData(null);
            result.setMsg("用户不存在");
            result.setStateCode(404);
            return result;
        }
        if(!admin.getPassword().equals(adminData.getPassword())){
            result.setMsg("密码错误");
            result.setStateCode(404);
            return result;
        }
        result.setStateCode(200);
        result.setMsg("登录成功");
        result.setData(admin);
        return result;
    }
}
