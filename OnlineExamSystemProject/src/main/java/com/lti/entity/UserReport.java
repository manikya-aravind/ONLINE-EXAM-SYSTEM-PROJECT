package com.lti.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_user_report")
public class UserReport {
	
	@Id
	@SequenceGenerator(name="seq_user_report",initialValue=40001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_user_report")
	@Column(name="report_id")
	long reportId;
	
	@Column(name="level_number")
	String levelNumber;
	
	@Column(name="status")
	String status;
	
	@Column(name="marks_scored")
	int marksScored;
	
	@Column(name="completion_date")
	LocalDate completionDate;
	
	@Column(name="completion_time")
	LocalTime completionTime;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	Subject userReportSubject;

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	public String getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(String levelNumber) {
		this.levelNumber = levelNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getUserReportSubject() {
		return userReportSubject;
	}

	public void setUserReportSubject(Subject userReportSubject) {
		this.userReportSubject = userReportSubject;
	}

	public LocalTime getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(LocalTime completionTime) {
		this.completionTime = completionTime;
	}
	
	
}
