package com.lti.repository;

import java.util.List;

import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.User;
import com.lti.entity.UserReport;

//interface for User Repository operations
public interface UserRepository {
	
	//register/update a user
	long registerOrUpdateAUser(User user);
	
	//login a user
	User loginAUser(String userName,String userPassword);
	
	//find user by userId
	User findUserById(long userId);
	
	//find user by userName
	User findUserByName(String userName);
	
	//find subject by subjectId
	Subject findSubjectById(long subjectId);
	
	//store user exam report
	UserReport storeExamReport(UserReport report);
	
	//retrieve user latest exam report
	UserReport retrieveUserReportOfUserId(long userId);
	
	// retrieving correct answer for the question
	Question retrieveCorrectAnswer(long questionId);
	
	// retrieving question based on level number
	List<Question> retrieveQuestionBylevel(String level);

}
