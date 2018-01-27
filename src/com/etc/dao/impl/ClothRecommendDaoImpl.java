package com.etc.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.etc.dao.ClothRecommendDao;
import com.etc.entity.QCloth;
import com.etc.util.HibernateSessionFactory;

@Component("clothRecommendDao")
@SuppressWarnings("unchecked")
public class ClothRecommendDaoImpl implements ClothRecommendDao {

	public List<QCloth> getBestcloths(int clothid) {
		Session session = HibernateSessionFactory.getSession();
		String sql = "select c.* from q_cloth c where c.cloid!=? and  rownum<5 order by c.closale desc  ";
		SQLQuery sq = session.createSQLQuery(sql);
		sq.setInteger(0, clothid);
		sq.addEntity(QCloth.class);
		List<QCloth> clos = sq.list();
			session.close();

			return clos;
		}
	

	public List<QCloth> getSimilarcloths(int clothid) {
		Session session = HibernateSessionFactory.getSession();
		String sql = " select a.* from q_Cloth a where a.clotype=(select c.clotype from q_cloth c where c.cloid=?) and a.cloid!=?";
		SQLQuery sq = session.createSQLQuery(sql);
		sq.setInteger(0, clothid);
		sq.setInteger(1, clothid);
		sq.addEntity(QCloth.class);
		List<QCloth> clos = sq.list();
		
			session.close();

			return clos;
		
	}

	public List<QCloth> getNewcloths(int clothid) {
		Session session = HibernateSessionFactory.getSession();
		String sql = "select c.* from q_cloth c where c.cloid != ? and rownum<4 order by c.clodate";
		SQLQuery sq = session.createSQLQuery(sql);
		sq.setInteger(0, clothid);
		sq.addEntity(QCloth.class);
		List<QCloth> clos = sq.list();
		
			session.close();

			return clos;
	}

}
