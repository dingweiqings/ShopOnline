package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;

public interface RecommendBiz {

	/**
	 * ��ȡ����ǰ�������·�
	 * @return List<QCloth>
	 */
	public List<QCloth> getBestClos(int clothid);
	
	/**
	 * ��ȡ��ͬ���͵����������·�
	 * @return List<QCloth>
	 */
	public List<QCloth> getSimilarClos(int clothid);
	
	/**
	 * ��ȡ���ϼܵ����������·�
	 * @return List<QCloth>
	 */
	public List<QCloth> getNewClos(int clothid);
}
