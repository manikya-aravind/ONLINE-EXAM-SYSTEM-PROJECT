package com.lti.service;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.User;
import com.lti.entity.UserReport;

//interface for Admin Service Operations
public interface AdminService {

	// adding a question
	long addAQuestion(Question question);

	// removing a question
	Question removeAQuestion(long questionId);

	// find quesiton by questionId
	Question findQuestionById(long questionId);
	
	//find subject by subjectId
	Subject findSubjectById(long subjectId);
	
	//login an admin
	boolean loginAnAdmin(String adminName, String adminPassword);
	
	//search for students based on specific criteria
	List<User> searchforStudent(String technology,String userState,String userCity,String level,int marks);

}
