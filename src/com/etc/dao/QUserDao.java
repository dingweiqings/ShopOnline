package com.etc.dao;

import com.etc.entity.QUser;

   /**
    * 对Q_User表进行的操作规范
    * 
    * @author tl
    * 
    */
    public interface QUserDao {
	/**
	 * 根据用户姓名返回对应的用户对象
	 * 
	 * @param qname
	 * @return
	 */
	public QUser selQUserByName(String qname);
	/**
	 * 根据用户id查询用户对象
	 * @param userid
	 * @return
	 */
	public QUser selQUserByid(int userid);
	
    /**
     * 注册用户，向用户表插入基本信息
     * @param qname
     * @param qtel
     * @param qaddress
     * @param qpassword
     * @return
     */
	public int insQUserInf(String qname,String qtel,String qaddress,String qpassword);
	/**
	 * 根据用户名修改用户地址和电话
	 * @param qname
	 * @param qaddress
	 * @param qtel
	 * @return
	 */
	public int updQUserInf(String qname,String qaddress,String qtel);
	   /**
	    * 给用户的账户新增金额
	    * @param qname
	    * @param addM
	    * @return
	    */
	public int isAdd(String qname, int addM);
}
