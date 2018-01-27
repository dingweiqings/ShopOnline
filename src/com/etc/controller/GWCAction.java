package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.GwCartBiz;
import com.etc.entity.QCloth;
import com.etc.entity.QOrder;
import com.etc.entity.QOrderdetail;
import com.google.gson.Gson;
/**
 * 对购物车进行操作
 * @author 82461
 *
 */
public class GWCAction {
	@Autowired
	private GwCartBiz gwCartBiz;
	private HttpSession session;
	private int orderid;
	private int ordernum;
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	/**
	 * 使用异步刷新取出购物车中的数据
	 */
	public void doAllOrder()  throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String str="";
		
		if(session.getAttribute("userid")!=null){
			int userid=(Integer) session.getAttribute("userid");//如果用户名存在，则从数据库中取出购物车数据
			int qdorder=gwCartBiz.getOneOrder(userid);
			List<QOrderdetail> list=gwCartBiz.getQOrderdetail(qdorder);
			int orderDetailSize= list.size();
			List<QOrderdetail>  listGouWuChe=new ArrayList<QOrderdetail>();
			for (int i = 0; i <orderDetailSize; i++) {
				int orderid=list.get(i).getOrderid();
				QOrder qOrder=new QOrder(qdorder, userid);
				
				QCloth qCloth=gwCartBiz.selectQClothByid(list.get(i).getQCloth().getCloid());
				QCloth qCloth1=null;
				try{
					if(qCloth!=null)
				 qCloth1=new QCloth(qCloth.getCloid(), qCloth.getCloname(), qCloth.getClotype(), qCloth.getClopic1(), qCloth.getCloprice());
			
				int ordernum=list.get(i).getOrdernum();
				int orderprice=list.get(i).getOrderprice();
				String orderlx=list.get(i).getOrderlx();
				QOrderdetail qOrderdetail=new QOrderdetail(orderid, qOrder, qCloth1, ordernum, orderprice, null, orderlx);
				listGouWuChe.add(qOrderdetail);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			try{
			Gson gson=new Gson();
			str=gson.toJson(listGouWuChe);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		out.write(str);
		out.flush();
		out.close();
		return ;
	}
	/**
	 * 删除购物车中对应的记录(即删除定单详情表中某条记录)
	 */
	public void dodelOrder(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;//得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(gwCartBiz.delectQOrderdetail(orderid)){
			out.write(1+"");
		}else{
			out.write(0+"");
		}
		out.flush();
		out.close();
		return ;
	}
	
	/**
	 * 更新购物车中商品的数量
	 */
	public void updatetrolley(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;//得到写流
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		if(gwCartBiz.updatetrlley(orderid, ordernum)){
			out.write(1+"");
		}else{
			out.write(0+"");
		}
		out.flush();
		out.close();
		return ;
	}
}
