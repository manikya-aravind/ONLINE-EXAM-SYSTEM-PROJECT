package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Question;
import com.lti.entity.Subject;
import com.lti.entity.User;
import com.lti.entity.UserReport;

//class for User Repository Operations
@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	EntityManager em;

	// register/update a user
	@Transactional
	public long registerOrUpdateAUser(User user) {
		User u = em.merge(user);
		return u.getUserId();
	}

	// login a user
	public User loginAUser(String userName, String userPassword) {
		String jpql = "select u from User u where u.userName=:uname and u.userPassword=:upass";
		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("uname", userName);
			query.setParameter("upass", userPassword);

			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	// find user by userId
	public User findUserById(long userId) {
		User user = em.find(User.class, userId);
		return user;
	}

	// find user by userName
	public User findUserByName(String userName) {
		String jpql = "select u from User u where u.userName=:uname";
		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("uname", userName);

			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	// find subject by subjectId
	public Subject findSubjectById(long subjectId) {
		Subject subject = em.find(Subject.class, subjectId);
		return subject;
	}

	// store user exam report
	@Transactional
	public UserReport storeExamReport(UserReport report) {
		UserReport userReport = em.merge(report);
		return userReport;
	}

	// retrieve latest user exam report
	public UserReport retrieveUserReportOfUserId(long userId) {
		String jpql = "select u from UserReport u where u.user.userId=:uId and u.completionTime=(select max(ur.completionTime) from UserReport ur) order by u.completionDate desc,u.completionTime desc";
		try {
			TypedQuery<UserReport> query = em.createQuery(jpql, UserReport.class);
			query.setParameter("uId", userId);

			UserReport ur = (UserReport) query.getSingleResult();
			return ur;
		} catch (Exception e) {
			return null;
		}
	}

	// retrieving correct answer for the question
	public Question retrieveCorrectAnswer(long questionId) {
		Question question = em.find(Question.class, questionId);
		return question;
	}

	// retrieving question based on level number
	public List<Question> retrieveQuestionBylevel(String level) {
		String jpql = "select q from Question q where q.questionLevelNo=:level";
		try {
			TypedQuery<Question> query = em.createQuery(jpql, Question.class);
			query.setParameter("level", level);

			List<Question> questions = query.getResultList();
			return questions;
		} catch (Exception e) {
			return null;
		}
	}

}
