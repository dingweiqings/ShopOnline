package com.etc.biz;

import com.etc.entity.QUser;

public interface QUserBiz {
	  /**
	   * 根据用户姓名判断是否存在该用户
	   * @param qname
	   * @return
	   */
	  public boolean getQuserByName(String qname);
	  /**
	   * 根据用户名查询用户id
	   * @param qname
	   * @return
	   */
	  public int getUserid(String qname);
	  
	  /**
	   * 根据用户id查询用户名
	   * @param userid
	   * @return
	   */
	  public String getUserName(int userid);
	  
	   /**
	    * 根据用户id和用户密码判断是否登陆成功
	    * @param quserid
	    * @param qpassword
	    * @return
	    */
	   public boolean isLoginOk(String qname,String qpassword);
	   /**
	    * 判断用户是否注册成功
	    * @param qname
	    * @param qtel
	    * @param qaddress
	    * @param qpassword
	    * @return
	    */
	   public boolean isInsOk(String qname, String qtel, String qaddress,
			String qpassword);
	   /**
	    * 根据姓名查询用户
	    * @param qname
	    * @return
	    */
	   public QUser selQuserByName(String qname);
	   /**
	    * 判断用户的地址和电话是否更改成功
	    * @param qname
	    * @param qaddress
	    * @param qtel
	    * @return
	    */
	   public boolean isUpdate(String qname, String qaddress, String qtel);
	   /**
	    * 判断用户的账户金额是否增加成功
	    * @param qname
	    * @param addM
	    * @return
	    */
	   public boolean isAdd(String qname, int addM);
} 
