package com.etc.controller;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.impl.QActivityBizImpl;
import com.etc.entity.QActivity;
import com.etc.util.FileUpUtilActivity;

public class UploadAction2 {
	private  String activityname;//��Ʒ��
	private String clotype;//��Ʒ����
	private  Date starttime;//��Ʒ�۸�
	private  Date  endtime;//s����
	private Double activitynum;//m����
	private File activitypic;//l����
		
	@Autowired
	private QActivityBizImpl qActivityBiz;
	private  String  activitypicFileName;//�ϴ��ļ���ԭʼ������
public  String doUpLoad(){
		
		
//		�ϴ�pic[0]
		    boolean b=false;
	
		    FileUpUtilActivity  fuu=new FileUpUtilActivity();
			String s;
			String  newfilename=  fuu.uploadActivity(activitypic, "/upload", activitypicFileName);
			if (newfilename!=null) {
				System.out.println("���ϴ��ļ����ϴ�֮����ļ�������" + newfilename);

			    s="upload/"+newfilename;
			    
			}
			else{
				return "fail";								
			}
		
		QActivity qActivity=new QActivity();
		qActivity.setActivityname(activityname);
		qActivity.setClotype(clotype);
		qActivity.setActivitynum(activitynum);
		qActivity.setStarttime(starttime);
		qActivity.setEndtime(endtime);
		qActivity.setActivitpic(s);
	    b=qActivityBiz.upLoadisOK(qActivity);
	    if (b) {
			return "ok";
		}
		
		else {
			return "false";
		}
	
	
	
	}
public String getActivityname() {
	return activityname;
}
public void setActivityname(String activityname) {
	this.activityname = activityname;
}
public String getClotype() {
	return clotype;
}
public void setClotype(String clotype) {
	this.clotype = clotype;
}
public Date getStarttime() {
	return starttime;
}
public void setStarttime(Date starttime) {
	this.starttime = starttime;
}
public Date getEndtime() {
	return endtime;
}
public void setEndtime(Date endtime) {
	this.endtime = endtime;
}
public Double getActivitynum() {
	return activitynum;
}
public void setActivitynum(Double activitynum) {
	this.activitynum = activitynum;
}

public File getActivitypic() {
	return activitypic;
}
public void setActivitypic(File activitypic) {
	this.activitypic = activitypic;
}
public QActivityBizImpl getqActivityBiz() {
	return qActivityBiz;
}
public void setqActivityBiz(QActivityBizImpl qActivityBiz) {
	this.qActivityBiz = qActivityBiz;
}
public String getActivitypicFileName() {
	return activitypicFileName;
}
public void setActivitypicFileName(String activitypicFileName) {
	this.activitypicFileName = activitypicFileName;
}

	
	
}
