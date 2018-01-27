package com.etc.entity;

import java.util.Date;

/**
 * QTrolley entity. @author MyEclipse Persistence Tools
 */

public class QTrolley {

	// Fields

	private Integer trolleyid;
	private QUser QUser;
	private QCloth QCloth;
	private Integer trolleyprice;//商品实际价格
	private Integer trolleynum;//商品数量
	private Integer trolleysum;//商品总价
	private Date trolleydate;//付款时间

	public QTrolley() {
	}


	public QTrolley(Integer trolleyid, QUser QUser, QCloth QCloth,
			Integer trolleyprice, Integer trolleynum, Integer trolleysum,
			Date trolleydate) {
		this.trolleyid = trolleyid;
		this.QUser = QUser;
		this.QCloth = QCloth;
		this.trolleyprice = trolleyprice;
		this.trolleynum = trolleynum;
		this.trolleysum = trolleysum;
		this.trolleydate = trolleydate;
	}

	public Integer getTrolleyid() {
		return this.trolleyid;
	}

	public void setTrolleyid(Integer trolleyid) {
		this.trolleyid = trolleyid;
	}

	public QUser getQUser() {
		return this.QUser;
	}

	public void setQUser(QUser QUser) {
		this.QUser = QUser;
	}

	public QCloth getQCloth() {
		return this.QCloth;
	}

	public void setQCloth(QCloth QCloth) {
		this.QCloth = QCloth;
	}

	public Integer getTrolleyprice() {
		return this.trolleyprice;
	}

	public void setTrolleyprice(Integer trolleyprice) {
		this.trolleyprice = trolleyprice;
	}

	public Integer getTrolleynum() {
		return this.trolleynum;
	}

	public void setTrolleynum(Integer trolleynum) {
		this.trolleynum = trolleynum;
	}

	public Integer getTrolleysum() {
		return this.trolleysum;
	}

	public void setTrolleysum(Integer trolleysum) {
		this.trolleysum = trolleysum;
	}

	public Date getTrolleydate() {
		return this.trolleydate;
	}

	public void setTrolleydate(Date trolleydate) {
		this.trolleydate = trolleydate;
	}

}