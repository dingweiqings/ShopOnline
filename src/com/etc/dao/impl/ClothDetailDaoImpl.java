package com.etc.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.etc.dao.ClothDetailDao;
import com.etc.entity.QCloth;
import com.etc.entity.QComment;
import com.etc.util.HibernateSessionFactory;

@Component("clothDetailDao")
@SuppressWarnings("unchecked")
public class ClothDetailDaoImpl implements ClothDetailDao{

	public QCloth getClothbyID(int clothid) {
		Session session=HibernateSessionFactory.getSession();
		
		/*Query query= session.createQuery("from QCloth where cloid=?");
		query.setInteger(0, clothid);
	
		QCloth cloth= (QCloth) query.uniqueResult();*/
		
		SQLQuery sq= session.createSQLQuery("select * from q_cloth where cloid=?");
		sq.setInteger(0, clothid);
		sq.addEntity(QCloth.class);
		QCloth cloth=(QCloth)sq.uniqueResult();
		
		session.close();
		System.out.println("Dao------"+cloth.getCloid());
		return cloth;
	}

	public long gettotalcom(int clothid) {
		Session session=HibernateSessionFactory.getSession();
		
		/*String sql="select count(*)  from q_comment  where cloid=?";
		
		SQLQuery sq= session.createSQLQuery(sql);
		sq.setInteger(0, clothid);
		sq.addEntity(QComment.class);*/
		
		String hql="select count(*) from QComment where cloid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, clothid);
		
		
		
		
		//int temp= (Integer) sq.list().get(0);
		Long temp= (Long) query.iterate().next();
		//System.err.println(temp+"tempppppppp");
		session.close();
		 return temp;
	
	}

	public List<QComment> getcombypage(int clothid, int pagecount, int pagenum) {
		
		Session session=HibernateSessionFactory.getSession();
		
		String hql="from QComment where cloid=? order by comdate desc";
		
		Query query=session.createQuery(hql);
		query.setInteger(0, clothid);
		query.setFirstResult((pagenum-1)*pagecount);
		query.setMaxResults(pagecount);
		
		List<QComment> coms= query.list();
		session.close();
			return coms;
		
	}

	public double getavg(int clothid) {
		Session session=HibernateSessionFactory.getSession();
		
		String sql="select round(avg(comgrade),0) from QComment where cloid=?";
		Query sq=session.createQuery(sql);
		sq.setInteger(0, clothid);
		//sq.addEntity(QComment.class);
		
		double temp= (Double)sq.iterate().next();
		session.close();
		System.out.println("pingjunfe mmmmmmmmmmm"+temp);
		return temp;
	}
	
//WJZ
	

	public List<QCloth> seachByName(String cloname) {
     Session session=HibernateSessionFactory.getSession();
		
		SQLQuery sq= session.createSQLQuery("select * from q_cloth where cloname like '%"+cloname+"%' ");
		/*sq.setString(0, cloname);*/
		sq.addEntity(QCloth.class);
		
		List<QCloth> list=  sq.list();
		
		System.out.println("Dao--- seachByNameseachByNameseachByName---");
		return list;
		
	}

	public List<QCloth> seachByType(String clotype) {
     Session session=HibernateSessionFactory.getSession();
		
		SQLQuery sq= session.createSQLQuery("select * from q_cloth where clotype like '%"+clotype+"%'");
		/*sq.setString(0, clotype);*/
		//映射到实体类，
		sq.addEntity(QCloth.class);
		
		List<QCloth> list=  sq.list();

		return list;
		
	}

	public List<QCloth> seachByDetail(String clodetail) {
		 Session session=HibernateSessionFactory.getSession();
			
			SQLQuery sq= session.createSQLQuery("select * from q_cloth where clodetail like  '%"+clodetail+"%'");
			/*sq.setString(0, clodetail);*/
			sq.addEntity(QCloth.class);
			
			List<QCloth> list=  sq.list();
	
			return list;
			
	}

	public List<QCloth> seachLoad() {
		 Session session=HibernateSessionFactory.getSession();
			
			SQLQuery sq= session.createSQLQuery("select * from q_cloth ");
			/*sq.setString(0, clodetail);*/
			sq.addEntity(QCloth.class);
			
			List<QCloth> list=  sq.list();
	
			return list;
	}

	public List<QCloth> seachByPrice(int low, int high) {
		 Session session=HibernateSessionFactory.getSession();
			
			SQLQuery sq= session.createSQLQuery("select * from q_cloth where cloprice>="+low+" and cloprice<="+high+"");
			/*sq.setString(0, clodetail);*/
			sq.addEntity(QCloth.class);
			
			List<QCloth> list=  sq.list();
	
			return list;
	}

	public List<QCloth> seachBySale(int low, int high) {
		 Session session=HibernateSessionFactory.getSession();
			
			SQLQuery sq= session.createSQLQuery("select * from q_cloth where closale>="+low+" and closale<="+high+"");
			/*sq.setString(0, clodetail);*/
			sq.addEntity(QCloth.class);
			
			List<QCloth> list=  sq.list();
	
			return list;
	}
	
	

}
