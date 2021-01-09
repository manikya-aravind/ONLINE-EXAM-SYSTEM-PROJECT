package com.lti.repository;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.UserReport;

//Interface for Admin Repository Operations
public interface AdminRepository {
	
	//adding a question
	long addAQuestion(Question question);
	
	//removing a question
	Question removeAQuestion(long questionId);
	
	//find subject by subjectId
	Subject findSubjectById(long subjectId);
	
	//find question by questionId
	Question findQuestionById(long questionId);
	
	//login an admin
	Admin loginAnAdmin(String adminName, String adminPassword);
	
	//search students based on specific criteria
	List<UserReport> searchforStudent(String technology,String userState,String userCity,String level,int marks);
}
