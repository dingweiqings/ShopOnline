package com.etc.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.etc.dao.QActivityDao;
import com.etc.entity.QActivity;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("qActivityDao")
@SuppressWarnings("unchecked")
public class QActivityDaoImpl implements QActivityDao {
	@Autowired
     private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<QActivity> getAllActivity() {
	  Session session=sessionFactory.openSession();
	   String sql="select * from q_activity ";
	   SQLQuery sqlQuery=session.createSQLQuery(sql).addEntity(QActivity.class);
		List<QActivity> list=sqlQuery.list();
		Iterator<QActivity> it=list.iterator();	
		while(it.hasNext()){
			QActivity temp=(QActivity) it.next();
			System.out.println("id "+temp.getActivityid()+ " name "+temp.getActivityname());
			
		}
		return list;
	}
	
	public boolean deleteQActivityById(int id){
		Session session=sessionFactory.openSession();
		System.out.println(" dao 41 "+id );
		String sql="delete from q_activity where activityid=?";
		SQLQuery query=session.createSQLQuery(sql);
		query.setParameter(0, id);
		Transaction tran=session.beginTransaction();
		int temp=query.executeUpdate();
		tran.commit();
		if(temp>0){
		  return true;
		}
		return false;
	}
	public int insertQActivity(QActivity qActivity) {
	Session session=sessionFactory.openSession();
	Transaction tran=session.beginTransaction();
	int temp=0;
     try{
    	 temp=(Integer) session.save(qActivity);
     }catch(Exception e){
    	 e.printStackTrace();
     }


	if (temp>0)
	 tran.commit();
	session.close();
		
		return temp;
	}
	
	
	

}
