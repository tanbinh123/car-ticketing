package com.chz.dao;

import com.chz.pojo.*;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

/**
 * @author snicker
 * @date 2021/11/12 16:36
 * @Describe
 */
@Mapper
public interface OrderDao {

    /**
     * 下订单（状态：未支付）
     * @param order
     * @return
     * @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id"): 表有id自增主键，插入数据后自动获取到该主键值
     */
    @Insert("INSERT INTO `order` (car_info_id, person_id, change_times, status) VALUES (#{carInfoId}, #{personId}, #{changeTimes}, #{status})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int saveOrderPaying(Order order);

    /**
     * 支付完成后，status改为2
     * @param orderId
     * @return
     */
    @Update("update `order` set status=2 where id=#{orderId}")
    public int saveOrderPayed(int orderId);

    /**
     * 通过用户查询订单
     * @param userName
     * @return
     */
    Page<OrderReturn> getOrder(String userName);

    /**
     * 后台得到所有的订单
     * @return
     */
    Page<OrderReturn> getAllOrders();

    /**
     * 后台改变订单的状态
     * @param order
     * @return
     */
    @Update("update `order` set status=#{status} where id=#{id}")
    public int updateOrderStatus(Order order);

    /**
     * 查询订单的状态
     * @param order
     * @return
     */
    @Select("select status from `order` where id=#{id}")
    public int selectOrderStatus(Order order);

    /**
     * 查询订单的车次id
     * @param order
     * @return
     */
    @Select("select car_info_id from `order` where id=#{id}")
    public int selectTripId(Order order);

    /**
     * 后台删除单个订单
     * @param id
     * @return
     */
    @Delete("delete from `order` where id=#{id}")
    public Integer deleteOrder(Integer id);

    /**
     * 通过用户名和车次查询详细的订单
     * @param username
     * @param carNum
     * @return
     */
    public OrderReturn shareEmail(String username,String carNum);

}




























