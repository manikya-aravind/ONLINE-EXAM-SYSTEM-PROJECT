package com.lti.service;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.User;
import com.lti.entity.UserReport;

//interface for User Service Layer Operations
public interface UserService {
	
	//register/update a user
	boolean registerOrUpdateAUser(User user);
	
	//login a user
	User loginAUser(String userName,String userPassword);
	
	//find user by userId
	User findUserById(long userId);
	
	//find user by userName
	User findUserByName(String userName);
	
	//store user exam report
	UserReport storeExamReport(UserReport report);
	
	//retrieve user latest exam report
	UserReport retrieveUserReportOfUserId(long userId);
	
	// retrieve correct answer for a question
	Question retrieveCorrectAnswer(long questionId);
	
	//retrieve question based on level number
	List<Question> retrieveQuestionBylevel(String level);
	
	//change password
	boolean changePassword(User user);

}
