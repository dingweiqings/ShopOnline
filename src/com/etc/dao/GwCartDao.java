package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.etc.entity.QUser;

public interface GwCartDao {
	/**
	 * �����û�id��ѯ��ǰ�Ƿ��ж�����
	 * ������ǰ״̬δ0---δ����״̬��
	 * @param userid �û�id
	 * @return
	 */
	public QOrder getOneOrder(int userid);
	
	/**
	 * ������û�û�ж��������´���һ��������(���ﳵ�ܱ�)���������Ը�ֵ
	 * ����id----->�Զ�����
	 * �û�id----->����ע��
	 * ����״̬---->��ֵ��Ϊ0����δ����״̬
	 * @param userid �û�id
	 * @return
	 */
	public int insertOneOrder(int userid);
	
	/**
	 * ͨ����Ʒid��ѯ��Ʒ����ϸ��Ϣ
	 * @param cloid
	 * @return
	 */
	public QCloth selectQClothByid(int cloid);
	/**
	 * �򶨵�������������Ʒ��Ϣ
	 * ������id--->��̨��ѯ�õ�
	 * ��Ʒ��Ϣ---->����ǰ̨��������Ʒid�Ӻ�̨���ݿ�ȡ��
	 * ��Ʒ����---->ǰ̨����
	 * ��Ʒ����---->ǰ̨����
	 * @param qdorder ������id
	 * @param qCloth ��Ʒ��Ϣ
	 * @param ordernum ��Ʒ����
	 * @param orderlx ��Ʒ����
	 * @return
	 */
	public int insertQOrderdetail(int qdorder,int cloid,int orderprice,int ordernum,String orderlx);
	
	/***************************************�������򶨵��������Ʒ**********************************************/
	/**
	 * ���ݶ���idȡ��������ϸ����Ϊ���ﳵ
	 * @param qdorder ����id
	 * @return
	 */
	public List<QOrderdetail> getQOrderdetail(int qdorder);
	
	/**
	 * ���ݶ�����ϸ��idɾ��������¼
	 * �÷����ӹ��ﳵ��ɾ��ĳ����¼
	 * @param orderid ������ϸ���id
	 * @return ���޸ĵ����ݿ�������
	 */
	public int delectQOrderdetail(int orderid);
	
	/**
	 * �޸Ĺ��ﳵ��ĳ����Ʒ������
	 * @param orderid ��Ʒ��ϸ��id
	 * @param ordernum ��Ʒ����
	 * @return �޸Ľ���Ƿ�ɹ�
	 */
	public int updatetrlley(int orderid,int ordernum);
	
	/****************************************�����ǲ�ѯ���ﳵ�е�����*************************************************************/
	
	/**
	 * ͨ����Ʒ��ѯ����Ʒ���ۿ�
	 * @param clotype ��Ʒ������
	 * @return ��Ʒ���ۿ�
	 */
	public double getActivitynum(String clotype);
	
	/**
	 * ������Ʒ��ϸ��id��Ӹ���Ʒ��ʵ�ʼ۸�
	 * �ڽ����ﳵ����Ʒ��ӵ��������и���ʱ�������Ʒ��ʵ�ʼ۸�
	 * @param orderid ��Ʒ��ϸ��id
	 * @param quserelprice ��Ʒ��ʵ�ʼ۸�
	 * @return ���ݿ��б��޸ĵ�����
	 */
	public int updateQuserelprice(int orderid,int quserelprice);
	
	/**
	 * ���ݶ�����ϸ���ѯ������Ʒ�Ĳ�����Ϣ
	 * @param orderid ������ϸ��id
	 * @return ������ϸ��
	 */
	public QOrderdetail getQOrderdetailByid(int orderid);
	
	/**
	 * ������û�û�ж��������´���һ��������(�Ѿ�����Ķ�����)���������Ը�ֵ
	 * ����id----->�Զ�����
	 * �û�id----->����ע��
	 * ����״̬---->��ֵ��Ϊ1�����Ѹ���״̬
	 * ������������--->��ǰϵͳʱ��
	 * @param userid �û�id
	 * @param qdprice �������ܼ�
	 * @return ���ظö�����id
	 */
	public int insertOneOrdered(int userid,int qdprice);
		
	/**
	 * �����û�id��ѯ��ǰ�Ƿ��ж�����
	 * ������ǰ״̬Ϊ1---�Ѹ���״̬���鿴��ʷ����
	 * @param userid �û�id
	 * @return
	 */
	public QOrder getOneOrdered(int userid);
	
	/**
	 * ��ѯ�������ܽ��
	 * @param chk_value
	 * @return
	 * @throws Exception 
	 */
	public int getAllMoney(int chk_value[]) throws Exception;
	
	/**
	 * �����û�id�õ��û���Ϣ
	 * @param userid �û���Ϣ
	 * @return �û���Ϣ
	 */
	public QUser getUser(int userid);
	
	/**
	 * �޸Ķ����������ʷ������
	 * @param orderid ��������id
	 * @param qdorder  ����id
	 * @return
	 */
	public int updateOrdertoOrdered(int orderid,int qdorder);
	
	/**
	 * ��ѯ�����ɵ���ʷ�����еĶ����ܽ��
	 * @param qdorder �����ɵ���ʷ����id
	 * @return �ܽ��
	 */
	public int selectOrderMoney(int qdorder);
	
	/**
	 * �鿴���û��������ɵ���ʷ����id 
	 * @param userid �û�id
	 * @return ���û��������ɵ���ʷ����id 
	 */
	public int newOrdered(int userid);
	
	/**
	 * �޸��û����˻����
	 * @param userid
	 * @param money
	 * @return
	 */
	public int updateUserMoney(int userid,int money);
	
}
