package com.etc.entity;

/**
 * QUser entity. @author MyEclipse Persistence Tools
 */

public class QUser {

	// Fields

	private Integer quserid;//�û�id
	private String qname;//�û�����
	private String qpassword;//�û�����
	private String qaddress;//�û���ַ
	private Integer qmoney;//�û����
	private String qtel;//�û��绰

	// Constructors

	/** default constructor */
	public QUser() {
	}

	/** minimal constructor */
	public QUser(Integer quserid, String qname, String qpassword) {
		this.quserid = quserid;
		this.qname = qname;
		this.qpassword = qpassword;
	}

	/** full constructor */
	public QUser(Integer quserid, String qname, String qpassword,
			String qaddress, Integer qmoney, String qtel) {
		this.quserid = quserid;
		this.qname = qname;
		this.qpassword = qpassword;
		this.qaddress = qaddress;
		this.qmoney = qmoney;
		this.qtel = qtel;
	}

	// Property accessors

	public Integer getQuserid() {
		return this.quserid;
	}

	public void setQuserid(Integer quserid) {
		this.quserid = quserid;
	}

	public String getQname() {
		return this.qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public String getQpassword() {
		return this.qpassword;
	}

	public void setQpassword(String qpassword) {
		this.qpassword = qpassword;
	}

	public String getQaddress() {
		return this.qaddress;
	}

	public void setQaddress(String qaddress) {
		this.qaddress = qaddress;
	}

	public Integer getQmoney() {
		return this.qmoney;
	}

	public void setQmoney(Integer qmoney) {
		this.qmoney = qmoney;
	}

	public String getQtel() {
		return this.qtel;
	}

	public void setQtel(String qtel) {
		this.qtel = qtel;
	}

	@Override
	public String toString() {
		return "QUser [quserid=" + quserid + ", qname=" + qname
				+ ", qpassword=" + qpassword + ", qaddress=" + qaddress
				+ ", qmoney=" + qmoney + ", qtel=" + qtel + "]";
	}
    
}