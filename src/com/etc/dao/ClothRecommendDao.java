package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;


public interface ClothRecommendDao {

	/**
	 * ��ȡ����ǰ�������·�
	 * @return List<QCloth>
	 */
	public List<QCloth> getBestcloths(int clothid);
	
	/**
	 * ��ȡ��ͬ���͵����������·�
	 * @return List<QCloth>
	 */
	public List<QCloth> getSimilarcloths(int clothid);
	
	/**
	 * ��ȡ���ϼܵ����������·�
	 * @return List<QCloth>
	 */
	public List<QCloth> getNewcloths(int clothid);
	
	
}
