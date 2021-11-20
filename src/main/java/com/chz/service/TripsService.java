package com.chz.service;

import com.chz.Result.Result;
import com.chz.pojo.Trips;
import com.github.pagehelper.Page;

import java.sql.ResultSet;

/**
 * @author snicker
 * @date 2021/11/12 10:35
 * @Describe
 */
public interface TripsService {

    /**
     * 管理员分页查询全部车票
     * @return
     */
    public Page<Trips> getAllTripsForAdmin();

    /**
     * 管理员后台添加车次
     * @param trips
     * @return
     */
    public int saveTrip(Trips trips);

    /**
     * 编辑车次信息
     * @param trips
     * @return
     */
    public int updateTripForAdmin(Trips trips);

    /**
     * 后台根据id删除车次
     * @param id
     * @return
     */
    public int delTrip(Integer id);

    /**
     * 查询所有票的信息
     * @param trips
     * @return
     */
    public Result getAlltrips(Trips trips);

    ///**
    // * 查询目标票的信息
    // * @param trips
    // * @return
    // */
    //public Result getAimtrips(Trips trips);

    /**
     * 买票后，票数减一
     * @param id
     * @return
     */
    public int decreaseTicketNum(Integer id);

    /**
     * 退票后，票数加一
     * @param id
     * @return
     */
    public int increaseTicketNum(Integer id);



}


















