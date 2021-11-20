package com.chz.dao;

import com.chz.pojo.Admin;
import com.chz.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author snicker
 * @date 2021/11/10 17:15
 * @Describe
 */
@Mapper
public interface AdminDao {

    /**
     * 通过username查询admin的信息
     * @param username
     * @return
     */
    public Admin getAdminByUsername(String username);


}
