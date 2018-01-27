package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.SingleBiz;

import com.etc.dao.ClothDetailDao;
import com.etc.entity.QCloth;
import com.etc.entity.QComment;

@Component("singleBiz")
public class SingleBizImpl implements SingleBiz {
	
	@Autowired
	private ClothDetailDao clothDetailDao;

	public QCloth getClothbyID(int clothid) {
		
		return clothDetailDao.getClothbyID(clothid);
	}

	public int getcompage(int clothid, int pagecount) {
		int temp=(int) clothDetailDao.gettotalcom(clothid);
		System.err.println("zongyeshu "+temp);
		return temp%pagecount==0?temp/pagecount:temp/pagecount+1;
	}

	public List<QComment> getcomsbypage(int clothid, int pagecount, int pagenum) {
		return clothDetailDao.getcombypage(clothid, pagecount, pagenum);
	}

	public int gettotalcoms(int clothid) {
		
		return (int) clothDetailDao.gettotalcom(clothid);
	}

	public int getavggra(int clothid) {
		int temp=(int)clothDetailDao.getavg(clothid);
		System.out.println("pingjunmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"+temp);
		return temp;
	}

	
	//WJZ
	

	
	
	public List<QCloth> seachByNameBiz(String cloname) {
List<QCloth> list=clothDetailDao.seachByName(cloname);
           System.out.println("seachByNameBiz00000");
           
		return list;
	}

	public List<QCloth> seachByTypeBiz(String clotype) {
List<QCloth> list=clothDetailDao.seachByType(clotype);
		
		return list;
	}

	public List<QCloth> seachByDetailBiz(String clodetail) {
List<QCloth> list=clothDetailDao.seachByDetail(clodetail);
		
		return list;
	}

	public List<QCloth> seachLoadBiz() {
      List<QCloth> list=clothDetailDao.seachLoad();
		
		return list;
	}

	public List<QCloth> seachByPriceBiz(int low, int high) {
		 List<QCloth> list=clothDetailDao.seachByPrice(low, high);
			
			return list;
	}

	public List<QCloth> seachBySaleBiz(int low, int high) {
		 List<QCloth> list=clothDetailDao.seachBySale(low, high);
			
			return list;
	}

	

}
