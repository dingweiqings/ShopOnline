package com.etc.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.etc.dao.CartDao;
import com.etc.entity.QOrder;
import com.etc.util.HibernateSessionFactory;

@Component("cartDao")
public class CartDaoImpl implements CartDao {
/*
 * 点击加入购物车，先看q_order中是否存在，不存在添加，一个用户只对应一个q_order,购买多个衣服在q_orderdetail中
 * @see com.etc.dao.CartDao#addclo(int, int, int, int)
 */	
	@SuppressWarnings("deprecation")
	public int addclo(int userid, int cloid, int clonum, int closize) {
	
		Session session = HibernateSessionFactory.getSession();
		String hql1 = "from QOrder where quserid=? and orderstate='0'";

		Query query1 = session.createQuery(hql1);
		query1.setInteger(0, userid);
		QOrder ord1 = (QOrder) query1.uniqueResult();
		
		if (ord1 == null || "".equals(ord1)) {//如果不存在该用户的订单
			String sql1 = "insert into q_order ( quserid, orderdate,orderstate) values ( ?,?, '0')";
			SQLQuery sq1 = session.createSQLQuery(sql1);
			sq1.setInteger(0, userid);
			SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-DD");
		       
			Date date=null;
			try {
				date = sf.parse(sf.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
					//new Date(sf.format(new Date()));
			sq1.setDate(1, date);
			//sq1.addEntity(QOrder.class);

			sq1.executeUpdate();
			session.beginTransaction().commit();

			
		}
		//重新查一次,确保添加用户订单成功
		ord1 = (QOrder) query1.uniqueResult();
		
         if (ord1==null)
        	 return 0;
		if (ord1.getQdorder() > 0) {//当存在该用户的订单

			String hql3 = "select count(*) from  q_orderdetail where qdorder=? and cloid=? and orderlx=?";
			SQLQuery sq3=null;
			try {
			sq3 = session.createSQLQuery(hql3);
		}catch(Exception e) {
			e.printStackTrace();
		}
			sq3.setInteger(0, ord1.getQdorder());
			sq3.setInteger(1, cloid);
			sq3.setInteger(2, closize);
			//sq3.addEntity(QOrderdetail.class);

	//	QOrderdetail detail = (QOrderdetail) sq3.uniqueResult();
			Long count=0L;
			try {
				Object obj=sq3.uniqueResult();
				if(obj instanceof Long)
				 count=((Long)sq3.uniqueResult()).longValue();
				else {
					count=Long.valueOf(obj.toString());
				}
					
			}catch(Exception e) {
				e.printStackTrace();
			}
           
			if (count==0 ) {
				String sql2 = "insert into q_orderdetail ( qdorder, cloid, ordernum, orderprice, orderlx) values "
						+ "( ?, ?, ?, (select cloprice from q_cloth where cloid=?) , ?) ";
				SQLQuery sq2 = session.createSQLQuery(sql2);
				sq2.setInteger(0, ord1.getQdorder());
				sq2.setInteger(1, cloid);
				sq2.setInteger(2, clonum);
				sq2.setInteger(3, cloid);
				sq2.setInteger(4, closize);
				int temp=0;
				try{
				 temp = sq2.executeUpdate();
				}catch(Exception e){
					e.printStackTrace();
				}
				session.beginTransaction().commit();
				session.close();
			
				return temp;
			} else {
              
				String sql4 = "update q_orderdetail set ordernum = ordernum+? where qdorder = ? and cloid=? and orderlx=?";
				SQLQuery sq4 = session.createSQLQuery(sql4);
				sq4.setInteger(0, clonum );
				sq4.setInteger(1, ord1.getQdorder());
				sq4.setInteger(2, cloid);
				sq4.setInteger(3, closize);

				int temp = sq4.executeUpdate();
				session.beginTransaction().commit();
				session.close();
				return temp;
			}

		}

		return 0;
	}

	
}
