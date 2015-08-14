package com.appbazar.iam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "T_ADDRESS")
public class Address  {
	@Id
	@Column(name = "ADRS_ID" , nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addrId;
	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	@Column(name = "CITY")
	private String city ;
	@Column(name = "LOCALITY")
	private String locality ;
	@Column(name = "ZIP")
	private String zip ;
	@Column(name = "COUNTRY")
	private String country ;
	
	@ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
	private User userforeign ;

	@JsonIgnore
	public User getUserforeign() {
		return userforeign;
	}

	
	public void setUserforeign(User userforeign) {
		this.userforeign = userforeign;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "CREATED_ON")
	private Timestamp createdOn;
	@Column(name = "UPDATED_ON")
	private Timestamp updatedOn;
	
	
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
