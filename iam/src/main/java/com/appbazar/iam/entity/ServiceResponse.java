package com.appbazar.iam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_JOB_RESPONSE")
public class ServiceResponse {
	@Id
	@Column(name = "RES_ID" , nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int responseId ;
	@Column(name = "JOB_ID")
	private int jobId ;
	@Column(name = "RES_USER_ID")
	private int responseUserId ;
	@Column(name = "STATUS")
	private String responseStatus ;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;
	public int getResponseId() {
		return responseId;
	}
	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getResponseUserId() {
		return responseUserId;
	}
	public void setResponseUserId(int responseUserId) {
		this.responseUserId = responseUserId;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
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
