package com.etc.biz.impl;

import java.util.List;

import com.etc.biz.QActivityBiz;

import com.etc.dao.impl.QActivityDaoImpl;
import com.etc.entity.QActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("qActivityBiz")
public class QActivityBizImpl implements QActivityBiz {


	@Autowired
       private QActivityDaoImpl qActivityDao;
	
	public QActivityDaoImpl getqActivityDao() {
		return qActivityDao;
	}
	public void setqActivityDao(QActivityDaoImpl qActivityDao) {
		this.qActivityDao = qActivityDao;
	}
	
	
	public List<QActivity> getAllActivity() {
		List<QActivity> list=qActivityDao.getAllActivity();
		return list;
	}

	public boolean deleteQActivityById(int id){
		if(qActivityDao.deleteQActivityById(id))
			return true;
		else
			return false;
		
	}
	public boolean upLoadisOK(QActivity qActivity) {
	    
		int temp=qActivityDao.insertQActivity(qActivity);
		
		return temp>0;
	}
	public int insertQActivity(QActivity qActivity) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
