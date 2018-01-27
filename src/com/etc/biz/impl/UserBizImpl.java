package com.etc.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.UserBiz;

import com.etc.dao.UserDao;
import com.etc.entity.QUser;

@Component("userBiz")
public class UserBizImpl implements UserBiz{
	@Autowired
	private UserDao userDao;

	public int getuseridbyname(String username) {
		QUser user=userDao.getuserbyname(username);
		if(user==null||"".equals(user)){
			return 0;
		}else{
			
			return user.getQuserid();
		}
		
		//return userDao.getuserbyname(username).getQuserid();
	}

}
