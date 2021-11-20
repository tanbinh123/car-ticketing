package com.chz.service.impl;

import com.chz.dao.OrderDao;
import com.chz.pojo.Order;
import com.chz.pojo.OrderReturn;
import com.chz.service.OrderService;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.OffsetDateTime;

/**
 * @author snicker
 * @date 2021/11/12 16:43
 * @Describe
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;


    @Override
    public int saveOrderPaying(Order order) {
        return orderDao.saveOrderPaying(order);
    }

    @Override
    public int saveOrderPayed(int orderId) {
        return orderDao.saveOrderPayed(orderId);
    }

    @Override
    public Page<OrderReturn> getOrder(String username) {
        return orderDao.getOrder(username);
    }

    @Override
    public Page<OrderReturn> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public int updateOrderStatus(Order order) {
        return orderDao.updateOrderStatus(order);
    }

    @Override
    public int selectOrderStatus(Order order) {
        return orderDao.selectOrderStatus(order);
    }

    @Override
    public int selectTripId(Order order) {
        return orderDao.selectTripId(order);
    }

    @Override
    public Integer deleteOrder(Integer id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public OrderReturn shareEmail(String username, String carNum) {
        return orderDao.shareEmail(username,carNum);
    }
}
























