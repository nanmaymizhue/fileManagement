package com.intern.test.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER")
@SequenceGenerator(name="seq",initialValue=1,allocationSize=100)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	private Long id;
	@Column
	private String userName;
	
	@Column
	private String userEmail;
	
	@Column
	private String address;
	
	@Column
	private Date createdAt;
	
	@Column
	private String nrcPath;
	
	@Column
	private String profilePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getNrcPath() {
		return nrcPath;
	}

	public void setNrcPath(String nrcPath) {
		this.nrcPath = nrcPath;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	
	
}
	
	