package com.etc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etc.biz.GwCartBiz;

import com.etc.dao.GwCartDao;
import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.etc.entity.QUser;

@Service("gwCartBiz")
public class GwCartBizImpl implements GwCartBiz {
	@Autowired
	private GwCartDao gwCartDao;
	public int getOneOrder(int userid) {
		if(gwCartDao.getOneOrder(userid)!=null){
			return gwCartDao.getOneOrder(userid).getQdorder();
		}else{
			gwCartDao.insertOneOrder(userid);
			return gwCartDao.getOneOrder(userid).getQdorder();
		}
	}
	public boolean insertQOrderdetail(int qdorder, int cloid, int ordernum,
			String orderlx) {
		int orderprice=gwCartDao.selectQClothByid(cloid).getCloprice();
		return gwCartDao.insertQOrderdetail(qdorder, cloid, orderprice, ordernum, orderlx)>0?true:false;
	}
	public List<QOrderdetail> getQOrderdetail(int qdorder) {
		return gwCartDao.getQOrderdetail(qdorder);
	}
	public int insertOneOrdered(int userid,int chk_value[]) {
		
		try{
		int qdprice=gwCartDao.getAllMoney(chk_value);//�õ��������е���Ʒ�ܼ�
		int qdorder=gwCartDao.insertOneOrdered(userid,qdprice);//����һ���µ���ʷ����
		return qdorder;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public boolean updateQuserelprice(int orderid) throws Exception {
		QOrderdetail qOrderdetail=gwCartDao.getQOrderdetailByid(orderid);
		QCloth qCloth=qOrderdetail.getQCloth();
		//System.out.println("GexBiz "+qCloth.getClotype());
		int price=qOrderdetail.getOrderprice();//����Ʒ��ԭ��
		int cloid=qCloth.getCloid();
		String clotype=gwCartDao.selectQClothByid(cloid).getClotype();//����Ʒ������(ȷ���ڻ���Ƿ�����ۿ�)
		double num=gwCartDao.getActivitynum(clotype);//ȡ�û�Ĵ���
		int quserelprice=(int) (price*num);
		String orderlx=qOrderdetail.getOrderlx();//�õ���Ʒ������
		int ordernum=qOrderdetail.getOrdernum();//�õ��ö�����ϸ���и���Ʒ������
		//�ж��Ñ����~�Ƿ����
		if(gwCartDao.updateQuserelprice(orderid, quserelprice)>0){
			//�ж���Ʒ�Ŀ���Ƿ��㹻
			if("1".equals(orderlx)&&ordernum<=qCloth.getClonums()){//orderlx��Ʒ����
				return true;
			}else if ("2".equals(orderlx)&&ordernum<=qCloth.getClonuml()) {
				return true;
			}else if("3".equals(orderlx)&&ordernum<=qCloth.getClonumm()){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	public QOrder getOneOrdering(int userid) {
		return gwCartDao.getOneOrder(userid);
	}
	public QCloth selectQClothByid(int cloid) {
		return gwCartDao.selectQClothByid(cloid);
	}
	public boolean delectQOrderdetail(int orderid) {
		return gwCartDao.delectQOrderdetail(orderid)>0?true:false;
	}
	public QOrderdetail getQOrderdetailByid(int orderid) {
		return gwCartDao.getQOrderdetailByid(orderid);
	}
	public boolean userMoneyOk(int userid, int qdorder) {
		int usermoney=gwCartDao.getUser(userid).getQmoney();
		int allmoney=gwCartDao.selectOrderMoney(qdorder);
		return usermoney>=allmoney?true:false;
	}
	public boolean updateOrdertoOrdered(int orderid, int qdorder) {
		
		return gwCartDao.updateOrdertoOrdered(orderid, qdorder)>0?true:false;
	}
	public boolean updatetrlley(int orderid, int ordernum) {
		
		return gwCartDao.updatetrlley(orderid, ordernum)>0?true:false;
	}
	public int newOrdered(int userid) {
		return gwCartDao.newOrdered(userid);
	}
	public boolean updateUsermoney(int userid, int qdorderid) {
		int allmoney=gwCartDao.selectOrderMoney(qdorderid);
		return gwCartDao.updateUserMoney(userid, allmoney)>0?true:false;
	}
	public QUser getUser(int userid) {
		return gwCartDao.getUser(userid);
	}
	@Override
	public boolean updateQCloth() {
		return true;
	}
	@Override
	public double getAllMoney(int[] id) {
		double result = 0;
		try {
			result = gwCartDao.getAllMoney(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
