package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.GwCartBiz;
import com.etc.entity.QUser;
import com.google.gson.Gson;

/**
 * ���ɶ���
 * 
 * @author ��Ϊ��
 * 
 */
public class SCDDAction {
	@Autowired
	private GwCartBiz gwCartBiz;
	private HttpSession session;
	private String chk_value;// ��ǰ�˴����ļ��붨���Ķ�����ϸ���id����

	public String getChk_value() {
		return chk_value;
	}

	public void setChk_value(String chk_value) {

		this.chk_value = chk_value;
	}
	public  String getDingdanPrice(int userid){		
		
		return "SUCCESS";
	}
	

	/**
	 * 	 �жϸ���Ʒ�Ŀ���Ƿ��㹻 ,������Ʒ��ʵ�ʼ۸���ӽ���Ӧ����Ʒ��ϸ��
	 */
	public void getDingDan() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// �õ�д��
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String a[] = chk_value.split(",");
		int id[] = new int[a.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(a[i]);
		boolean flag = gwCartBiz.updateQuserelprice(id[i]);
		//�жϿ���Ƿ��㹻
		if(!flag) {
			String cloname = gwCartBiz.getQOrderdetailByid(id[i])
					.getQCloth().getCloname();
			out.write(cloname + ":��治��");
			out.flush();
			out.close();
			return;
		}
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		//�����Ʒ����ʵ�۸�,��д��realPrice��
		for(int i=0;i<id.length;i++) {
			gwCartBiz.updateQuserelprice(id[i]);
		}
		
		for(int i=0;i<id.length;i++) {
			gwCartBiz.updateQuserelprice(id[i]);
		}
		
		
		
		//int qdorder = gwCartBiz.insertOneOrdered(userid, id);
//		for (int i = 0; i < id.length; i++) {
//			if (!gwCartBiz.updateOrdertoOrdered(id[i], qdorder)) {
//				out.write("fail");
//				out.flush();
//				out.close();
//				return;
//			}
//		}
		
		out.write("ok");
		out.flush();
		out.close();
		return;
	}
   public void calculteAllMoney() {
		String a[] = chk_value.split(",");
		int id[] = new int[a.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(a[i]);
	   double allMoney=gwCartBiz.getAllMoney(id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// �õ�д��
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		out.write(allMoney+"");
		out.flush();
		out.close();
		
   }
   }
	
	
	/**
	 * �ύ�������ж��û��˻�����Ƿ��㹻֧��,���޸��û����˻����
	 */
	public void tijiao() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// �õ�д��
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/* ��������б�ѡ�е���Ʒ���ܼ�,�ж��û��˺�����Ƿ��㹻 */
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		int qdorderid = gwCartBiz.newOrdered(userid);
		boolean flag = gwCartBiz.userMoneyOk(userid, qdorderid);
		if (flag) {
			/* �޸��û��˻����Ȳ��� */
			if(gwCartBiz.updateQCloth()
					&&gwCartBiz.updateUsermoney(userid, qdorderid)){
				out.write("ok");
			}
		} else {
			out.write("MoneyIsNotEnough");
		}
		out.flush();
		out.close();
		return;
	}
	
	public void getUser(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;// �õ�д��
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		/* ��������б�ѡ�е���Ʒ���ܼ�,�ж��û��˺�����Ƿ��㹻 */
		HttpServletRequest request=ServletActionContext.getRequest();
		session=request.getSession();
		int userid = (Integer) session.getAttribute("userid");
		QUser qUser=gwCartBiz.getUser(userid);
		Gson gson=new Gson();
		String str=gson.toJson(qUser);
		out.write(str);
		out.flush();
		out.close();
		return;
	}
}
