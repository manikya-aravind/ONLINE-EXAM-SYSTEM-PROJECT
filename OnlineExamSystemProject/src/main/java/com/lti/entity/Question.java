package com.lti.entity;

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
@Table(name="tbl_question")
public class Question {
	
	@Id
	@SequenceGenerator(name="seq_question",initialValue=50001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_question")
	@Column(name="question_id")
	long questionId;
	
	@Column(name="question_name")
	String questionName;
	
	@Column(name="option_1")
	String option1;
	
	@Column(name="option_2")
	String option2;
	
	@Column(name="option_3")
	String option3;
	
	@Column(name="option_4")
	String option4;
	
	@Column(name="question_level_number")
	String questionLevelNo;
	
	@Column(name="correct_answer")
	String correctNo;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	Subject questionSubject;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getQuestionLevelNo() {
		return questionLevelNo;
	}

	public void setQuestionLevelNo(String questionLevelNo) {
		this.questionLevelNo = questionLevelNo;
	}

	public String getCorrectNo() {
		return correctNo;
	}

	public void setCorrectNo(String correctNo) {
		this.correctNo = correctNo;
	}

	public Subject getQuestionSubject() {
		return questionSubject;
	}

	public void setQuestionSubject(Subject questionSubject) {
		this.questionSubject = questionSubject;
	}
	
	

}
