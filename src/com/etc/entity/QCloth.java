package com.etc.entity;

import java.sql.Timestamp;

/**
 * QCloth entity. @author MyEclipse Persistence Tools
 */

public class QCloth {

	private Integer cloid;
	private String cloname;
	private String clotype;
	private Integer cloprice;
	private Integer clonums;
	private Integer clonumm;
	private Integer clonuml;
	private String clodetail;
	private Integer closale;
	private String clopic1;
	private String clopic2;
	private String clopic3;
	private Integer clomove;
	private Timestamp clodate;

	// Constructors

	/** default constructor */
	public QCloth() {
	}

	/** minimal constructor */
	public QCloth(Integer cloid, String cloname, String clotype,String clopic1,
			Integer cloprice) {
		this.cloid = cloid;
		this.cloname = cloname;
		this.clotype = clotype;
		this.clopic1=clopic1;
		this.cloprice = cloprice;
	}

	/** full constructor */
	public QCloth(Integer cloid, String cloname, String clotype,
			Integer cloprice, Integer clonums, Integer clonumm,
			Integer clonuml, String clodetail, Integer closale, String clopic1,
			String clopic2, String clopic3, Integer clomove, Timestamp clodate) {
		this.cloid = cloid;
		this.cloname = cloname;
		this.clotype = clotype;
		this.cloprice = cloprice;
		this.clonums = clonums;
		this.clonumm = clonumm;
		this.clonuml = clonuml;
		this.clodetail = clodetail;
		this.closale = closale;
		this.clopic1 = clopic1;
		this.clopic2 = clopic2;
		this.clopic3 = clopic3;
		this.clomove = clomove;
		this.clodate = clodate;
	}

	// Property accessors

	public Integer getCloid() {
		return this.cloid;
	}

	public void setCloid(Integer cloid) {
		this.cloid = cloid;
	}

	public String getCloname() {
		return this.cloname;
	}

	public void setCloname(String cloname) {
		this.cloname = cloname;
	}

	public String getClotype() {
		return this.clotype;
	}

	public void setClotype(String clotype) {
		this.clotype = clotype;
	}

	public Integer getCloprice() {
		return this.cloprice;
	}

	public void setCloprice(Integer cloprice) {
		this.cloprice = cloprice;
	}

	public Integer getClonums() {
		return this.clonums;
	}

	public void setClonums(Integer clonums) {
		this.clonums = clonums;
	}

	public Integer getClonumm() {
		return this.clonumm;
	}

	public void setClonumm(Integer clonumm) {
		this.clonumm = clonumm;
	}

	public Integer getClonuml() {
		return this.clonuml;
	}

	public void setClonuml(Integer clonuml) {
		this.clonuml = clonuml;
	}

	public String getClodetail() {
		return this.clodetail;
	}

	public void setClodetail(String clodetail) {
		this.clodetail = clodetail;
	}

	public Integer getClosale() {
		return this.closale;
	}

	public void setClosale(Integer closale) {
		this.closale = closale;
	}

	public String getClopic1() {
		return this.clopic1;
	}

	public void setClopic1(String clopic1) {
		this.clopic1 = clopic1;
	}

	public String getClopic2() {
		return this.clopic2;
	}

	public void setClopic2(String clopic2) {
		this.clopic2 = clopic2;
	}

	public String getClopic3() {
		return this.clopic3;
	}

	public void setClopic3(String clopic3) {
		this.clopic3 = clopic3;
	}

	public Integer getClomove() {
		return this.clomove;
	}

	public void setClomove(Integer clomove) {
		this.clomove = clomove;
	}

	public Timestamp getClodate() {
		return this.clodate;
	}

	public void setClodate(Timestamp clodate) {
		this.clodate = clodate;
	}

	@Override
	public String toString() {
		return "QCloth [cloid=" + cloid + ", cloname=" + cloname + ", clotype="
				+ clotype + ", cloprice=" + cloprice + ", clonums=" + clonums
				+ ", clonumm=" + clonumm + ", clonuml=" + clonuml
				+ ", clodetail=" + clodetail + ", closale=" + closale
				+ ", clopic1=" + clopic1 + ", clopic2=" + clopic2
				+ ", clopic3=" + clopic3 + ", clomove=" + clomove
				+ ", clodate=" + clodate + "]";
	}
	

}