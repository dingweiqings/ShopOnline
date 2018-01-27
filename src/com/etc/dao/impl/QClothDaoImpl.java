package com.etc.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.dao.QClothDao;
import com.etc.entity.QCloth;

@Component("qClothDao")
public class QClothDaoImpl implements QClothDao {
    @Autowired
    private SessionFactory sessionFactory;
    
	@SuppressWarnings("unchecked")
	public List<QCloth> getClothByPage(int pagenum, int pagecount) {
		Session session=sessionFactory.openSession();
		String hql=" from QCloth qcloth order by qcloth.closale desc ";
		Query query=session.createQuery(hql);
		query.setFirstResult((pagenum-1)*pagecount);
		query.setMaxResults(pagecount);
		List<QCloth> list=null;
		try {
			list = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		session.close();
		return list;
	}

	public int getTotalPages(int pagecount) {
		Session session=sessionFactory.openSession();
		String hql=" select count(*) from QCloth ";
		Long temp= null;
		try {
			temp = (Long) session.createQuery(hql).iterate().next();
		} catch (Exception e) {
			System.out.println("取总数异常");
		}
		long temp1=temp;
		int result=(int) temp1;
		System.out.println(result);
		return result;
	}

	/*public List<QCloth> getQClothByPage(int pagenum, int pagecount) {
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
			System.out.println(qCloth);
			Transaction transaction = session.beginTransaction();
			System.out.println(qCloth.toString());
			int temp=(Integer) session.save(qCloth);
			System.out.println(temp);
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
		}*/
}
