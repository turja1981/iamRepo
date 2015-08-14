package com.appbazar.iam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MESSAGE")
public class Message {
	@Id
	@Column(name = "MSG_ID" , nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int msgId ;
	@Column(name = "SRC_USER_ID")
	private int srcUserId ;
	@Column(name = "DEST_USER_ID")
	private int destUserId ;
	@Column(name = "STATUS")
	private String msgStatus ;
	@Column(name = "MSG_TYPE")
	private String msgType ;
	@Column(name = "START_TIME")
	private String startTime ;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getSrcUserId() {
		return srcUserId;
	}
	public void setSrcUserId(int srcUserId) {
		this.srcUserId = srcUserId;
	}
	public int getDestUserId() {
		return destUserId;
	}
	public void setDestUserId(int destUserId) {
		this.destUserId = destUserId;
	}
	public String getMsgStatus() {
		return msgStatus;
	}
	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
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
