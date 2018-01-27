package com.etc.dao;

public interface CartDao {

	/**
	 * 將商品增加到購物車中
	 * @return int(>0:成功/<=0:失敗)
	 */
	public int addclo(int userid,int cloid,int clonum,int closize);
}
