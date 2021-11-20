package com.chz.dao;

import com.chz.pojo.Trips;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author snicker
 * @date 2021/11/12 10:27
 * @Describe
 */
@Mapper
public interface TripsDao {

    /**
     * 管理员分页查询全部车票
     * @return
     */
    Page<Trips> getAllTripsForAdmin();

    /**
     * 管理员在后台添加车次
     * @param trips
     * @return
     */
    @Insert("insert into trips (orgin_location, destination_location, start_time, reach_time, span_days, car_num, ticket_price, ticket_num) values(#{orginLocation}, #{destinationLocation}, #{startTime}, #{reachTime}, #{spanDays}, #{carNum}, #{ticketPrice}, #{ticketNum})")
    public int saveTrip(Trips trips);

    /**
     * 编辑车次信息
     * @param trips
     * @return
     */
    public int updateTripForAdmin(Trips trips);

    /**
     * 管理员根据id删除车次
     * @param id
     * @return
     */
    @Delete("delete from trips where id=#{id}")
    public Integer deleteTrip(Integer id);

    ///**
    // * 查询目标车票信息
    // * @param trips
    // * @return
    // */
    //@Select("select * from trips where start_time like CONCAT('%',#{startTime},'%') and car_num=#{carNum}")
    //public Trips getAimtrips(Trips trips);

    /**
     * 查询目标车票信息
     * @param trips
     * @return
     * */
    @Select("select * from trips where orgin_location like CONCAT('%',#{orginLocation},'%') and destination_location like CONCAT('%',#{destinationLocation},'%') and start_time like CONCAT('%',#{startTime},'%')")
    List<Trips> getAlltrips(Trips trips);

    /**
     * 买票后，票数减一
     * @param id
     * @return
     */
    @Update("update `trips` set ticket_num = ticket_num-1 where id=#{id};")
    public int decreaseTicketNum(Integer id);

    /**
     * 退票后，票数加一
     * @param id
     * @return
     */
    @Update("update `trips` set ticket_num = ticket_num+1 where id=#{id};")
    public int increaseTicketNum(Integer id);





}





















