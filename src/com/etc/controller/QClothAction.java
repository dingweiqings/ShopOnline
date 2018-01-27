package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.QClothBiz1;

import com.etc.entity.QCloth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class QClothAction {
	private int pagenum;
	private int pagecount;
	private int cloid;
	
	@Autowired
	private QClothBiz1 qClothBiz;

	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	
	public int getCloid() {
		return cloid;
	}
	public void setCloid(int cloid) {
		this.cloid = cloid;
	}
	public  void getQCloths(){
	///解析数据
		
		 HttpServletResponse  res=   ServletActionContext.getResponse();
		 res.setCharacterEncoding("utf-8");
		 PrintWriter  out=null;
		 try {
			  out= res.getWriter();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 List<QCloth>  list=qClothBiz.getQClothByPage(pagenum, pagecount);
		
		 Gson gson=new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		 String str= gson.toJson(list);
		 System.out.println(str);
		 out.write(str);
		 out.flush();
		 out.close();
		
		return;
	}
	
	
	//获取总页数
	public  void getTotalPage(){
		 HttpServletResponse  res=   ServletActionContext.getResponse();
		 res.setCharacterEncoding("utf-8");
		 PrintWriter  out=null;
		 try {
			  out= res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 int temp=qClothBiz.getPageCounts(pagecount);
		
		 out.write(temp+"");
		 out.flush();
		 out.close();
		return ;
		
	}
	
	public void deleteQCloth(){
		 boolean b=false; 
		 b=qClothBiz.deleteQClothisOK(cloid);
		 if (b) {
			System.out.println("删除成功");
		}
		 else {
			 System.out.println("删除失败");
		}
	}
}
