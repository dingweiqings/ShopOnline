package com.etc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.biz.ShopcartBiz;

import com.etc.entity.QTrolley;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		delectQTrolleyByid();
	}
	public static void getAllQtrolley(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ShopcartBiz shopcartBiz=(ShopcartBiz) applicationContext.getBean("shopcartBiz");
		List<QTrolley> list=shopcartBiz.getAllQtrolley(1);
		
		for (QTrolley qtrolley : list) {
			System.out.println(qtrolley.getQCloth().getClodetail());
		}
	}
	public static void updateQtrolley(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ShopcartBiz shopcartBiz=(ShopcartBiz) applicationContext.getBean("shopcartBiz");
		boolean flag=shopcartBiz.updateQtrolley(1, 3);
		
		System.out.println(flag);
	}
	public static void delectQTrolleyByid(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ShopcartBiz shopcartBiz=(ShopcartBiz) applicationContext.getBean("shopcartBiz");
		boolean flag=shopcartBiz.delectQTrolleyByid(1);
		
		System.out.println(flag);
	}
}
