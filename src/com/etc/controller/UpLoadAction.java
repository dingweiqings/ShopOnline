package com.etc.controller;

import java.io.File;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.QClothBiz1;

import com.etc.entity.QCloth;
import com.etc.util.FileUpUtil;


public class UpLoadAction {
	
	private  String cloname;//��Ʒ��
	private String clotype;//��Ʒ����
	private  int cloprice;//��Ʒ�۸�
	private int  clonums;//s����
	private int clonumm;//m����
	private int clonuml;//l����
	private String clodetail;//��Ʒ����
	private File[]  pic;
	String[] s =new String[3];
	@Autowired
	private QClothBiz1 qClothBiz;

	private  String[]  picFileName;//�ϴ��ļ���ԭʼ������
	
	public String getCloname() {
		return cloname;
	}

	public void setCloname(String cloname) {
		this.cloname = cloname;
	}

	public String getClotype() {
		return clotype;
	}

	public void setClotype(String clotype) {
		this.clotype = clotype;
	}

	public int getCloprice() {
		return cloprice;
	}

	public void setCloprice(int cloprice) {
		this.cloprice = cloprice;
	}

	public int getClonums() {
		return clonums;
	}

	public void setClonums(int clonums) {
		this.clonums = clonums;
	}

	public int getClonumm() {
		return clonumm;
	}

	public void setClonumm(int clonumm) {
		this.clonumm = clonumm;
	}

	public int getClonuml() {
		return clonuml;
	}

	public void setClonuml(int clonuml) {
		this.clonuml = clonuml;
	}

	public String getClodetail() {
		return clodetail;
	}

	public void setClodetail(String clodetail) {
		this.clodetail = clodetail;
	}

	
	public  String doUpLoad()  throws Exception{
		
		
//		�ϴ�pic[0]
		boolean b=false;
		for(int i=0;i<pic.length;i++){
			FileUpUtil  fuu=new FileUpUtil();
			
			String  newfilename=  fuu.upload(pic[i], "/upload", picFileName[i]);
			if (newfilename!=null) {
				System.out.println("���ϴ���" + i + "���ļ����ϴ�֮����ļ�������" + newfilename);

			    s[i]="upload/"+newfilename;
			    
			}
			else{
				return "fail";								
			}
		}
		 Date date= new Date();
		 Timestamp ts = new Timestamp(date.getTime());
		QCloth qCloth=new QCloth(0,cloname,clotype,cloprice,clonums,clonumm,clonuml,clodetail,0,s[0],s[1],s[2],0,ts);
	    b=qClothBiz.upLoadisOK(qCloth);
	    if (b) {
			return "ok";
		}
		
		else {
			return "false";
		}
	
	
	
	}

	public File[] getPic() {
		return pic;
	}

	public void setPic(File[] pic) {
		this.pic = pic;
	}

	public String[] getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String[] picFileName) {
		this.picFileName = picFileName;
	}
}
