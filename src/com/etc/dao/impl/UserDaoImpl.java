package com.etc.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.etc.dao.UserDao;
import com.etc.entity.QUser;
import com.etc.util.HibernateSessionFactory;

@Component("userDao")
public class UserDaoImpl implements UserDao{

	public QUser getuserbyname(String username) {
		Session session = HibernateSessionFactory.getSession();
		String hql1 = "from QUser where qname=?";

		Query query1 = session.createQuery(hql1);
		query1.setString(0, username);
		QUser user = (QUser) query1.uniqueResult();
		return user;
	}

	
}
