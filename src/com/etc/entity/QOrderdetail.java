package com.etc.entity;

/**
 * QOrderdetail entity. @author MyEclipse Persistence Tools
 */

public class QOrderdetail {

	// Fields

	private Integer orderid;
	private QOrder QOrder;
	private QCloth QCloth;
	private Integer ordernum;
	private Integer orderprice;
	private Integer quserelprice;
	private String orderlx;


	public QOrderdetail() {
	}

	public QOrderdetail(Integer orderid, QCloth QCloth, Integer ordernum,
			Integer orderprice, String orderlx) {
		this.orderid = orderid;
		this.QCloth = QCloth;
		this.ordernum = ordernum;
		this.orderprice = orderprice;
		this.orderlx = orderlx;
	}

	/** full constructor */
	public QOrderdetail(Integer orderid, QOrder QOrder, QCloth QCloth,
			Integer ordernum, Integer orderprice, Integer quserelprice,
			String orderlx) {
		this.orderid = orderid;
		this.QOrder = QOrder;
		this.QCloth = QCloth;
		this.ordernum = ordernum;
		this.orderprice = orderprice;
		this.quserelprice = quserelprice;
		this.orderlx = orderlx;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public QOrder getQOrder() {
		return this.QOrder;
	}

	public void setQOrder(QOrder QOrder) {
		this.QOrder = QOrder;
	}

	public QCloth getQCloth() {
		return this.QCloth;
	}

	public void setQCloth(QCloth QCloth) {
		this.QCloth = QCloth;
	}

	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getOrderprice() {
		return this.orderprice;
	}

	public void setOrderprice(Integer orderprice) {
		this.orderprice = orderprice;
	}

	public Integer getQuserelprice() {
		return this.quserelprice;
	}

	public void setQuserelprice(Integer quserelprice) {
		this.quserelprice = quserelprice;
	}

	public String getOrderlx() {
		return this.orderlx;
	}

	public void setOrderlx(String orderlx) {
		this.orderlx = orderlx;
	}

}