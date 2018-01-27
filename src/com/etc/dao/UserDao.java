package com.etc.dao;

import com.etc.entity.QUser;

public interface UserDao {

	/**
	 * 根据用户姓名获取用户
	 * @param userid
	 * @return 当前用户
	 */
	public QUser getuserbyname(String username);
}
