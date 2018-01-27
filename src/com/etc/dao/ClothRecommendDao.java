package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;


public interface ClothRecommendDao {

	/**
	 * 获取销量前四名的衣服
	 * @return List<QCloth>
	 */
	public List<QCloth> getBestcloths(int clothid);
	
	/**
	 * 获取相同类型的任意两件衣服
	 * @return List<QCloth>
	 */
	public List<QCloth> getSimilarcloths(int clothid);
	
	/**
	 * 获取新上架的任意两件衣服
	 * @return List<QCloth>
	 */
	public List<QCloth> getNewcloths(int clothid);
	
	
}
