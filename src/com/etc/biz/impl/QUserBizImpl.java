package com.etc.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etc.biz.QUserBiz;

import com.etc.dao.QUserDao;
import com.etc.entity.QUser;
/**
 * 对Q_User表进行业务处理的操作
 * @author tl
 *
 */
@Component("qUserBiz")
public class QUserBizImpl implements QUserBiz{
	@Autowired
	private QUserDao  qUserDao;
	   /**
	    * 根据用户id和用户密码判断是否登陆成功
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
	   * 根据用户姓名判断是否存在该用户
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
	    * 判断用户是否注册成功
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
	    * 根据姓名查询用户
	    * @param qname
	    * @return
	    */
	public QUser selQuserByName(String qname) {
		QUser quser=qUserDao.selQUserByName(qname);
		return quser;
	}
	/**
	    * 判断用户的地址和电话是否更改成功
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
	    * 判断用户的账户金额是否增加成功
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
