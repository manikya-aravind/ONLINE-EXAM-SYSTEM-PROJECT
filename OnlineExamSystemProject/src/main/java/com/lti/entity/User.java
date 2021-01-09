package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@SequenceGenerator(name="seq_user",initialValue=10001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user")
	@Column(name="user_id")
	long userId;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="user_email")
	String userEmail;
	
	@Column(name="user_mobile_number")
	String userMobile;
	
	@Column(name="user_city")
	String userCity;
	
	@Column(name="user_state")
	String userState;
	
	@Column(name="user_password")
	String userPassword;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	List<UserReport> reportsUser;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<UserReport> getReportsUser() {
		return reportsUser;
	}

	public void setReportsUser(List<UserReport> reportsUser) {
		this.reportsUser = reportsUser;
	}
	
	
}
