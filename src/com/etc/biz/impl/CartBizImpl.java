package com.etc.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.CartBiz;

import com.etc.dao.CartDao;
@Component("cartBiz")
public class CartBizImpl implements CartBiz{
	
	@Autowired
	private CartDao cartDao;

	public String addclo(int userid, int cloid, int clonum, int closize) {
		int temp=cartDao.addclo(userid, cloid, clonum, closize);
		return temp>0?"ok":"fail";
	}

	
	
}
