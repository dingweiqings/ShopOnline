package com.etc.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.QUserBiz;

import com.etc.dao.QUserDao;
import com.etc.entity.QUser;
/**
 * ��Q_User�����ҵ����Ĳ���
 * @author tl
 *
 */
@Component("qUserBiz")
public class QUserBizImpl implements QUserBiz{
	@Autowired
	private QUserDao  qUserDao;
	   /**
	    * �����û�id���û������ж��Ƿ��½�ɹ�
	    * @param quserid
	    * @param qpassword
	    * @return
	    */
    public boolean isLoginOk(String qname, String qpassword) {
    	boolean flag=false;
    	System.out.println("when login introduce qname "+qname);
    	System.out.println("isLoginOk  27 "+qUserDao.selQUserByName(qname).getQpassword());
		if(qUserDao.selQUserByName(qname).getQpassword().equals(qpassword)){
			flag=true;
		}
		System.out.println("isLoginOk function 32 "+ flag);
		return flag;
	}
      /**
	   * �����û������ж��Ƿ���ڸ��û�
	   * @param qname
	   * @return
	   */
	public boolean getQuserByName(String qname) {
		boolean flag=true;
		if(qUserDao.selQUserByName(qname)==null||qUserDao.selQUserByName(qname).equals("")){
			flag=false;
		}
		return flag;
	}
	 /**
	    * �ж��û��Ƿ�ע��ɹ�
	    * @param qname
	    * @param qtel
	    * @param qaddress
	    * @param qpassword
	    * @return
	    */
	public boolean isInsOk(String qname, String qtel, String qaddress,
			String qpassword) {
		if(qUserDao.insQUserInf(qname, qtel, qaddress, qpassword)>0){
			return true;
		}else{
		return false;
		}
	}
	   /**
	    * ����������ѯ�û�
	    * @param qname
	    * @return
	    */
	public QUser selQuserByName(String qname) {
		QUser quser=qUserDao.selQUserByName(qname);
		return quser;
	}
	/**
	    * �ж��û��ĵ�ַ�͵绰�Ƿ���ĳɹ�
	    * @param qname
	    * @param qaddress
	    * @param qtel
	    * @return
	    */
	public boolean isUpdate(String qname, String qaddress, String qtel) {
		if(qUserDao.updQUserInf(qname, qaddress, qtel)>0){
			return true;
		}else{
		return false;
		}
	}
	  /**
	    * �ж��û����˻�����Ƿ����ӳɹ�
	    * @param qname
	    * @param addM
	    * @return
	    */
	public boolean isAdd(String qname, int addM) {
		if(qUserDao.isAdd(qname, addM)>0){
			return true;
		}else{
		return false;
		}
	}
	public int getUserid(String qname) {
		return qUserDao.selQUserByName(qname).getQuserid();
		
	}
	public String getUserName(int userid) {
		// TODO Auto-generated method stub
		return qUserDao.selQUserByid(userid).getQname();
	}

	
}
