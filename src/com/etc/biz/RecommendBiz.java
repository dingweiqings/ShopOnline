package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;

public interface RecommendBiz {

	/**
	 * 获取销量前四名的衣服
	 * @return List<QCloth>
	 */
	public List<QCloth> getBestClos(int clothid);
	
	/**
	 * 获取相同类型的任意两件衣服
	 * @return List<QCloth>
	 */
	public List<QCloth> getSimilarClos(int clothid);
	
	/**
	 * 获取新上架的任意三件衣服
	 * @return List<QCloth>
	 */
	public List<QCloth> getNewClos(int clothid);
}
