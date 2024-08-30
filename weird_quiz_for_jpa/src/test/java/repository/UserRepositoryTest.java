package repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.User;

class UserRepositoryTest {
	UserRepository repository;

	@BeforeEach
	void init() {
		repository = new UserRepository();
	}

	@Test
	void testFindById() {
		String userId = "user1";
		String password = "1234";
		String userName = "김우리";
		
		User user = repository.findById(userId);
		
		Assertions.assertEquals(user.getUserId(), userId);
		Assertions.assertEquals(user.getPassword(), password);
		Assertions.assertEquals(user.getUserName(), userName);
	}

	@Test
	void testUpdateById() {
		String userId = "user1";
		String password = "1234";
		User user = repository.findById(userId);
		user.setGameAttemptCount(10);
		
		repository.updateGameStatsById(user);
		
		User foundUser = repository.findById(userId);
		
		Assertions.assertEquals(foundUser.getGameAttemptCount(), 10);
	}

	@Test
	void testSave() {
		repository.save(User.builder().userId("kang").password("1234").userName("강재연").build());
		
		User user = repository.findById("kang");
		
		Assertions.assertEquals(user.getUserId(), "kang");
		Assertions.assertEquals(user.getPassword(), "1234");
		Assertions.assertEquals(user.getUserName(), "강재연");
	}

}
