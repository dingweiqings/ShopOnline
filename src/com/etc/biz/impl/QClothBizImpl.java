package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.QClothBiz;

import com.etc.dao.QClothDao;
import com.etc.entity.QCloth;
@Component("qClothBiz")//声明这个bean的id
public class QClothBizImpl implements QClothBiz {
	@Autowired
    private QClothDao qClothDao;
	public List<QCloth> getClothByPage(int pagenum, int pagecount) {
		return qClothDao.getClothByPage(pagenum, pagecount);
	}

	public int getTotalPages(int pagecount) {
		int sum=qClothDao.getTotalPages(pagecount);
		System.out.println(sum);
        return sum%pagecount==0?sum/pagecount:sum/pagecount+1;
	}

/*public List<QCloth> getQClothByPage(int pagenum, int pagecount) {
		
		
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
	}*/
	
}
