package com.etc.dao;

import com.etc.entity.QUser;

public interface UserDao {

	/**
	 * �����û�������ȡ�û�
	 * @param userid
	 * @return ��ǰ�û�
	 */
	public QUser getuserbyname(String username);
}
