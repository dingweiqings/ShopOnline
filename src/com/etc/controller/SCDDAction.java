package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.GwCartBiz;
import com.etc.entity.QUser;
import com.google.gson.Gson;

/**
 * 生成订单
 * 
 * @author 丁为庆
 * 
 */
public class SCDDAction {
	@Autowired
	private GwCartBiz gwCartBiz;
	private HttpSession session;
	private String chk_value;// 从前端传来的加入定单的定单详细表的id数组

	public String getChk_value() {
		return chk_value;
	}

	public void setChk_value(String chk_value) {

		this.chk_value = chk_value;
	}
	public  String getDingdanPrice(int userid){		
		
		return "SUCCESS";
	}
	

	/**
	 * 	 判断该商品的库存是否足够 ,计算商品的实际价格，添加进对应的商品详细表
	 */
	public void getDingDan() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// 得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String a[] = chk_value.split(",");
		int id[] = new int[a.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(a[i]);
		boolean flag = gwCartBiz.updateQuserelprice(id[i]);
		//判断库存是否足够
		if(!flag) {
			String cloname = gwCartBiz.getQOrderdetailByid(id[i])
					.getQCloth().getCloname();
			out.write(cloname + ":库存不足");
			out.flush();
			out.close();
			return;
		}
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		//获得商品的真实价格,并写入realPrice列
		for(int i=0;i<id.length;i++) {
			gwCartBiz.updateQuserelprice(id[i]);
		}
		
		for(int i=0;i<id.length;i++) {
			gwCartBiz.updateQuserelprice(id[i]);
		}
		
		
		
		//int qdorder = gwCartBiz.insertOneOrdered(userid, id);
//		for (int i = 0; i < id.length; i++) {
//			if (!gwCartBiz.updateOrdertoOrdered(id[i], qdorder)) {
//				out.write("fail");
//				out.flush();
//				out.close();
//				return;
//			}
//		}
		
		out.write("ok");
		out.flush();
		out.close();
		return;
	}
   public void calculteAllMoney() {
		String a[] = chk_value.split(",");
		int id[] = new int[a.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(a[i]);
	   double allMoney=gwCartBiz.getAllMoney(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// 得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		out.write(allMoney+"");
		out.flush();
		out.close();
		
   }
   }
	
	
	/**
	 * 提交订单，判断用户账户余额是否足够支付,并修改用户的账户余额
	 */
	public void tijiao() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// 得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/* 计算出所有被选中的商品的总价,判断用户账号余额是否足够 */
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		int qdorderid = gwCartBiz.newOrdered(userid);
		boolean flag = gwCartBiz.userMoneyOk(userid, qdorderid);
		if (flag) {
			/* 修改用户账户余额等操作 */
			if(gwCartBiz.updateQCloth()
					&&gwCartBiz.updateUsermoney(userid, qdorderid)){
				out.write("ok");
			}
		} else {
			out.write("MoneyIsNotEnough");
		}
		out.flush();
		out.close();
		return;
	}
	
	public void getUser(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// 得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/* 计算出所有被选中的商品的总价,判断用户账号余额是否足够 */
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		QUser qUser=gwCartBiz.getUser(userid);
		Gson gson=new Gson();
		String str=gson.toJson(qUser);
		out.write(str);
		out.flush();
		out.close();
		return;
	}
}
