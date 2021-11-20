package com.chz;

import com.chz.dao.OrderDao;
import com.chz.dao.UserDao;
import com.chz.pojo.OrderReturn;
import com.chz.pojo.User;
import com.chz.service.OrderService;
import com.github.pagehelper.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

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

		/*Page<OrderReturn> order = orderDao.getOrder("555");
		System.out.println(order);*/

		OrderReturn orderReturn = orderService.shareEmail("1", "T1126");

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setSubject("snicker，你好");
		mailMessage.setText(String.valueOf(orderReturn));

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
		User wm = userDao.getPersonInfoByUsername("wm");
		System.out.println(wm);
	}

}
