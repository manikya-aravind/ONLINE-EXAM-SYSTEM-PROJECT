package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class Admin {
	
	@Id
	@SequenceGenerator(name="seq_admin",initialValue=30001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_admin")
	@Column(name="admin_id")
	long adminId;
	
	@Column(name="admin_username")
	String adminName;
	
	@Column(name="admin_password")
	String adminPassword;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}
