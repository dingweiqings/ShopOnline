package com.etc.biz;

import java.util.List;

import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.etc.entity.QUser;

public interface GwCartBiz {

	/**
	 * 根据用户id查询当前是否有订单表
	 * （即当前状态未0---未付款状态）
	 * @param userid 用户id
	 * @return
	 */
	public QOrder getOneOrdering(int userid);
	/**
	 * 通过商品id查询商品的详细信息
	 * @param cloid
	 * @return
	 */
	public QCloth selectQClothByid(int cloid);
	
	/**
	 * 根据用户id查询当前是否有订单表，并返回订单表的id
	 * （即当前状态未0---未付款状态）
	 * @param userid 用户id
	 * @return 该用户的定单id
	 */
	public int getOneOrder(int userid);
	/**
	 * 向定单详情表中添加商品信息
	 * @param qdorder 定单表id
	 * @param cloid 商品id
	 * @param ordernum 商品数量
	 * @param orderlx 商品类型
	 * @return
	 */
	public boolean insertQOrderdetail(int qdorder,int cloid,int ordernum,String orderlx);
	
	/***************************************以上是向定单中添加商品**********************************************/
	/**
	 * 根据定单id取出定单详细表作为购物车
	 * @param qdorder 定单id
	 * @return 用户的购物车中的全部信息
	 */
	public List<QOrderdetail> getQOrderdetail(int qdorder);
	
	/**
	 * 根据订单详细表id删除该条记录
	 * 用法：从购物车中删除某条记录
	 * @param orderid 定单详细表的id
	 * @return 该条记录是否成功删除
	 */
	public boolean delectQOrderdetail(int orderid);
	
	/**
	 * 修改购物车中某种商品的数量
	 * @param orderid 商品详细表id
	 * @param ordernum 商品数量
	 * @return 修改结果是否成功
	 */
	public boolean updatetrlley(int orderid,int ordernum);
	/****************************************以上是查询购物车中的数据*************************************************************/
	
	/**
	 * 查询该订单表的主键
	 * @param userid
	 * @return
	 */
	public int insertOneOrdered(int userid,int chk_value[]);
	
	/**
	 * 判断商品是否成功添加真实价格以及库存是否足够
	 * @param orderid 商品详细表id
	 * @return
	 * @throws Exception 
	 */
	public boolean updateQuserelprice(int orderid) throws Exception;
	
	/**
	 * 根据定单详细表查询该条商品的部分信息
	 * @param orderid 定单详细表id
	 * @return 定单详细表
	 */
	public QOrderdetail getQOrderdetailByid(int orderid);
	
	/**
	 * 判断该用户的账户余额是否足够购买商品
	 * @param userid 用户id
	 * @param qdorder 新生成的历史定单的id
	 * @return
	 */
	public boolean userMoneyOk(int userid,int qdorder);
	
	/**
	 * 判断定单详情表是否修改成功
	 * @param orderid 定单详情表id
	 * @param qdorder 历史订单表id
	 * @return 修改的结果
	 */
	public boolean updateOrdertoOrdered(int orderid, int qdorder);
	
	/**
	 * 查看该用户最新生成的历史订单id 
	 * @param userid 用户id
	 * @return 该用户最新生成的历史订单id 
	 */
	public int newOrdered(int userid);
	
	/**
	 * 根据新生成的历史订单中的商品总额修改该用户的账户余额
	 * @param userid
	 * @param qdorderid
	 * @return
	 */
	public boolean updateUsermoney(int userid,int qdorderid);
	
	
	/**
	 * 根据用户id得到用户信息
	 * @param userid 用户信息
	 * @return 用户信息
	 */
	public QUser getUser(int userid);
	public boolean updateQCloth();
	public double getAllMoney(int[] id);
	
}
