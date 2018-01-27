package com.etc.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.impl.QActivityBizImpl;
import com.etc.entity.QActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class QActivityAction {
	@Autowired
  private QActivityBizImpl qActivityBiz;	
   private int activityid;
	public QActivityBizImpl getqActivityBiz() {
	return qActivityBiz;
}




public void setqActivityBiz(QActivityBizImpl qActivityBiz) {
	this.qActivityBiz = qActivityBiz;
}




public int getActivityid() {
	return activityid;
}




public void setActivityid(int activityid) {
	this.activityid = activityid;
}




	public String getQActivitys(){
		HttpServletResponse  res =ServletActionContext.getResponse() ;
	    res.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
		try {
			out=res.getWriter();
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	List<QActivity> list=qActivityBiz.getAllActivity();
					
		Gson gson=new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		String str=gson.toJson(list);
		System.out.println(str);
		out.write(str);
		out.flush();
		out.close();
		return "SUCCESS";
	}
	
	
	
	
	public String  getTotalPage(){
		
		return "SUCCESS";
	}
	
	public String  deleteQActivity(){
		System.out.println(" action deleteQActivity 50");
		qActivityBiz.deleteQActivityById(this.activityid);		
		System.out.println(" action deleteQActivity 52");
		return "SUCCESS";
	}
	
	
	
}
