package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.RecommendBiz;

import com.etc.dao.ClothRecommendDao;
import com.etc.entity.QCloth;

@Component("recommendBiz")
public class RecommendBizImpl implements RecommendBiz{
	
	@Autowired
	private ClothRecommendDao clothRecommendDao;

	public List<QCloth> getBestClos(int clothid) {
		
		return clothRecommendDao.getBestcloths(clothid);
	}

	public List<QCloth> getSimilarClos(int clothid) {
	
		return clothRecommendDao.getSimilarcloths(clothid);
	}

	public List<QCloth> getNewClos(int clothid) {
		
		return clothRecommendDao.getNewcloths(clothid);
	}

}
