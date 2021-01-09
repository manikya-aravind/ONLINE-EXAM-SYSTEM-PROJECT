package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.User;
import com.lti.entity.UserReport;
import com.lti.repository.UserRepository;

//class for User Service Layer Operations
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	// register/update a user
	public boolean registerOrUpdateAUser(User user) {
		long userId = userRepository.registerOrUpdateAUser(user);
		if (userId > 0) {
			return true;
		}
		return false;
	}

	// login a user
	public User loginAUser(String userName, String userPassword) {
		User user = userRepository.loginAUser(userName, userPassword);
		if (user != null) {
			return user;
		}
		return null;
	}

	// find user by userId
	public User findUserById(long userId) {
		User user = userRepository.findUserById(userId);
		return user;
	}

	// find user by userName
	public User findUserByName(String userName) {
		User user = userRepository.findUserByName(userName);
		return user;
	}

	// find subject by subjectId
	public Subject findSubjectById(long subjectId) {
		Subject subject = userRepository.findSubjectById(subjectId);
		return subject;
	}
	
	//store user exam report
	public UserReport storeExamReport(UserReport report) {
        return userRepository.storeExamReport(report);
    }
	
	//retrieve user latest exam report
	public UserReport retrieveUserReportOfUserId(long userId) {
		return userRepository.retrieveUserReportOfUserId(userId);
	}
	
	// retrieve correct answer for a question
	public Question retrieveCorrectAnswer(long questionId) {
		Question question = userRepository.retrieveCorrectAnswer(questionId);

		return question;
	}
	
	//retrieve question based on level number
	public List<Question> retrieveQuestionBylevel(String level){
		return userRepository.retrieveQuestionBylevel(level);
	}
	
	//change password
	public boolean changePassword(User user) {
		long userId = userRepository.registerOrUpdateAUser(user);
		if(userId>0) {
			return true;
		}
		return false;
	}

}
