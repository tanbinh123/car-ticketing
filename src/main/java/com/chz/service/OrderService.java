package com.chz.service;

import com.chz.pojo.MoneySum;
import com.chz.pojo.Order;
import com.chz.pojo.OrderReturn;
import com.chz.pojo.Trips;
import com.github.pagehelper.Page;

/**
 * @author snicker
 * @date 2021/11/12 16:43
 * @Describe
 */
public interface OrderService {

    /**
     * 下订单（状态：未支付）status=1
     * @param order
     * @return
     */
    public int saveOrderPaying(Order order);

    /**
     * 支付完成后，status改为2
     * @param orderId
     * @return
     */
    public int saveOrderPayed(int orderId);

    /**
     * 查询订单
     * @param username
     * @return
     */
    public Page<OrderReturn> getOrder(String username);

    /**
     * 后台得到所有的订单
     * @return
     */
    public Page<OrderReturn> getAllOrders();

    /**
     * 后台改变订单的状态
     * @param order
     * @return
     */
    public int updateOrderStatus(Order order);

    /**
     * 查询订单的状态
     * @param order
     * @return
     */
    public int selectOrderStatus(Order order);

    /**
     * 查询订单的车次id
     * @param order
     * @return
     */
    public int selectTripId(Order order);

    /**
     * 后台删除单个订单
     * @param id
     * @return
     */
    public Integer deleteOrder(Integer id);

    /**
     * 通过用户名和车次查询详细的订单
     * @param username
     * @param carNum
     * @return
     */
    public OrderReturn shareEmail(String username,String carNum);

    public Page<MoneySum> moneysum();

}




















