package com.etc.controller;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.impl.QActivityBizImpl;
import com.etc.entity.QActivity;
import com.etc.util.FileUpUtilActivity;

public class UploadAction2 {
	private  String activityname;//商品名
	private String clotype;//商品类型
	private  Date starttime;//商品价格
	private  Date  endtime;//s码库存
	private Double activitynum;//m码库存
	private File activitypic;//l码库存
		
	@Autowired
	private QActivityBizImpl qActivityBiz;
	private  String  activitypicFileName;//上传文件的原始的名字
public  String doUpLoad(){
		
		
//		上传pic[0]
		    boolean b=false;
	
		    FileUpUtilActivity  fuu=new FileUpUtilActivity();
			String s;
			String  newfilename=  fuu.uploadActivity(activitypic, "/upload", activitypicFileName);
			if (newfilename!=null) {
				System.out.println("已上传文件，上传之后的文件名字是" + newfilename);

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
