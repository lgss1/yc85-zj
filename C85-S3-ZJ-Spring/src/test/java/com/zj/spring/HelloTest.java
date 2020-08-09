package com.zj.spring;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zj.spring.dao.UserDao;


public class HelloTest {
	
	@Test
	public void test() {
		//����spring��������
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		Hello h=(Hello) ctx.getBean("hello");
		h.sayHello();
		ctx.close();
	}
	
	@Test
	public void test1() {
		//����spring��������
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		UserDao udao1=(UserDao) ctx.getBean("mdao");
		UserDao udao2=(UserDao) ctx.getBean("odao");
		
		udao1.selectByUser("����");
		udao2.selectByUser("����");
		
		ctx.close();
	}

}
