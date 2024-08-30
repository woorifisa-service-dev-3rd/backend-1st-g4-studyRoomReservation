package dev.service.cloud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dev.service.cloud.model.Quiz;

public class QuizRepository {
	private final EntityManagerFactory factory;
	private final EntityManager manager;
	private final EntityTransaction transaction;

	public QuizRepository() {
		this.factory = Persistence.createEntityManagerFactory("weird_quiz_for_servlet_jpa");
		this.manager = factory.createEntityManager();
		this.transaction = manager.getTransaction();
	}

	public Quiz findById(int id) {
		Quiz quiz = manager.find(Quiz.class, id);
		return quiz;
	}

	public List<Quiz> findTop10OrderByRandom() {
		String sql = "SELECT * FROM quizzes ORDER BY RAND() LIMIT 10";
        Query query = manager.createNativeQuery(sql, Quiz.class);
		return query.getResultList();
	}

}
