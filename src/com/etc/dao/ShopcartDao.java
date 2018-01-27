package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QTrolley;


public interface ShopcartDao {
	/**
	 * 根据用户id查询该用户的购物车
	 * @param userid
	 * @return
	 */
	public List<QTrolley> getAllQtrolley(int userid);
	/**
	 * 修改购物车中商品的数量（有错误，没有修改总价）
	 * @param trolleyid
	 * @param trolleynum
	 * @return
	 */
	public int updateQtrolley(int trolleyid,int trolleynum);
	/**
	 * 向购物车中添加数据
	 * @param userid 用户id
	 * @param cloid  商品id
	 * @param trolleyprice 商品实际价格
	 * @param trolleynum 商品数量
	 * @param trolleysum 商品总价
	 * @return
	 */
	public int insertQtrolley(int userid,int cloid,int trolleyprice,int trolleynum,int trolleysum);
	/**
	 * 查询某件商品的实际价格
	 * @param cloid
	 * @return
	 */
	public QCloth selectRelPrice(int cloid);
	/**
	 * 查询这个时刻的商品的折扣
	 * @param activityid
	 * @return
	 */
	public double selectActivitynum(int activityid);
	/**
	 * 使用：用户从购物车列表中删除不想购买的商品 
	 * 根据购物车id删除购物车中对应的记录
	 * @param trolleyid  购物车表记录id
	 * @return
	 */
	public int delectQTrolleyByid(int trolleyid);

}
