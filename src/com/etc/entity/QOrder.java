package com.etc.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * QOrder entity. @author MyEclipse Persistence Tools
 */

public class QOrder  {

	// Fields

	private Integer qdorder;
	private Integer quserid;
	private Date orderdate;
	private String orderstate;
	private Integer qdprice;
	private Set<QOrderdetail> QOrderdetails = new HashSet<QOrderdetail>(0);

	// Constructors

	/** default constructor */
	public QOrder() {
	}
	public QOrder(Integer qdorder, Integer quserid){
		this.qdorder = qdorder;
		this.quserid = quserid;
	}
	
	public QOrder(Integer qdorder, Integer quserid, Date orderdate,
			String orderstate, Integer qdprice, Set<QOrderdetail> qOrderdetails) {
		super();
		this.qdorder = qdorder;
		this.quserid = quserid;
		this.orderdate = orderdate;
		this.orderstate = orderstate;
		this.qdprice = qdprice;
		QOrderdetails = qOrderdetails;
	}


	// Property accessors

	public Integer getQdorder() {
		return this.qdorder;
	}

	public void setQdorder(Integer qdorder) {
		this.qdorder = qdorder;
	}

	public Integer getQuserid() {
		return this.quserid;
	}

	public void setQuserid(Integer quserid) {
		this.quserid = quserid;
	}

	public Date getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public Integer getQdprice() {
		return this.qdprice;
	}

	public void setQdprice(Integer qdprice) {
		this.qdprice = qdprice;
	}


	public Set<QOrderdetail> getQOrderdetails() {
		return QOrderdetails;
	}


	public void setQOrderdetails(Set<QOrderdetail> qOrderdetails) {
		QOrderdetails = qOrderdetails;
	}

	
}