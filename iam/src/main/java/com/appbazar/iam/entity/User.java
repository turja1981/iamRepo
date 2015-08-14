package com.appbazar.iam.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author 138932
 * 
 */
@Entity
@Table(name = "T_USER")
public class User {
	@Id
	@Column(name = "USER_ID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "NAME")
	protected String name;
	@Column(name = "MOBILENO")
	protected String mobileNo;
	@Column(name = "EMAIL")
	protected String email;
	@Column(name = "GENDER")
	protected String gender;
	@Column(name = "AGE")
	protected int age;
	@Column(name = "PROFESSION")
	protected String profession;
	@Column(name = "PROFILE")
	protected String profile;
	@Column(name = "EXPERIENCE")
	protected int experience;
	@Column(name = "STATUS")
	protected String status;
	@OneToMany(fetch=FetchType.LAZY , cascade={CascadeType.ALL})
	@JoinColumn(name="USER_ID")
	@JsonManagedReference
	protected List<Address> address;

	
	public List<Address> getAddress() {
		
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
