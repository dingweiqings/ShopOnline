package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.QClothBiz1;

import com.etc.dao.QClothDao1;
import com.etc.entity.QCloth;
@Component("qClothBiz1")
public class QClothBizImpl1 implements QClothBiz1 {

	@Autowired
	private  QClothDao1 qClothDao;

	public List<QCloth> getQClothByPage(int pagenum, int pagecount) {
		
		
		return    qClothDao.getQClothByPage(pagenum, pagecount);

	}

	public int getPageCounts(int pagecount) {
		int totalrecords=qClothDao.getQClothCount();
		
		return totalrecords%pagecount==0?totalrecords/pagecount:totalrecords/pagecount+1;
		
	}

	public boolean upLoadisOK(QCloth qCloth){
		
		int temp=qClothDao.insertQCloth(qCloth);
		if (temp>0) {
		return true;	
		}
		else {
		return false;	
		}
	}
	
	public boolean deleteQClothisOK(int cloid){
		int temp= qClothDao.deleteQCloth(cloid);
		if (temp>0) {
			return true;	
			}
			else {
			return false;	
			}
	}

}
