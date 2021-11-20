package com.chz.dao;

import com.chz.pojo.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author snicker
 * @date 2021/11/10 16:29
 * @Describe
 */
@Mapper
public interface UserDao {

    /**
     * 通过username查询user的信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username);

    /**
     * 通过username查询user的个人部分信息，判断是否通过售票
     * @param username
     * @return
     */
    public User getPersonInfoByUsername(String username);

    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUserRegisterInfo(User user);

    /**
     *查询所有的用户信息
     * @return
     */
    Page<User> getAllUsers();

    /**
     * 在后台添加用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据用户名删除用户
     * @param username
     * @return
     */
    public Integer deleteUser(String username);

    /**
     * 用户自己完善个人信息
     * @param trueName
     * @param idCardNum
     * @param phoneNum
     * @param age
     * @param sex
     * @return
     */
    public int updateUserInfo(String username,String trueName,String idCardNum,String phoneNum,int age,String sex);




}
