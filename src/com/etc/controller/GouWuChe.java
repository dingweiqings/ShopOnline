package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.ShopcartBiz;

import com.etc.entity.QCloth;
import com.etc.entity.QTrolley;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

public class GouWuChe {
	@Autowired
	private ShopcartBiz shopcartBiz;
	private int trolleyid;
	public int getTrolleyid() {
		return trolleyid;
	}
	public void setTrolleyid(int trolleyid) {
		this.trolleyid = trolleyid;
	}

	/**
	 * 使用异步刷新取出购物车中的全部商品
	 */
	public void doAllOrder(){
		ActionContext actionContext=ActionContext.getContext();
		Map<String, Object> session=actionContext.getSession();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String str="";
		if(session.get("userid")!=null){
			int userid=(Integer) session.get("userid");//如果用户名存在，则从数据库中取出购物车数据
			List<QTrolley> list=shopcartBiz.getAllQtrolley(userid);
			Gson gson=new Gson();
			str=gson.toJson(list);
		}else{
			/*str="null";*/
			List<QTrolley> list=shopcartBiz.getAllQtrolley(1);
			QTrolley qTrolley=null;
			QCloth qCloth=null;
			for (int i = 0; i < list.size(); i++) {
				
				int cloid=list.get(i).getQCloth().getCloid();
				
				String cloname=list.get(i).getQCloth().getCloname();
				String clotype=list.get(i).getQCloth().getClotype();
				String clopic1=list.get(i).getQCloth().getClopic1();
				
				int cloprice=list.get(i).getQCloth().getCloprice();
				
				qCloth=new QCloth(cloid, cloname, clotype, clopic1, cloprice);
				
				int trolleyid=list.get(i).getTrolleyid();
				
				Date trolleydate=list.get(i).getTrolleydate();
				int trolleyprice=list.get(i).getTrolleyprice();
				int trolleynum=list.get(i).getTrolleynum();
				int trolleysum=list.get(i).getTrolleysum();
				qTrolley=new QTrolley(trolleyid, null, qCloth, trolleyprice, trolleynum, trolleysum, trolleydate);
				list.set(i, qTrolley);
			}
			Gson gson=new Gson();
			str=gson.toJson(list);
		}
		out.write(str);
		out.flush();
		out.close();
		return ;
	}
	/**
	 * 根据购物车id删除购物车中的对应记录
	 */
	public void dodelOrder(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;//得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(shopcartBiz.delectQTrolleyByid(trolleyid)){
			out.write(1+"");
		}else{
			out.write(0+"");
		}
		out.flush();
		out.close();
		return ;
		
	}
}
