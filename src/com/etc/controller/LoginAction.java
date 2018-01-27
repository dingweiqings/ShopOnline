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
	 * �ж��Ƿ��½�ɹ�
	 * @return
	 */
	public String loginOk(){
		if(qUserBiz.isLoginOk(qname, qpassword)){
			HttpServletRequest request=ServletActionContext.getRequest();
		    session=request.getSession();
			//�û�ip��ַ
			//String uip=request.getRemoteAddr();
			//session.setAttribute("qname", qname);//��½���û���
			//System.out.println("��qname"+qname+"����Session��");
			String sid=session.getId();//SessionId
			session.setAttribute("sid", sid);
			int uid=0;
			try {
				uid = qUserBiz.getUserid(qname);
				System.out.println("�û�����"+uid);
			} catch (Exception e) {
				System.out.println(e);
			}
			session.setAttribute("userid", uid);
			System.out.println("��uid"+uid+"����Session��");
			
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
				System.out.println("δ��½");
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
	 * �����û����ж��Ƿ��и��û�
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
			out=res.getWriter();//���response��out����
		} catch (IOException e) {
			e.printStackTrace();
		}
	    QUser quser=qUserBiz.selQuserByName(qname);
   
	    Gson gson=new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
	    String str=gson.toJson(quser);//�ַ���
	    out.write(str);
	    
	    out.flush();
	    out.close();
	 }
	/**
	 * �ж��û���Ϣ�Ƿ���ĳɹ�
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
 	 * �ж��û���Ϣ�Ƿ���ĳɹ�
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
