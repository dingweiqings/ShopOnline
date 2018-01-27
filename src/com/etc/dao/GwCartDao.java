package com.etc.dao;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.etc.entity.QUser;

public interface GwCartDao {
	/**
	 * 根据用户id查询当前是否有订单表
	 * （即当前状态未0---未付款状态）
	 * @param userid 用户id
	 * @return
	 */
	public QOrder getOneOrder(int userid);
	
	/**
	 * 如果该用户没有订单表，则新创建一个订单表(购物车总表)，表中属性赋值
	 * 定单id----->自动生成
	 * 用户id----->参数注入
	 * 定单状态---->定值设为0，即未付款状态
	 * @param userid 用户id
	 * @return
	 */
	public int insertOneOrder(int userid);
	
	/**
	 * 通过商品id查询商品的详细信息
	 * @param cloid
	 * @return
	 */
	public QCloth selectQClothByid(int cloid);
	/**
	 * 向定单详情表中添加商品信息
	 * 定单表id--->后台查询得到
	 * 商品信息---->根据前台传来的商品id从后台数据库取得
	 * 商品数量---->前台传来
	 * 商品类型---->前台传来
	 * @param qdorder 定单表id
	 * @param qCloth 商品信息
	 * @param ordernum 商品数量
	 * @param orderlx 商品类型
	 * @return
	 */
	public int insertQOrderdetail(int qdorder,int cloid,int orderprice,int ordernum,String orderlx);
	
	/***************************************以上是向定单中添加商品**********************************************/
	/**
	 * 根据定单id取出定单详细表作为购物车
	 * @param qdorder 定单id
	 * @return
	 */
	public List<QOrderdetail> getQOrderdetail(int qdorder);
	
	/**
	 * 根据订单详细表id删除该条记录
	 * 用法：从购物车中删除某条记录
	 * @param orderid 定单详细表的id
	 * @return 被修改的数据库表的行数
	 */
	public int delectQOrderdetail(int orderid);
	
	/**
	 * 修改购物车中某种商品的数量
	 * @param orderid 商品详细表id
	 * @param ordernum 商品数量
	 * @return 修改结果是否成功
	 */
	public int updatetrlley(int orderid,int ordernum);
	
	/****************************************以上是查询购物车中的数据*************************************************************/
	
	/**
	 * 通过商品查询该商品的折扣
	 * @param clotype 商品的类型
	 * @return 商品的折扣
	 */
	public double getActivitynum(String clotype);
	
	/**
	 * 根据商品详细表id添加该商品的实际价格
	 * 在将购物车中商品添加到定单进行付款时，添加商品的实际价格
	 * @param orderid 商品详细表id
	 * @param quserelprice 商品的实际价格
	 * @return 数据库中被修改的行数
	 */
	public int updateQuserelprice(int orderid,int quserelprice);
	
	/**
	 * 根据定单详细表查询该条商品的部分信息
	 * @param orderid 定单详细表id
	 * @return 定单详细表
	 */
	public QOrderdetail getQOrderdetailByid(int orderid);
	
	/**
	 * 如果该用户没有订单表，则新创建一个订单表(已经付款的定单表)，表中属性赋值
	 * 定单id----->自动生成
	 * 用户id----->参数注入
	 * 定单状态---->定值设为1，即已付款状态
	 * 定单生成日期--->当前系统时间
	 * @param userid 用户id
	 * @param qdprice 定单的总价
	 * @return 返回该定单的id
	 */
	public int insertOneOrdered(int userid,int qdprice);
		
	/**
	 * 根据用户id查询当前是否有订单表
	 * （即当前状态为1---已付款状态）查看历史定单
	 * @param userid 用户id
	 * @return
	 */
	public QOrder getOneOrdered(int userid);
	
	/**
	 * 查询定单的总金额
	 * @param chk_value
	 * @return
	 * @throws Exception 
	 */
	public int getAllMoney(int chk_value[]) throws Exception;
	
	/**
	 * 根据用户id得到用户信息
	 * @param userid 用户信息
	 * @return 用户信息
	 */
	public QUser getUser(int userid);
	
	/**
	 * 修改定单详情表到历史定单中
	 * @param orderid 定单详情id
	 * @param qdorder  定单id
	 * @return
	 */
	public int updateOrdertoOrdered(int orderid,int qdorder);
	
	/**
	 * 查询新生成的历史订单中的订单总金额
	 * @param qdorder 新生成的历史订单id
	 * @return 总金额
	 */
	public int selectOrderMoney(int qdorder);
	
	/**
	 * 查看该用户最新生成的历史订单id 
	 * @param userid 用户id
	 * @return 该用户最新生成的历史订单id 
	 */
	public int newOrdered(int userid);
	
	/**
	 * 修改用户的账户余额
	 * @param userid
	 * @param money
	 * @return
	 */
	public int updateUserMoney(int userid,int money);
	
}
