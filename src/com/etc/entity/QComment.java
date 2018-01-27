package com.etc.entity;

import java.util.Date;

/**
 * QComment entity. @author MyEclipse Persistence Tools
 */

public class QComment {

	// Fields

	private Integer comid;
	private Integer quserid;
	private Integer cloid;
	private String comdetail;
	private String comgrade;
	private Date comdate;

	// Constructors

	/** default constructor */
	public QComment() {
	}

	/** minimal constructor */
	public QComment(Integer comid, Integer quserid, Integer cloid,
			String comdetail) {
		this.comid = comid;
		this.quserid = quserid;
		this.cloid = cloid;
		this.comdetail = comdetail;
	}

	/** full constructor */
	public QComment(Integer comid, Integer quserid, Integer cloid,
			String comdetail, String comgrade, Date comdate) {
		this.comid = comid;
		this.quserid = quserid;
		this.cloid = cloid;
		this.comdetail = comdetail;
		this.comgrade = comgrade;
		this.comdate = comdate;
	}

	// Property accessors

	public Integer getComid() {
		return this.comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	public Integer getQuserid() {
		return this.quserid;
	}

	public void setQuserid(Integer quserid) {
		this.quserid = quserid;
	}

	public Integer getCloid() {
		return this.cloid;
	}

	public void setCloid(Integer cloid) {
		this.cloid = cloid;
	}

	public String getComdetail() {
		return this.comdetail;
	}

	public void setComdetail(String comdetail) {
		this.comdetail = comdetail;
	}

	public String getComgrade() {
		return this.comgrade;
	}

	public void setComgrade(String comgrade) {
		this.comgrade = comgrade;
	}

	public Date getComdate() {
		return this.comdate;
	}

	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}

}