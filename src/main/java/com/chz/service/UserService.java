package com.chz.service;

import com.chz.Result.Result;
import com.chz.pojo.User;
import com.github.pagehelper.Page;

import java.sql.ResultSet;

/**
 * @author snicker
 * @date 2021/11/10 18:02
 * @Describe
 */
public interface UserService {

    /**
     * 查询所有的用户信息
     * @return
     */
    public Page<User> getAllUsers();


    /**
     * 后台保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 检查后台添加用户名的唯一性
     * @param username
     * @return
     */
    public User checkUserName(String username);

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user);

    /**
     * 根据用户名删除用户
     * @param username
     * @return
     */
    public int deleteUser(String username);

    /**
     * 通过用户名查询个人信息
     * @param username
     * @return
     */
    public Result getPersonInfo(String username);

    /**
     * 通过username查询user的个人部分信息，判断是否通过售票
     * @param name
     * @return
     */
    public Result getPersonInfoByUsername(String name);

    /**
     * 用户自己完善个人信息
     * @param trueName
     * @param idCardNum
     * @param phoneNum
     * @param age
     * @param sex
     * @return
     */
    public Result updateUserInfo(String username,String trueName,String idCardNum,String phoneNum,int age,String sex);

}
