package dev.service.cloud.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dev.service.cloud.model.User;

public class UserRepository {
	private final EntityManagerFactory factory;
	private final EntityManager manager;
	private final EntityTransaction transaction;

	public UserRepository() {
		this.factory = Persistence.createEntityManagerFactory("weird_quiz_for_servlet_jpa");
		this.manager = factory.createEntityManager();
		this.transaction = manager.getTransaction();
	}
	
	public User findById(String userId) {
		User user = manager.find(User.class, userId);
		return user;
	}

	public void updateGameStatsById(User user) {
		transaction.begin();
		User foundUser = manager.find(User.class, user.getUserId());
		System.out.println(foundUser);
		foundUser.setGameAttemptCount(user.getGameAttemptCount());
		foundUser.setGameSuccessCount(user.getGameSuccessCount());
		foundUser.setQuizSolvedCount(user.getQuizSolvedCount());
		foundUser.setQuizCorrectCount(user.getQuizCorrectCount());
		transaction.commit();
	}

	public User save(User newUser) {
		transaction.begin();
		manager.persist(newUser);
		transaction.commit();
		return newUser;
	}

}
