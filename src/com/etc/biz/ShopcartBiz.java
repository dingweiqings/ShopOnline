package com.etc.biz;

import java.util.List;

import com.etc.entity.QTrolley;


public interface ShopcartBiz {
	/**
	 * �����û�id��ѯ���û��Ĺ��ﳵ
	 * @param userid
	 * @return
	 */
	public List<QTrolley> getAllQtrolley(int userid);
	/**
	 * �޸Ĺ��ﳵ����Ʒ������
	 * @param trolleyid
	 * @param trolleynum
	 * @return
	 */
	public boolean updateQtrolley(int trolleyid,int trolleynum);

	/**
	 * ���ﳵ�������Ʒ
	 * @param userid
	 * @param cloid
	 * @param trolleynum
	 * @return
	 */
	public boolean insertQtrolley(int userid,int cloid,int trolleynum);
	
	/**
	 * ʹ�ã��û��ӹ��ﳵ�б���ɾ�����빺�����Ʒ 
	 * ���ݹ��ﳵidɾ�����ﳵ�ж�Ӧ�ļ�¼
	 * @param trolleyid  ���ﳵ���¼id
	 * @return
	 */
	public boolean delectQTrolleyByid(int trolleyid);
	

}
