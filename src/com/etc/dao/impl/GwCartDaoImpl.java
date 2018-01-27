package com.etc.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etc.dao.GwCartDao;
import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.etc.entity.QUser;
@Repository("gwCartDao")
@SuppressWarnings("unchecked")
public class GwCartDaoImpl implements GwCartDao {
	@Autowired
	private SessionFactory sessionFactory;
	public QOrder getOneOrder(int userid) {
		Session session=sessionFactory.openSession();
		String hql=" from QOrder where orderstate=0 and quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		QOrder qOrder=(QOrder) query.uniqueResult();
		session.close();
		return qOrder;
	}
	public int insertOneOrder(int userid) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		String sql=" insert into q_order "+
				" (qdorder, quserid, orderdate, orderstate, qdprice) "+
				" values "+
				" (QORDER_ID.nextval, ?, null, '0', null) ";
		SQLQuery sQLQuery=session.createSQLQuery(sql);
		sQLQuery.setInteger(0, userid);
		int temp=sQLQuery.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}
	public QCloth selectQClothByid(int cloid) {
		Session session=sessionFactory.openSession();
		String hql=" from QCloth where cloid=:cloid";
		QCloth qCloth=null;
		try{
		Query query=session.createQuery(hql);
		query.setInteger("cloid", cloid);
	    qCloth= (QCloth) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		return qCloth;
	}
	public int insertQOrderdetail(int qdorder,int cloid,int orderprice, int ordernum,
			String orderlx) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String sql=" insert into q_orderdetail "+
				" ( qdorder, cloid, ordernum, orderprice, quserelprice, orderlx) "+
				" values "+
				" ( ?, ?, ?, ?, null, ?) ";
		SQLQuery sQLQuery=session.createSQLQuery(sql);
		sQLQuery.setInteger(0, qdorder);
		sQLQuery.setInteger(1, cloid);
		sQLQuery.setInteger(2, ordernum);
		sQLQuery.setInteger(3, orderprice);
		sQLQuery.setString(4, orderlx);
		int temp=sQLQuery.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}
	//会出现脏读情况
	public List<QOrderdetail> getQOrderdetail(int qdorder) {
		Session session=sessionFactory.openSession();
		session.clear();
		String hql=" from QOrderdetail where QOrder.qdorder=:qdorder ";
		Query query=null;
		List<QOrderdetail> list=null;
		try {
			 query=session.createQuery(hql);
				query.setInteger("qdorder", qdorder);
				list=query.list();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		session.close();
		return list;
	}
	public double getActivitynum(String clotype) {
		Session session=sessionFactory.openSession();
		String sql=" select activitynum from q_activity where clotype=? and"
				+ " ((curdate() between starttime and endtime) or (CURDATE()>starttime and endtime is null )) ";
		SQLQuery query=session.createSQLQuery(sql);
		query.setString(0, clotype);
		double temp=1;
		try{
		if(query.uniqueResult()!=null){
		double count=Double.parseDouble(((Integer)query.uniqueResult()).toString()) ;
		if(count!=0){
			temp=count;
		}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		session.close();
		return temp;
	}
	public int insertOneOrdered(int userid,int qdprice) {
		Session session=sessionFactory.openSession();
//		String sql=" insert into q_order "+
//				" (quserid, orderdate, orderstate, qdprice) "+
//				" values "+
//				" ( QORDER_ID.nextval,curdate(), null, '1', ?) ";
//		SQLQuery sQLQuery=session.createSQLQuery(sql);
//		sQLQuery.setInteger(1, userid);
//		sQLQuery.setInteger(2, qdprice);
//		sQLQuery.executeUpdate();
//		transaction.commit();
		QOrder qOrder=new QOrder();
		qOrder.setOrderdate(new Date(System.currentTimeMillis()));
		qOrder.setQuserid(userid);
		qOrder.setQdprice(qdprice);
		qOrder.setOrderstate("1");
		session.saveOrUpdate(qOrder);
		String hql1=" select max(qdorder) from QOrder where quserid=? ";
		Query query=session.createQuery(hql1);
		query.setInteger(0, userid);
		int qdorder= (Integer) query.uniqueResult();
		session.close();
		return qdorder;
	}
	public QOrder getOneOrdered(int userid) {
		Session session=sessionFactory.openSession();
		String hql=" from QOrder where orderstate=1 and quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		QOrder qOrder=(QOrder) query.uniqueResult();
		session.close();
		return qOrder;
	}
	public int updateQuserelprice(int orderid,int quserelprice){
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" update QOrderdetail set quserelprice=? where orderid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, quserelprice);
		query.setInteger(1, orderid);
		int temp=0;
		try{
			 temp=query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(temp>0)
		transaction.commit();
		else
			transaction.rollback();
		session.close();
		return temp;
	}
	public QOrderdetail getQOrderdetailByid(int orderid) {
		Session session=sessionFactory.openSession();
		QOrderdetail qOrderdetail=null;
//		String hql=" from QOrderdetail where orderid=? ";
//		Query query=session.createQuery(hql);
//		query.setInteger(0, orderid);
//		qOrderdetail=(QOrderdetail) query.uniqueResult();
		qOrderdetail=(QOrderdetail) session.get(QOrderdetail.class, orderid);
		session.close();
		return qOrderdetail;
	}
	public int delectQOrderdetail(int orderid) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" delete QOrderdetail where orderid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, orderid);
		int temp=0;
		try{
		 temp=query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		if (temp>0)
		transaction.commit();
		else 
		transaction.rollback();
		session.close();
		return temp;
	}
	public int getAllMoney(int chk_value[]) throws Exception{
		Session session=sessionFactory.openSession();
		int qwe=0;
		int sum=0;
		for (int i = 0; i < chk_value.length; i++) {
			String hql=" select ordernum*quserelprice from QOrderdetail where orderid ="+chk_value[i] ;
			Query query=session.createQuery(hql);
			Object obj=query.uniqueResult();
			if(obj!=null)
			qwe=(Integer) obj;
			sum+=qwe;
		}
		session.close();
		return sum;
	}
	public QUser getUser(int userid) {
		Session session=sessionFactory.openSession();
		String hql=" from QUser where quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		QUser qUser=(QUser) query.uniqueResult();
		session.close();
		return qUser;
	}
	public int updateOrdertoOrdered(int orderid, int qdorder) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String sql=" update q_orderdetail set qdorder = ? where orderid=? ";
		SQLQuery sQLQuery=session.createSQLQuery(sql);
		sQLQuery.setInteger(0, qdorder);
		sQLQuery.setInteger(1, orderid);
//		sQLQuery.addEntity(QOrderdetail.class);
		int temp=sQLQuery.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}
	public int updatetrlley(int orderid, int ordernum) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" update QOrderdetail set ordernum=? where orderid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, ordernum);
		query.setInteger(1, orderid);
		int temp=query.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}
	public int selectOrderMoney(int qdorder) {
		Session session=sessionFactory.openSession();
		String hql=" select qdprice from QOrder where qdorder=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, qdorder);
		int temp=(Integer) query.uniqueResult();
		session.close();
		return temp;
	}
	public int newOrdered(int userid) {
		Session session=sessionFactory.openSession();
		String hql=" select max(qdorder) from QOrder where quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		int temp=(Integer) query.uniqueResult();
		session.close();
		return temp;
	}
	public int updateUserMoney(int userid, int money) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		String hql=" update QUser set qmoney=? where quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, money);
		query.setInteger(1, userid);
		int temp=query.executeUpdate();
		transaction.commit();
		session.close();
		return temp;
	}

}
