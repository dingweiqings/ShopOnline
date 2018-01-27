package com.etc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.etc.biz.CartBiz;

public class CartAction {
	@Autowired
	private CartBiz cartBiz;
	private int clonum;
	private int closize;
	private int userid=0;
	private int cloid;

	public int getCloid() {
		return cloid;
	}

	public void setCloid(int cloid) {
		this.cloid = cloid;
	}

	public int getClonum() {
		return clonum;
	}

	public void setClonum(int clonum) {
		this.clonum = clonum;
	}

	public int getClosize() {
		return closize;
	}

	public void setClosize(int closize) {
		this.closize = closize;
	}

	public void addsth() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			HttpServletRequest request=ServletActionContext.getRequest();
		    HttpSession session=request.getSession();
		    userid=(Integer) session.getAttribute("userid");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (userid == 0 || "".equals(userid)) {
				out.write("noLogin");
			} else {
				String temp = cartBiz.addclo(userid, cloid, clonum, closize);
				out.write(temp);
				out.flush();
				out.close();
			}
		}
	}
}
