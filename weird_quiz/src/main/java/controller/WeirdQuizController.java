package controller;

import java.sql.Connection;
import java.util.List;

import constants.GameMenuOption;
import constants.LoginMenuOption;
import model.Quiz;
import model.User;
import service.QuizService;
import service.UserService;
import util.DBUtil;
import view.InputView;
import view.OutputView;

public class WeirdQuizController {
	private static final UserService userService = new UserService();
	private static final QuizService quizService = new QuizService();
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();
	// DB 커넥션
	private static Connection connection = DBUtil.getConnection("src/main/resources/jdbc.properties");

	public void run() {
		while (true) {
			int loginMenuOption = selectLoginMenu();
			User user = null;

			if (loginMenuOption == LoginMenuOption.LOGIN.getId()) {
				// 로그인
				while (user != null) {
					user = login();
				}

				executeGame(user);

			}

			if (loginMenuOption == LoginMenuOption.SIGNUP.getId()) {
				// 회원가입
				while (user != null) {
					user = signup();
				}

				executeGame(user);
			}

			if (loginMenuOption == LoginMenuOption.EXIT.getId()) {
				// 종료
				break;
			}
		}
	}

	int selectLoginMenu() {
		// 로그인 메뉴 출력
		outputView.writeLoginMenu();

		// 사용자 입력 받기
		int loginMenuOption = inputView.readLoginMenuOption();

		return loginMenuOption;
	}

	User login() {
		String userId = inputView.readUserId();
		String password = inputView.readPassword();

		return userService.login(userId, password);
	}

	User signup() {
		// 회원가입
		String userId = inputView.readUserId();
		String password = inputView.readPassword();
		String userName = inputView.readUserName();

		return userService.signup(userId, password, userName);
	}

	int selectGameMenu() {
		// 게임 메뉴 출력
		outputView.writeGameMenu();

		// 사용자 입력 받기
		int gameMenuOption = inputView.readGameMenuOption();

		return gameMenuOption;
	}

	void guideGame() {
		outputView.writeGameGuide();
	}

	boolean playGame() {
		List<Quiz> quizzes = quizService.selectQuizzes();

		for (Quiz quiz : quizzes) {
			outputView.writeQuiz();
			int userAnswer = inputView.readUserAnswer();

			if (quizService.isCorrectAnswer(quiz, userAnswer)) {
				// 정답일 경우
				outputView.writeCorrectAnswerMessage();
			} else {
				// 오답일 경우
				outputView.writeWrongAnswerMessage();
				return true;
			}
		}

		outputView.writeSuccessGameMessage();
		return false;
	}

	void getGameStats(User user) {
		outputView.writeGameStats(user);
	}

	void logout(User user) {
		user = null;
		outputView.writeLogoutMessage();
	}

	void executeGame(User user) {
		// 게임 메뉴 선택
		int gameMenuOption = selectGameMenu();

		// 게임 방법
		if (gameMenuOption == GameMenuOption.GAME_GUIDE.getId()) {
			guideGame();
		}

		// 게임 시작
		if (gameMenuOption == GameMenuOption.GAME_PLAY.getId()) {
			while (playGame());
		}

		// 기록 조회
		if (gameMenuOption == GameMenuOption.GAME_STATS.getId()) {
			getGameStats(user);
		}

		// 로그아웃
		if (gameMenuOption == GameMenuOption.LOGOUT.getId()) {
			logout(user);
		}
	}

}
