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
 * �Թ��ﳵ���в���
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
	 * ʹ���첽ˢ��ȡ�����ﳵ�е�����
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
			int userid=(Integer) session.getAttribute("userid");//����û������ڣ�������ݿ���ȡ�����ﳵ����
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
	 * ɾ�����ﳵ�ж�Ӧ�ļ�¼(��ɾ�������������ĳ����¼)
	 */
	public void dodelOrder(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;//�õ�д��
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
	 * ���¹��ﳵ����Ʒ������
	 */
	public void updatetrolley(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=null;//�õ�д��
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
