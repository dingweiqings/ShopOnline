package com.etc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etc.biz.GwCartBiz;

import com.etc.dao.GwCartDao;
import com.etc.entity.QOrderdetail;

public class Test1 {
	public static void main(String[] args) {
		getSum();
	}
	public static void getOid(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		GwCartBiz gwCartBiz=(GwCartBiz) applicationContext.getBean("gwCartBiz");
		int temp=gwCartBiz.getOneOrder(3);
		System.out.println(temp);
	}
	public static void insertQOrderdetail(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		GwCartBiz gwCartBiz=(GwCartBiz) applicationContext.getBean("gwCartBiz");
		boolean flag=gwCartBiz.insertQOrderdetail(31, 1, 2, "x");
		System.out.println(flag);
	}
	public static void getQOrderdetail(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		GwCartBiz gwCartBiz=(GwCartBiz) applicationContext.getBean("gwCartBiz");
		List<QOrderdetail> list=gwCartBiz.getQOrderdetail(31);
		for (QOrderdetail qOrderdetail : list) {
			System.out.println(qOrderdetail.getOrderprice());
		}
	}
	public static void getSum(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		GwCartDao gwCartDao=(GwCartDao) applicationContext.getBean("gwCartDao");
		int[] a={32};
		int temp=0;
		try {
			temp = gwCartDao.getAllMoney(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(temp);
	}
}
