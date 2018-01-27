package com.etc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.QUserBiz;

public class RegisterAction {
   private String qname;
   private String qtel;
   private String qaddress;
   private String qpassword;
   @Autowired
   private QUserBiz qUserBiz;
public String getQname() {
	return qname;
}
public void setQname(String qname) {
	this.qname = qname;
}
public String getQtel() {
	return qtel;
}
public void setQtel(String qtel) {
	this.qtel = qtel;
}
public String getQaddress() {
	return qaddress;
}
public void setQaddress(String qaddress) {
	this.qaddress = qaddress;
}
public String getQpassword() {
	return qpassword;
}
public void setQpassword(String qpassword) {
	this.qpassword = qpassword;
}

   public String registerOk(){
	   System.out.println("register action 40 qname "+qname  +"  qaddress  "+qaddress);
	   if(qUserBiz.isInsOk(qname, qtel, qaddress, qpassword)){
		   return "success";
	   }
	   return "fail";
   }
}
