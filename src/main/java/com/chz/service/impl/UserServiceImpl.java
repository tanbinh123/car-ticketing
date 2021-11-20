package com.chz.service.impl;

import com.chz.Result.Result;
import com.chz.dao.UserDao;
import com.chz.pojo.User;
import com.chz.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.ResultSet;

/**
 * @author snicker
 * @date 2021/11/10 18:04
 * @Describe
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Page<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public int saveUser(User user) {
        int i=userDao.saveUser(user);
        return i;
    }

    @Override
    public User checkUserName(String username) {
        return userDao.getUserByUsername(username);
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        int i = userDao.updateUser(user);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteUser(String username) {
        return userDao.deleteUser(username);
    }

    @Override
    public Result getPersonInfo(String username) {
        Result result = new Result();
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            result.setStateCode(400);
            result.setMsg("未填写个人信息，请前往个人信息页面完善个人信息");
            result.setData(null);
        } else {
            result.setStateCode(200);
            result.setMsg("查询成功，已填写个人信息");
            result.setData(user);
        }
        return result;
    }

    @Override
    public Result getPersonInfoByUsername(String username) {
        Result result = new Result();
        User user = userDao.getPersonInfoByUsername(username);
        if (user == null) {
            result.setStateCode(400);
            result.setMsg("未填写个人信息，请前往个人信息页面完善个人信息");
            result.setData(null);
        } else {
            result.setStateCode(200);
            result.setMsg("查询成功，已填写个人信息");
            result.setData(user);
        }
        return result;
    }

    @Transactional
    @Override
    public Result updateUserInfo(String username,String trueName, String idCardNum, String phoneNum, int age, String sex) {
        Result result = new Result();
        int i=userDao.updateUserInfo(username,trueName, idCardNum, phoneNum, age, sex);
        if(i<1){
            result.setMsg("update fail, please update again");
            result.setStateCode(404);
        }else {
            result.setMsg("update success");
            result.setStateCode(200);
            result.setData(true);
        }
        return result;
    }
}
























