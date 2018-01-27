package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.QUserBiz;
import com.etc.entity.QUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoginAction  {
	
	 private String qname;
	 private String qpassword;
	 private HttpSession session;
	 @Autowired
	 private QUserBiz qUserBiz;
	 
	    public String getQname() {
			return qname;
		}
		public void setQname(String qname) {
			this.qname = qname;
		}
		public String getQpassword() {
			return qpassword;
		}
		public void setQpassword(String qpassword) {
			this.qpassword = qpassword;
		}
	/**
	 * 判断是否登陆成功
	 * @return
	 */
	public String loginOk(){
		if(qUserBiz.isLoginOk(qname, qpassword)){
			HttpServletRequest request=ServletActionContext.getRequest();
		    session=request.getSession();
			//用户ip地址
			//String uip=request.getRemoteAddr();
			//session.setAttribute("qname", qname);//登陆的用户名
			//System.out.println("将qname"+qname+"放入Session中");
			String sid=session.getId();//SessionId
			session.setAttribute("sid", sid);
			int uid=0;
			try {
				uid = qUserBiz.getUserid(qname);
				System.out.println("用户名："+uid);
			} catch (Exception e) {
				System.out.println(e);
			}
			session.setAttribute("userid", uid);
			System.out.println("将uid"+uid+"放入Session中");
			
			return "success";
		}else{
			return "fail";
		}
	 }
	public void isLogin(){
		HttpServletResponse res=ServletActionContext.getResponse();
		res.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out=res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		System.out.println("LA.session:"+session.getId());
		if(session!=null){
			int uid=0;
			try {
				uid = (Integer) session.getAttribute("userid");
			} catch (Exception e) {
				System.out.println("未登陆");
			}
			System.out.println("LA.qid:"+uid);
			String qname;
			if(uid==0){
				qname=null;
			}else{
			 qname=qUserBiz.getUserName(uid);
			}
			if(qname!=null){
				out.write(qname);
				
			}else{
				out.write("");
				
			}
		}
		out.flush();
		out.close();
	}
	/**
	 * 根据用户名判断是否有该用户
	 * @return
	 */
     public void isQuser(){
    	 HttpServletResponse res= ServletActionContext.getResponse();
    	 PrintWriter out=null;
    	 try {
			out=res.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 String flag="fail";
    	 if(qUserBiz.getQuserByName(qname)){
    		 flag="success";
    	 }
    	 out.write(flag);
    	 out.flush();
    	 out.close();
     }
	 public void selQuser(){
		 HttpServletResponse res=ServletActionContext.getResponse();
		 HttpServletRequest request=ServletActionContext.getRequest();
		// request.setCharacterEncoding("utf-8");
		 res.setCharacterEncoding("utf-8");
		 
		 session=request.getSession();
		 String qname=null;
		 try {
			    int uid=(Integer) session.getAttribute("userid");
			    qname=qUserBiz.getUserName(uid);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(qname);
		 PrintWriter out=null;
		 try {
			out=res.getWriter();//获得response的out对象
		} catch (IOException e) {
			e.printStackTrace();
		}
	    QUser quser=qUserBiz.selQuserByName(qname);
   
	    Gson gson=new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
	    String str=gson.toJson(quser);//字符串
	    out.write(str);
	    
	    out.flush();
	    out.close();
	 }
	/**
	 * 判断用户信息是否更改成功
	 */
     public void isupdate(){
    	 HttpServletResponse res=ServletActionContext.getResponse();
		 HttpServletRequest request=ServletActionContext.getRequest();
		 String qaddress=request.getParameter("qaddress");
		 String qtel=request.getParameter("qtel");
		 res.setCharacterEncoding("utf-8");
		 session=request.getSession();
		 String qname=null;
		 try {
			 int uid=(Integer) session.getAttribute("userid");
			 qname=qUserBiz.getUserName(uid);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(qname);
		 PrintWriter out=null;
		 try {
			out=res.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 if(qUserBiz.isUpdate(qname, qaddress, qtel)){
			 out.write("success");
		 }else{
			 out.write("fail");
		 }
	 }
     /**
 	 * 判断用户信息是否更改成功
 	 */
      public void isMoneyAdd(){
     	 HttpServletResponse res=ServletActionContext.getResponse();
 		 HttpServletRequest request=ServletActionContext.getRequest();
 		 String add=request.getParameter("addM");
 		 String total=request.getParameter("totalM");
 		 int totalM=Integer.parseInt(total);
 		 int addM=Integer.parseInt(add);
 		 totalM+=addM;
 		 res.setCharacterEncoding("utf-8");
 		 session=request.getSession();
 		 String qname=null;
 		 try {
 			 int uid=(Integer) session.getAttribute("userid");
			 qname=qUserBiz.getUserName(uid);
 		} catch (Exception e) {
 			System.out.println(e);
 		}
 		 PrintWriter out=null;
 		 try {
 			out=res.getWriter();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		 if(qUserBiz.isAdd(qname, addM)){
 			 out.write(totalM+"");
 		 }else{
 			 out.write("fail");
 		 }
 	 }
//      public void getAddressAndUserName() {
//        HttpServletResponse res=ServletActionContext.getResponse();
//     	 PrintWriter out=null;
// 		 try {
// 			out=res.getWriter();
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}
// 		 QUser user=
//			Gson gson=new Gson();
//			String str=gson.toJson();
// 		    out.write(str);
//     	 
//      
//      }
      
      
}
