package com.etc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.dao.ShopcartDao;
import com.etc.entity.QCloth;
import com.etc.entity.QTrolley;
import com.etc.entity.QUser;
@Component("shopcartDao")
public class ShopcartDaoImpl implements ShopcartDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public List<QTrolley> getAllQtrolley(int userid) {
		Session session=sessionFactory.openSession();
		String hql=" from QTrolley where QUser.quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		@SuppressWarnings("unchecked")
		List<QTrolley> list=query.list();
		session.close();
		return list;
	}

	public int updateQtrolley(int trolleyid, int trolleynum) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" update QTrolley set trolleynum=? where trolleyid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, trolleynum);
		query.setInteger(1, trolleyid);
		int temp=query.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}

	public int insertQtrolley(int userid, int cloid, int trolleyprice,
			int trolleynum, int trolleysum) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" insert into QTrolley "+
				" (trolleyid, QUser, QCloth, trolleyprice, trolleynum, trolleysum, trolleydate) "+
				" values "+
				" (QORDER_ID.nextval, ?, ?, ?, ?, ?, sysdate) ";
		Query query=session.createQuery(hql);
		query.setEntity(0, session.get(QUser.class, userid));
		query.setEntity(1, session.get(QCloth.class, cloid));
		query.setInteger(2, trolleyprice);
		query.setInteger(3, trolleynum);
		query.setInteger(4, trolleysum);
		int temp=query.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}

	public QCloth selectRelPrice(int cloid) {
		Session session=sessionFactory.openSession();
		String hql=" from QCloth where cloid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, cloid);
		QCloth qCloth=(QCloth) query.uniqueResult();
		session.close();
		return qCloth;
	}

	public double selectActivitynum(int activityid) {
		Session session=sessionFactory.openSession();
		String hql=" select activitynum from QActivity where activityid=? and sysdate between starttime and endtime ";
		Query query=session.createQuery(hql);
		query.setInteger(0, activityid);
		double temp=(Double) query.uniqueResult();
		if(query.uniqueResult()!=null){
			temp=1;
		}
		session.close();
		return temp;
	}

	public int delectQTrolleyByid(int trolleyid) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" delete QTrolley where trolleyid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, trolleyid);
		int temp=query.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}
	
	
}
