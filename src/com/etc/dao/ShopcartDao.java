package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QTrolley;


public interface ShopcartDao {
	/**
	 * �����û�id��ѯ���û��Ĺ��ﳵ
	 * @param userid
	 * @return
	 */
	public List<QTrolley> getAllQtrolley(int userid);
	/**
	 * �޸Ĺ��ﳵ����Ʒ���������д���û���޸��ܼۣ�
	 * @param trolleyid
	 * @param trolleynum
	 * @return
	 */
	public int updateQtrolley(int trolleyid,int trolleynum);
	/**
	 * ���ﳵ���������
	 * @param userid �û�id
	 * @param cloid  ��Ʒid
	 * @param trolleyprice ��Ʒʵ�ʼ۸�
	 * @param trolleynum ��Ʒ����
	 * @param trolleysum ��Ʒ�ܼ�
	 * @return
	 */
	public int insertQtrolley(int userid,int cloid,int trolleyprice,int trolleynum,int trolleysum);
	/**
	 * ��ѯĳ����Ʒ��ʵ�ʼ۸�
	 * @param cloid
	 * @return
	 */
	public QCloth selectRelPrice(int cloid);
	/**
	 * ��ѯ���ʱ�̵���Ʒ���ۿ�
	 * @param activityid
	 * @return
	 */
	public double selectActivitynum(int activityid);
	/**
	 * ʹ�ã��û��ӹ��ﳵ�б���ɾ�����빺�����Ʒ 
	 * ���ݹ��ﳵidɾ�����ﳵ�ж�Ӧ�ļ�¼
	 * @param trolleyid  ���ﳵ���¼id
	 * @return
	 */
	public int delectQTrolleyByid(int trolleyid);

}
