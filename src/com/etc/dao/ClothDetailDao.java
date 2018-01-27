package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QComment;

/**
 * 关于此衣服的数据访问层
 * @author asus
 *
 */
public interface ClothDetailDao {

	/**
	 * 根据衣服的id获取该衣服
	 * @param clothid 衣服id
	 * @return  该衣服
	 */
	public QCloth getClothbyID(int clothid);
	
	/**
	 * 根据衣服id获取改衣服的评论总数
	 * @param clothid 衣服id
	 * @return 改衣服的评论总数
	 */
	public long gettotalcom(int clothid);
	
	/**
	 * 获取部分评论数
	 * @param clothid
	 * @param pagecount
	 * @param pagenum
	 * @return
	 */
	public List<QComment> getcombypage(int clothid,int pagecount,int pagenum);
	
	/**
	 * 根据衣服id获取改衣服的评论平均分
	 * @param clothid 衣服id
	 * @return 改衣服的评论平均分
	 */
	public double getavg(int clothid);
	
	//WJZ
	/**
	 *初始页面加载9个商品信息
	 * @return
	 */
	public List<QCloth> seachLoad();
	/**
	 * 根据名字搜索衣服
	 * @return
	 */
	public List<QCloth> seachByName(String cloname);
	/**
	 * 根据材料类型 搜索衣服
	 * @return
	 */
	public List<QCloth> seachByType(String clotype);
	/**
	 * 根据描述搜索衣服
	 * @return
	 */
	public List<QCloth> seachByDetail(String clodetail);
	
	/**
	 * 根据价格搜索衣服
	 * @return
	 */
	public List<QCloth> seachByPrice(int low,int high);
	
	/**
	 * 根据销量搜索衣服
	 * @return
	 */
	public List<QCloth> seachBySale(int low,int high);
	
}
