package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.QClothBiz;

import com.etc.entity.QCloth;
import com.google.gson.Gson;

public class ClothAction {
	private int pagenum;
	private int pagecount;
	@Autowired
	private QClothBiz qClothBiz;
	
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
	
	public void getCloths(){
		HttpServletResponse res=ServletActionContext.getResponse();
		 res.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out=res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<QCloth> list=qClothBiz.getClothByPage(pagenum, pagecount);
		Gson gson=new Gson();
		String str=gson.toJson(list);
		System.out.println(str);
		out.write(str);
		out.flush();
		out.close();
	}
	
	public void getPages(){
     HttpServletResponse res=ServletActionContext.getResponse();
     PrintWriter out=null;
     try {
		out=res.getWriter();
	} catch (IOException e) {
		e.printStackTrace();
	}
      int temp=qClothBiz.getTotalPages(pagecount);
      String str=temp+" ";
      out.write(str);
	}
}
