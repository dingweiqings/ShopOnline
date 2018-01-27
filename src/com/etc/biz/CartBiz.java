package com.etc.biz;

public interface CartBiz {

	/**
	 * 添加商品至购物车
	 * @param userid 用户id
	 * @param cloid 商品id
	 * @param clonum 商品数量
	 * @param closize 商品尺码
	 * @return 添加结果
	 */
	public String addclo(int userid,int cloid,int clonum,int closize);
}
