package com.etc.biz;

import com.etc.entity.QUser;

public interface QUserBiz {
	  /**
	   * �����û������ж��Ƿ���ڸ��û�
	   * @param qname
	   * @return
	   */
	  public boolean getQuserByName(String qname);
	  /**
	   * �����û�����ѯ�û�id
	   * @param qname
	   * @return
	   */
	  public int getUserid(String qname);
	  
	  /**
	   * �����û�id��ѯ�û���
	   * @param userid
	   * @return
	   */
	  public String getUserName(int userid);
	  
	   /**
	    * �����û�id���û������ж��Ƿ��½�ɹ�
	    * @param quserid
	    * @param qpassword
	    * @return
	    */
	   public boolean isLoginOk(String qname,String qpassword);
	   /**
	    * �ж��û��Ƿ�ע��ɹ�
	    * @param qname
	    * @param qtel
	    * @param qaddress
	    * @param qpassword
	    * @return
	    */
	   public boolean isInsOk(String qname, String qtel, String qaddress,
			String qpassword);
	   /**
	    * ����������ѯ�û�
	    * @param qname
	    * @return
	    */
	   public QUser selQuserByName(String qname);
	   /**
	    * �ж��û��ĵ�ַ�͵绰�Ƿ���ĳɹ�
	    * @param qname
	    * @param qaddress
	    * @param qtel
	    * @return
	    */
	   public boolean isUpdate(String qname, String qaddress, String qtel);
	   /**
	    * �ж��û����˻�����Ƿ����ӳɹ�
	    * @param qname
	    * @param addM
	    * @return
	    */
	   public boolean isAdd(String qname, int addM);
} 
