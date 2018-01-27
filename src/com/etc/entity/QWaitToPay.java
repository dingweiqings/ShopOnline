package com.etc.entity;

public class QWaitToPay {
	private Integer id;
	private QOrderdetail qorderDetail;
	private QUser quser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public QOrderdetail getQorderDetail() {
		return qorderDetail;
	}
	public void setQorderDetail(QOrderdetail qorderDetail) {
		this.qorderDetail = qorderDetail;
	}
	public QUser getQuser() {
		return quser;
	}
	public void setQuser(QUser quser) {
		this.quser = quser;
	}



}
