package com.appbazar.iam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_JobQ")
public class Service {
	@Id
	@Column(name = "JOB_ID" , nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serviceId ;
	@Column(name = "JOB_DESC")
	private String jobDesc ;
	@Column(name = "PROFESSION")
	private String profession ;
	@Column(name = "REQ_USER_ID")
	private int reqUserId ;
	@Column(name = "REQUIRED_TIME")
	private Timestamp requiredTime ;
	@Column(name = "END_TIME")
	private Timestamp endTime ;
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	@Column(name = "STATUS")
	private String status ;
	@Column(name = "URGENCY")
	private String urgency ;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;

	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public int getReqUserId() {
		return reqUserId;
	}
	public void setReqUserId(int reqUserId) {
		this.reqUserId = reqUserId;
	}
	public Timestamp getRequiredTime() {
		return requiredTime;
	}
	public void setRequiredTime(Timestamp requiredTime) {
		this.requiredTime = requiredTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}

	
	
}
