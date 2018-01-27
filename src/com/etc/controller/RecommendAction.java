package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.RecommendBiz;

import com.etc.entity.QCloth;
import com.google.gson.Gson;

public class RecommendAction {
	@Autowired
	private RecommendBiz recommendBiz;
	
	private int clothid;
	
	

	public int getClothid() {
		return clothid;
	}



	public void setClothid(int clothid) {
		this.clothid = clothid;
	}



	public void getbestcloths(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<QCloth> clos= recommendBiz.getBestClos(clothid);
		System.out.println("sizeeeeeeeeeeeeeeeeeeeeeeeeee"+clos.size());
		Gson gson=new Gson();
		String temp= gson.toJson(clos);
		System.out.println(temp);
		out.write(temp);
		
		out.flush();
		out.close();
		
	}
	
	
	public void getsimilarcloths(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<QCloth> clos= recommendBiz.getSimilarClos(clothid);
		Gson gson=new Gson();
		String temp= gson.toJson(clos);
		System.out.println(temp);
		out.write(temp);
		
		out.flush();
		out.close();
		
	}
	
	
	public void getnewcloths(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out=null;
		try {
			out=response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<QCloth> clos= recommendBiz.getNewClos(clothid);
		Gson gson=new Gson();
		String temp= gson.toJson(clos);
		System.out.println(temp);
		out.write(temp);
		
		out.flush();
		out.close();
		
	}
	
}
