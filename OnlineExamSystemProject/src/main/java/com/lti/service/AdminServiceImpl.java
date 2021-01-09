package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Admin;
import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.User;
import com.lti.entity.UserReport;
import com.lti.repository.AdminRepository;

//class for Admin Service Operations
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	// login an admin
	public boolean loginAnAdmin(String adminName, String adminPassword) {
		Admin admin = adminRepository.loginAnAdmin(adminName, adminPassword);
		if (admin != null) {
			return true;
		}
		return false;
	}

	// adding a question
	public long addAQuestion(Question question) {
		long questionId = adminRepository.addAQuestion(question);
		return questionId;
	}

	// removing a question
	public Question removeAQuestion(long questionId) {
		Question question = adminRepository.removeAQuestion(questionId);
		return question;
	}

	// find question by questionId
	public Question findQuestionById(long questionId) {
		Question question = adminRepository.findQuestionById(questionId);
		return question;
	}

	// find subject by subjectId
	public Subject findSubjectById(long subjectId) {
		return adminRepository.findSubjectById(subjectId);
	}
	
	//search for students based on specific criteria
	public List<User> searchforStudent(String technology,String userState,String userCity,String level,int marks){
		List<UserReport> userReports =  adminRepository.searchforStudent(technology, userState, userCity, level, marks);
		List<User> users = new ArrayList<User>();
		for(UserReport ur:userReports) {
			User user = new User();
			user = ur.getUser();
			users.add(user);
		}
		return users;
	}

}
