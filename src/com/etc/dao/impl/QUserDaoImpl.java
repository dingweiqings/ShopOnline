package com.etc.dao.impl;

import java.math.BigInteger;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.dao.QUserDao;
import com.etc.entity.QUser;
/**
 * 对Q_User表进行操作的具体实现
 * @author tl
 *
 */
@Component("qUserDao")
public class QUserDaoImpl implements QUserDao {
	@Autowired
    private SessionFactory sessionFactory;
	/**
	 * 根据用户姓名返回对应的用户对象
	 * @param qname 
	 * @return
	 */
	public QUser selQUserByName(String qname) {
		Session session=sessionFactory.openSession();
		String hql=" from QUser where qname=?";
		Query query=session.createQuery(hql);
		query.setString(0, qname);
		QUser quser=(QUser) query.uniqueResult();
		session.close();
		return quser;
	}
	 /**
     * 注册用户，向用户表插入基本信息
     * @param qname
     * @param qtel
     * @param qaddress
     * @param qpassword
     * @return
     */
	public int insQUserInf(String qname, String qtel, String qaddress,
			String qpassword) {
		Session session=sessionFactory.openSession();
		SQLQuery query=null;
    	Transaction ts=session.beginTransaction();
    	String idSql="select MAX(quserid)+1 from q_user";
    	query=session.createSQLQuery(idSql);
    	BigInteger bi=null;
    	int idDb=1;
    	if (query.uniqueResult()!=null){
          bi=(BigInteger)query.uniqueResult();
        idDb=Integer.parseInt(bi.toString());
    	}
    	String sql=" insert into q_user "+
  "(quserid,qname, qpassword, qaddress, qmoney, qtel)"+
  " values "+
  " (?, ?, ?, ?, 0, ?) ";
    	 query=session.createSQLQuery(sql);
    	query.setInteger(0, idDb);
    	query.setString(1, qname);
    	query.setString(2, qpassword);
    	query.setString(3, qaddress);
    	query.setString(4, qtel);
    	int temp=query.executeUpdate();
    	ts.commit();
    	session.close();
    	return temp;
	}
	/**
	 * 根据用户名修改用户地址和电话
	 * @param qname
	 * @param qaddress
	 * @param qtel
	 * @return
	 */
	public int updQUserInf(String qname, String qaddress, String qtel) {
	    Session session=sessionFactory.openSession();
	    Transaction ts=session.beginTransaction();
	    String sql="update q_user set qaddress = ?,qtel = ? where qname = ? ";
	    SQLQuery query=session.createSQLQuery(sql);
    	query.setString(0,qaddress);
    	query.setString(1,qtel);
    	query.setString(2,qname);
    	int temp=0;
    	try {
			temp=query.executeUpdate();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("插入后改变的记录数："+temp);
    	ts.commit();
    	session.close();
    	return temp;
	}
	  /**
	    * 给用户的账户新增金额
	    * @param qname
	    * @param addM
	    * @return
	    */
	public int isAdd(String qname, int addM) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
	   /* String sql="select QMONEY from q_user where qname=? ";
	    SQLQuery q=session.createSQLQuery(sql);
	    q.setString(0, qname);
	    q.addEntity(QUser.class);
	    int qmoney=0;
	    try {
			qmoney=(Integer) q.uniqueResult();
		} catch (HibernateException e1) {
			e1.printStackTrace();
		}
	    int totalmoney=qmoney+addM;*/
	    String sql2="update q_user set qmoney = qmoney+? where qname = ? ";
	    SQLQuery q2=session.createSQLQuery(sql2);
	    q2.setInteger(0, addM);
	    q2.setString(1, qname);
	    int temp=0;
    	try {
			temp=q2.executeUpdate();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("插入后改变的记录数："+temp);
    	ts.commit();
    	session.close();
    	return temp;
	    
	}
	public QUser selQUserByid(int userid) {
		Session session=sessionFactory.openSession();
		String hql=" from QUser where quserid=? ";
		Query query=session.createQuery(hql);
		query.setInteger(0, userid);
		QUser qUser=(QUser) query.uniqueResult();
		session.close();
		return qUser;
	}
    
	
}
