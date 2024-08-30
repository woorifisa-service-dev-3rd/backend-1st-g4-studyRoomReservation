package dev.service.cloud.repository;

import java.util.List;

import org.junit.jupiter.api.Test;

import dev.service.cloud.model.Quiz;

class QuizRepositoryTest {
	QuizRepository repository = new QuizRepository();


	@Test
	void testFindById() {
		Quiz quiz = repository.findById(1);
		System.out.println(quiz);
	}
	
	@Test
	void testFind() {
		List<Quiz> quizzes = repository.findTop10OrderByRandom();
		System.out.println(quizzes);
	}

}
