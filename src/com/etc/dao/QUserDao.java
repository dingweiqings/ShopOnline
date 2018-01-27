package com.etc.dao;

import com.etc.entity.QUser;

   /**
    * ��Q_User����еĲ����淶
    * 
    * @author tl
    * 
    */
    public interface QUserDao {
	/**
	 * �����û��������ض�Ӧ���û�����
	 * 
	 * @param qname
	 * @return
	 */
	public QUser selQUserByName(String qname);
	/**
	 * �����û�id��ѯ�û�����
	 * @param userid
	 * @return
	 */
	public QUser selQUserByid(int userid);
	
    /**
     * ע���û������û�����������Ϣ
     * @param qname
     * @param qtel
     * @param qaddress
     * @param qpassword
     * @return
     */
	public int insQUserInf(String qname,String qtel,String qaddress,String qpassword);
	/**
	 * �����û����޸��û���ַ�͵绰
	 * @param qname
	 * @param qaddress
	 * @param qtel
	 * @return
	 */
	public int updQUserInf(String qname,String qaddress,String qtel);
	   /**
	    * ���û����˻��������
	    * @param qname
	    * @param addM
	    * @return
	    */
	public int isAdd(String qname, int addM);
}
