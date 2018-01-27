package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.etc.entity.QUser;

public interface GwCartBiz {

	/**
	 * �����û�id��ѯ��ǰ�Ƿ��ж�����
	 * ������ǰ״̬δ0---δ����״̬��
	 * @param userid �û�id
	 * @return
	 */
	public QOrder getOneOrdering(int userid);
	/**
	 * ͨ����Ʒid��ѯ��Ʒ����ϸ��Ϣ
	 * @param cloid
	 * @return
	 */
	public QCloth selectQClothByid(int cloid);
	
	/**
	 * �����û�id��ѯ��ǰ�Ƿ��ж����������ض������id
	 * ������ǰ״̬δ0---δ����״̬��
	 * @param userid �û�id
	 * @return ���û��Ķ���id
	 */
	public int getOneOrder(int userid);
	/**
	 * �򶨵�������������Ʒ��Ϣ
	 * @param qdorder ������id
	 * @param cloid ��Ʒid
	 * @param ordernum ��Ʒ����
	 * @param orderlx ��Ʒ����
	 * @return
	 */
	public boolean insertQOrderdetail(int qdorder,int cloid,int ordernum,String orderlx);
	
	/***************************************�������򶨵��������Ʒ**********************************************/
	/**
	 * ���ݶ���idȡ��������ϸ����Ϊ���ﳵ
	 * @param qdorder ����id
	 * @return �û��Ĺ��ﳵ�е�ȫ����Ϣ
	 */
	public List<QOrderdetail> getQOrderdetail(int qdorder);
	
	/**
	 * ���ݶ�����ϸ��idɾ��������¼
	 * �÷����ӹ��ﳵ��ɾ��ĳ����¼
	 * @param orderid ������ϸ���id
	 * @return ������¼�Ƿ�ɹ�ɾ��
	 */
	public boolean delectQOrderdetail(int orderid);
	
	/**
	 * �޸Ĺ��ﳵ��ĳ����Ʒ������
	 * @param orderid ��Ʒ��ϸ��id
	 * @param ordernum ��Ʒ����
	 * @return �޸Ľ���Ƿ�ɹ�
	 */
	public boolean updatetrlley(int orderid,int ordernum);
	/****************************************�����ǲ�ѯ���ﳵ�е�����*************************************************************/
	
	/**
	 * ��ѯ�ö����������
	 * @param userid
	 * @return
	 */
	public int insertOneOrdered(int userid,int chk_value[]);
	
	/**
	 * �ж���Ʒ�Ƿ�ɹ������ʵ�۸��Լ�����Ƿ��㹻
	 * @param orderid ��Ʒ��ϸ��id
	 * @return
	 * @throws Exception 
	 */
	public boolean updateQuserelprice(int orderid) throws Exception;
	
	/**
	 * ���ݶ�����ϸ���ѯ������Ʒ�Ĳ�����Ϣ
	 * @param orderid ������ϸ��id
	 * @return ������ϸ��
	 */
	public QOrderdetail getQOrderdetailByid(int orderid);
	
	/**
	 * �жϸ��û����˻�����Ƿ��㹻������Ʒ
	 * @param userid �û�id
	 * @param qdorder �����ɵ���ʷ������id
	 * @return
	 */
	public boolean userMoneyOk(int userid,int qdorder);
	
	/**
	 * �ж϶���������Ƿ��޸ĳɹ�
	 * @param orderid ���������id
	 * @param qdorder ��ʷ������id
	 * @return �޸ĵĽ��
	 */
	public boolean updateOrdertoOrdered(int orderid, int qdorder);
	
	/**
	 * �鿴���û��������ɵ���ʷ����id 
	 * @param userid �û�id
	 * @return ���û��������ɵ���ʷ����id 
	 */
	public int newOrdered(int userid);
	
	/**
	 * ���������ɵ���ʷ�����е���Ʒ�ܶ��޸ĸ��û����˻����
	 * @param userid
	 * @param qdorderid
	 * @return
	 */
	public boolean updateUsermoney(int userid,int qdorderid);
	
	
	/**
	 * �����û�id�õ��û���Ϣ
	 * @param userid �û���Ϣ
	 * @return �û���Ϣ
	 */
	public QUser getUser(int userid);
	public boolean updateQCloth();
	public double getAllMoney(int[] id);
	
}
