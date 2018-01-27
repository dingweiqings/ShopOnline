package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.ShopcartBiz;

import com.etc.dao.ShopcartDao;
import com.etc.entity.QCloth;
import com.etc.entity.QTrolley;
@Service("shopcartBiz")
public class ShopcartBizImpl implements ShopcartBiz {
	@Autowired
	private ShopcartDao shopcartDao;

	public List<QTrolley> getAllQtrolley(int userid) {
		return shopcartDao.getAllQtrolley(userid);
	}

	public boolean updateQtrolley(int trolleyid, int trolleynum) {
		return shopcartDao.updateQtrolley(trolleyid, trolleynum)>0?true:false;
	}

	public boolean insertQtrolley(int userid, int cloid, int trolleynum) {
		QCloth qCloth=shopcartDao.selectRelPrice(cloid);
		int price=qCloth.getCloprice();
		double temp=shopcartDao.selectActivitynum(qCloth.getClomove());
		int trolleyprice=(int) (price*temp);
		int trolleysum=trolleyprice*trolleynum;
		return shopcartDao.insertQtrolley(userid, cloid, trolleyprice, trolleynum, trolleysum)>0?true:false;
	}

	public boolean delectQTrolleyByid(int trolleyid) {
		return shopcartDao.delectQTrolleyByid(trolleyid)>0?true:false;
	}

}
