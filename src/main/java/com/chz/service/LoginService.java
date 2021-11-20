package com.chz.service;

import com.chz.Result.Result;
import com.chz.pojo.Admin;
import com.chz.pojo.User;

import java.sql.ResultSet;

/**
 * @author snicker
 * @date 2021/11/10 16:34
 * @Describe
 */
public interface LoginService {

    /**
     * 用户登录验证
     * @param userData
     * @return
     */
    public Result loginIN(User userData);

    /**
     * 注册用户
     * @param userData
     * @return
     */
    public Result registUser(User userData);

    /**
     * 管理员登录验证
     * @param adminData
     * @return
     */
    public Result loginAdminIn(Admin adminData);




}
