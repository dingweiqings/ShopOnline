package com.etc.dao;

public interface CartDao {

	/**
	 * ����Ʒ���ӵ�ُ��܇��
	 * @return int(>0:�ɹ�/<=0:ʧ��)
	 */
	public int addclo(int userid,int cloid,int clonum,int closize);
}
