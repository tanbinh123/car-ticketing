package com.chz.controller;

import com.alibaba.fastjson.JSONObject;
import com.chz.Result.Result;
import com.chz.pojo.MoneySum;
import com.chz.pojo.Order;
import com.chz.pojo.OrderReturn;
import com.chz.pojo.User;
import com.chz.service.OrderService;
import com.chz.service.TripsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author snicker
 * @date 2021/11/12 16:48
 * @Describe
 */
@RestController
@CrossOrigin
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private TripsService tripsService;

    @Autowired
    JavaMailSenderImpl mailSender;

    /**
     * 下订单，未支付，status=1
     * @param jsonObject
     * @return
     */
    @Transactional
    @RequestMapping(value = "/saveOrderPaying",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteOrder(@RequestBody JSONObject jsonObject){
        int carInfoId = jsonObject.getInteger("car_info_id");
        int personId = jsonObject.getInteger("person_id");
        Order order = new Order();
        order.setCarInfoId(carInfoId);
        order.setPersonId(personId);
        order.setChangeTimes(0);
        order.setStatus(1);
        Map<String, Object> modelMap = new HashMap<>();
        try {
            //此处应该获产生订单后的id号
            int i = orderService.saveOrderPaying(order);
            int j = tripsService.decreaseTicketNum(carInfoId);
            System.out.println(j);
            int orderId = order.getId();
            System.out.println(i);
            if (i == 1){
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "success");
                dataMap.put("entity", orderId);
                modelMap.put("data", dataMap);
            }else {
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "购买失败");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }
        }catch (Exception e){
            modelMap.put("code", 500);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", e.fillInStackTrace());
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    @Transactional
    @RequestMapping(value = "/saveOrderPayed/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> saveOrderPayed(@PathVariable("id") Integer id){
        Map<String, Object> modelMap = new HashMap<>();
        try {
            int i = orderService.saveOrderPayed(id);

            if (i == 1){
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "success");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }else {
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "操作失败");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }
        }catch (Exception e){
            modelMap.put("code", 500);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", e.fillInStackTrace());
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 通过用户名得到订单（分页）
     * @param username
     * @param pn
     * @return
     */
    @GetMapping("/getorder")
    public Map<String, Object> getOrder(@RequestParam(defaultValue="1",required=true,value="pn")Integer pn,@RequestParam String username){
        //每页显示记录数
        Integer pageSize=10;
        //分页查询，注意顺序，startPage()方法放前面
        PageHelper.startPage(pn, pageSize);
        //获取所用用户信息
        Page<OrderReturn> allOrder = orderService.getOrder(username);
        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。封装了详细的分页信息,传入连续显示的页数
        PageInfo<OrderReturn> pageInfo=new PageInfo(allOrder);

        Map<String, Object> modelMap = new HashMap<>();
        if (pageInfo != null){
            modelMap.put("code", 200);
            modelMap.put("data", pageInfo);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "获取订单列表失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 后台得到所有的分页订单
     * @param pn
     * @return
     */
    @GetMapping("/getallorders")
    public Map<String, Object> getAllOrder(@RequestParam(defaultValue = "1",required = true,value = "pn") Integer pn){
        Integer pageSize=5;
        PageHelper.startPage(pn,pageSize);
        List<OrderReturn> allOrder = orderService.getAllOrders();
        PageInfo<OrderReturn> pageInfo = new PageInfo(allOrder);
        Map<String, Object> modelMap=new HashMap<>();
        if(pageInfo!=null){
            modelMap.put("code",200);
            modelMap.put("data",pageInfo);
        }else {
            modelMap.put("code",200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "获取订单列表失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 后台改变订单的状态
     * @param order
     * @return
     */
    @RequestMapping(value = "/updateorder",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody Order order){
        int i = orderService.updateOrderStatus(order);
        int status1=orderService.selectOrderStatus(order);
        //System.out.println(status1);
        if(status1==3){
            int tripid=orderService.selectTripId(order);
            int j=tripsService.increaseTicketNum(tripid);
        }
        Map<String, Object> modelMap = new HashMap<>();
        if (i == 1){
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "success");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "获取model列表失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    /**
     * 后台删除单个订单
     * @param id
     * @return
     */
    @Transactional
    @RequestMapping(value = "/deleteOrder/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteOrder(@PathVariable("id")Integer id){
        Map<String, Object> modelMap = new HashMap<>();
        //删除用户
        try {
            int i = orderService.deleteOrder(id);
            if (i == 1){
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "success");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }else {
                modelMap.put("code", 200);
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("message", "删除失败");
                dataMap.put("entity", null);
                modelMap.put("data", dataMap);
            }
        }catch (Exception e){
            modelMap.put("code", 500);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", e.fillInStackTrace());
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }

    @PostMapping("/sendEmail")
    @GetMapping("/sendEmail")
    @ResponseBody
    public Map<String, Object> login(@RequestBody JSONObject jsonObject){

        Map<String, Object> modelMap = new HashMap<>();

        String yourEmail=jsonObject.getString("yourEmail");
        String username=jsonObject.getString("username");
        String shareCarNum=jsonObject.getString("shareCarNum");
        OrderReturn orderReturn=orderService.shareEmail(username,shareCarNum);

        if(orderReturn!=null){
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "success");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }else {
            modelMap.put("code", 200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "删除失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("snicker，你好");
        mailMessage.setText(String.valueOf(orderReturn));

        mailMessage.setTo(yourEmail);
        mailMessage.setFrom("2423545283@qq.com");

        mailSender.send(mailMessage);

        return modelMap;
    }

    @GetMapping("/moneysum")
    public Map<String, Object> moneysum(@RequestParam(defaultValue = "1",required = true,value = "pn") Integer pn){
        Integer pageSize=5;
        PageHelper.startPage(pn,pageSize);
        List<MoneySum> moneySums = orderService.moneysum();
        PageInfo<OrderReturn> pageInfo = new PageInfo(moneySums);
        Map<String, Object> modelMap=new HashMap<>();
        if(pageInfo!=null){
            modelMap.put("code",200);
            modelMap.put("data",pageInfo);
        }else {
            modelMap.put("code",200);
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("message", "获取财务列表失败");
            dataMap.put("entity", null);
            modelMap.put("data", dataMap);
        }
        return modelMap;
    }




}



























