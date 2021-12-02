package com.chz;

import com.chz.dao.OrderDao;
import com.chz.dao.UserDao;
import com.chz.pojo.MoneySum;
import com.chz.pojo.OrderReturn;
import com.chz.pojo.User;
import com.chz.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CarTicketingApplicationTests {

	@Autowired
	OrderDao orderDao;

	@Autowired
	UserDao userDao;

	@Autowired
	OrderService orderService;

	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	void contextLoads() {

		OrderReturn orderReturn = orderService.shareEmail("aa", "G116");

		String trueName = orderReturn.getTrueName();
		String idCardNum = orderReturn.getIdCardNum();
		String orginLocation = orderReturn.getOrginLocation();
		String destinationLocation = orderReturn.getDestinationLocation();
		String startTime = orderReturn.getStartTime();
		String reachTime = orderReturn.getReachTime();
		Double ticketPrice = orderReturn.getTicketPrice();
		String status = orderReturn.getStatus();
		if(status=="1"){
			status="未支付";
		}else if(status=="2"){
			status="已支付";
		}else{
			status="已退票";
		}

		String s1 = "姓名："  + trueName + "\n"
				+ "身份证号：" + idCardNum + "\n"
				+ "起始站：" + orginLocation + "\n"
				+ "终点站：" + destinationLocation + "\n"
				+ "起始时间：" + startTime + "\n"
				+ "到达时间：" + reachTime + "\n"
				+ "票价：" + ticketPrice + "\n"
				+ "状态：" + status + "\n"
				;
		System.out.println(s1);
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setSubject("snicker，你好");
		//mailMessage.setText(String.valueOf(orderReturn));
		mailMessage.setText(s1);
		mailMessage.setTo("1224228911@qq.com");
		mailMessage.setFrom("2423545283@qq.com");

		mailSender.send(mailMessage);
	}

	@Test
	void gogo(){
		OrderReturn orderReturn = orderDao.shareEmail("555", "K915");
		System.out.println(orderReturn);
	}


	@Test
	void gogo1(){
		Integer pageSize=5;
		PageHelper.startPage(1,pageSize);
		List<MoneySum> moneySums = orderService.moneysum();
		PageInfo<MoneySum> pageInfo = new PageInfo(moneySums);
		Map<String, Object> modelMap=new HashMap<>();
		System.out.println(pageInfo);
	}

}
