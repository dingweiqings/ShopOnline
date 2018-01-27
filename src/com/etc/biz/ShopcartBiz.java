package com.etc.biz;

import java.util.List;

import com.etc.entity.QTrolley;


public interface ShopcartBiz {
	/**
	 * 根据用户id查询该用户的购物车
	 * @param userid
	 * @return
	 */
	public List<QTrolley> getAllQtrolley(int userid);
	/**
	 * 修改购物车中商品的数量
	 * @param trolleyid
	 * @param trolleynum
	 * @return
	 */
	public boolean updateQtrolley(int trolleyid,int trolleynum);

	/**
	 * 向购物车中添加商品
	 * @param userid
	 * @param cloid
	 * @param trolleynum
	 * @return
	 */
	public boolean insertQtrolley(int userid,int cloid,int trolleynum);
	
	/**
	 * 使用：用户从购物车列表中删除不想购买的商品 
	 * 根据购物车id删除购物车中对应的记录
	 * @param trolleyid  购物车表记录id
	 * @return
	 */
	public boolean delectQTrolleyByid(int trolleyid);
	

}
