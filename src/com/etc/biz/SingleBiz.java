package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QComment;

public interface SingleBiz {

	/**
	 * 根据服装id获取该服装
	 * @param clothid 服装id
	 * @return 该服装
	 */
	public QCloth getClothbyID(int clothid);
	
	/**
	 * 获取评论的总页数
	 * @param clothid 服装id
	 * @param pagecount 每页的信息数
	 * @return 总页数
	 */
	public int getcompage(int clothid,int pagecount);
	
	/**
	 * 根据页数获取该页的所有评论
	 * @param clothid 服装id
	 * @param pagecount 每页的信息数
	 * @param pagenum 第几页
	 * @return 评论集合
	 */
	public List<QComment> getcomsbypage(int clothid,int pagecount,int pagenum);
	
	/**
	 * 根据衣服id获取改衣服的评论总数
	 * @param clothid 衣服id
	 * @return 改衣服的评论总数
	 */
	public int gettotalcoms(int clothid);
	
	/**
	 * 根据衣服id获取改衣服的平均评分
	 * @param clothid 衣服id
	 * @return 改衣服的平均评分
	 */
	public int getavggra(int clothid);
	
	
	
	//WJZ
	

	
	/**
	 * 页面加载9
	 * @return
	 */
	public List<QCloth> seachLoadBiz();
	

	/**
	 * 根据名字搜索衣服
	 * @return
	 */
	public List<QCloth> seachByNameBiz(String cloname);
	
	/**
	 * 根据材料类型 搜索衣服
	 * @return
	 */
	public List<QCloth> seachByTypeBiz(String clotype);
	/**
	 * 根据描述搜索衣服
	 * @return
	 */
	public List<QCloth> seachByDetailBiz(String clodetail);
	
	/**
	 * 根据价格搜索衣服
	 * @return
	 */
	public List<QCloth> seachByPriceBiz(int low,int high);
	/**
	 * 根据价格搜索衣服
	 * @return
	 */
	public List<QCloth> seachBySaleBiz(int low,int high);
	
}
