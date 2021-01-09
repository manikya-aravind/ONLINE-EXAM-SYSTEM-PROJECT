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
@Table(name="tbl_subject")
public class Subject {
	
	@Id
	@SequenceGenerator(name="seq_subject",initialValue=20001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_subject")
	@Column(name="subject_id")
	long subjectId;
	
	@Column(name="subject_name")
	String subjectName;
	
	@Column(name="min_pass_marks")
	int minPassMarks;
	
	@OneToMany(mappedBy="userReportSubject",cascade=CascadeType.ALL)
	List<UserReport> reportsSubject;
	
	@OneToMany(mappedBy="questionSubject",cascade=CascadeType.ALL)
	List<Question> questionsSubject;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getMinPassMarks() {
		return minPassMarks;
	}

	public void setMinPassMarks(int minPassMarks) {
		this.minPassMarks = minPassMarks;
	}

	public List<UserReport> getReportsSubject() {
		return reportsSubject;
	}

	public void setReportsSubject(List<UserReport> reportsSubject) {
		this.reportsSubject = reportsSubject;
	}

	public List<Question> getQuestionsSubject() {
		return questionsSubject;
	}

	public void setQuestionsSubject(List<Question> questionsSubject) {
		this.questionsSubject = questionsSubject;
	}
	
	
}
