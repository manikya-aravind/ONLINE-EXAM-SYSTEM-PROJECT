package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Admin;
import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.UserReport;

//class for Admin Repository Operations
@Repository
public class AdminRepositoryImpl implements AdminRepository {

	@PersistenceContext
	EntityManager em;

	// login an admin
	@Transactional
	public Admin loginAnAdmin(String adminName, String adminPassword) {
		String jpql = "select a from Admin a where a.adminName=:aname and a.adminPassword=:apass";
		try {
			TypedQuery<Admin> query = em.createQuery(jpql, Admin.class);
			query.setParameter("aname", adminName);
			query.setParameter("apass", adminPassword);

			Admin admin = (Admin) query.getSingleResult();
			return admin;
		} catch (Exception e) {
			return null;
		}

	}

	// adding a question
	@Transactional
	public long addAQuestion(Question question) {
		Question q = em.merge(question);
		return q.getQuestionId();
	}

	// removing a question
	@Transactional
	public Question removeAQuestion(long questionId) {
		Question question = em.find(Question.class, questionId);
		em.remove(question);
		return question;
	}

	// find subject by subjectId
	public Subject findSubjectById(long subjectId) {
		Subject subject = em.find(Subject.class, subjectId);
		return subject;
	}

	// find question by questionId
	public Question findQuestionById(long questionId) {
		Question question = em.find(Question.class, questionId);
		return question;
	}

	// search students based on specific criteria
	public List<UserReport> searchforStudent(String technology, String userState, String userCity, String level,
			int marks) {
		String jpql = "select u from UserReport u where u.user.userState=:uState and u.user.userCity=:uCity and u.levelNumber=:level and u.userReportSubject.subjectName=:tech and u.marksScored>= :marks";																																															
		try {
			TypedQuery<UserReport> query = em.createQuery(jpql, UserReport.class);
			query.setParameter("uState", userState);
			query.setParameter("uCity", userCity);
			query.setParameter("level", level);
			query.setParameter("marks", marks);
			query.setParameter("tech", technology);

			List<UserReport> userReports = query.getResultList();
			return userReports;
		} catch (Exception e) {
			return null;
		}
	}

}
