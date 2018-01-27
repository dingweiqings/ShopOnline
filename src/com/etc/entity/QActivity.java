package com.etc.entity;

import java.util.Date;

/**
 * QActivity entity. @author MyEclipse Persistence Tools
 */

public class QActivity{

	// Fields

	private Integer activityid;
	private String activityname;
	private String clotype;
	private Date starttime;
	private Date endtime;
	private Double activitynum;
	private String activitpic;

	// Constructors

	/** default constructor */
	public QActivity() {
	}

	/** full constructor */
	public QActivity(Integer activityid, String activityname, String clotype,
			Date starttime, Date endtime, Double activitynum, String activitpic) {
		this.activityid = activityid;
		this.activityname = activityname;
		this.clotype = clotype;
		this.starttime = starttime;
		this.endtime = endtime;
		this.activitynum = activitynum;
		this.activitpic = activitpic;
	}

	// Property accessors

	public Integer getActivityid() {
		return this.activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public String getActivityname() {
		return this.activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public String getClotype() {
		return this.clotype;
	}

	public void setClotype(String clotype) {
		this.clotype = clotype;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Double getActivitynum() {
		return this.activitynum;
	}

	public void setActivitynum(Double activitynum) {
		this.activitynum = activitynum;
	}

	public String getActivitpic() {
		return this.activitpic;
	}

	public void setActivitpic(String activitpic) {
		this.activitpic = activitpic;
	}

}