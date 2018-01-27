package com.etc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.etc.dao.QClothDao1;
import com.etc.entity.QCloth;
@Component("qClothDao1")
@SuppressWarnings("unchecked")
public class QClothDaoImpl1 implements QClothDao1 {
	@Autowired
    private SessionFactory sessionFactory;
	public List<QCloth> getQClothByPage(int pagenum, int pagecount) {
	   Session session=	sessionFactory.openSession();
	   String hql="from   QCloth   ";
	  Query query= session.createQuery(hql);
	  query.setFirstResult((pagenum-1)*pagecount);
	  query.setMaxResults(pagecount);
	 List<QCloth> list= query.list();
	  session.close();
	  return list;
		
	}
	public int getQClothCount() {
         Session session=  sessionFactory.openSession();
		 
		 Long  result= (Long) session.createQuery("select count(*) from QCloth").iterate().next();
				 
		 long temp= result;	 
		 int temp1=(int) temp;
		 
		 session.close();

		return temp1;
		
	}
	public int insertQCloth(QCloth qCloth) {
		System.out.println("3333333");
		Session session=sessionFactory.openSession();
		System.out.println(qCloth.toString());
		Transaction transaction = session.beginTransaction();
		System.out.println(qCloth.toString());
		int temp=(Integer) session.save(qCloth);
		System.out.println("temp"+temp);
		transaction.commit();
		session.close();
		return temp;
	
}
	public int deleteQCloth(int cloid){
		   Session session=sessionFactory.openSession();
		   Transaction transaction = session.beginTransaction();
		   Query sq = session.createSQLQuery(" delete from q_cloth where cloid=?");
			sq.setInteger(0, cloid);
			int temp = sq.executeUpdate();
			transaction.commit();
			session.close();
			return temp;
	}
	public List<QCloth> getClothByPage(int pagenum, int pagecount) {
		return null;
	}
	public int getTotalPages(int pagecount) {
		return 0;
	}
}
