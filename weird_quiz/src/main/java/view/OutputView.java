package view;

import java.util.List;

import constants.ExceptionMessage;
import constants.GameMenuOption;
import constants.LoginMenuOption;
import model.Quiz;
import model.QuizOption;
import constants.GameMenuOption;
import constants.Message;
import model.User;

public class OutputView {

	public void writeLoginMenu() {
		for (LoginMenuOption option : LoginMenuOption.values()) {
			System.out.println(option.getId() + ". " + option.getContent());
		}
	}

	public void writeGameMenu() {
		StringBuilder sb = new StringBuilder();

		for (GameMenuOption option : GameMenuOption.values()) {
			sb.append(option.getId()).append(". ").append(option.getContent()).append("\n");
		}

		sb.delete(sb.length() - 1, sb.length());

		System.out.println(sb);
	}

	public void writeGameGuide() {
		System.out.println(Message.GAME_GUIDE);
	}

	public void writeQuiz(int num, Quiz quiz) {

		StringBuilder write = new StringBuilder();

		// 문제
		write.append("[").append(num).append("] ").append(quiz.getContent()).append("\n");
		
		List<QuizOption> options = quiz.getOptions();
		for (int i = 0; i < options.size(); i++) {
			write.append(i + 1).append(". ").append(options.get(i).getContent()).append("\n");
		}
		
		write.append(Message.GAME_GIVE_UP);
		
		System.out.println(write);
	}

	public void writeGameStats(User user) {
		// TODO Auto-generated method stub

	}

	public void writeCorrectAnswerMessage(int num, Quiz quiz) {

		if(quiz.isWeird()) { // 이상한 문제인 경우
			if(num == 10) { // 마지막 문제일 경우
				System.out.println(Message.WEIRD_FINDING + "\n\n");
			}
			else {
				System.out.println(Message.WEIRD_FINDING + " " + Message.NEXT_STAGE + "\n");
			}
		} else { // 정상적인 문제인 경우
			if(num == 10) { // 마지막 문제일 경우
				System.out.println(Message.CORRECT_ANSWER + "\n\n");
			}
			else {
				System.out.println(Message.CORRECT_ANSWER + " " + Message.NEXT_STAGE + "\n");
			}
		}
	}

	public void writeWrongAnswerMessage(Quiz quiz, int answer, int num) {

		if (quiz.isWeird()) { // 이상한 문제인 경우

			StringBuilder write = new StringBuilder();
			write.append(quiz.getOptions().get(answer - 1).getWeirdAnswerMessage()).append("\n");

			// TODO 단계 별로 다른 약올리는 메세지 추가
			write.append(Message.WEIRD_WRONG_ANSWER).append("\n");
			System.out.println(write);

		} else { // 정상적인 문제인 경우
			System.out.println(Message.WRONG_ANSWER);
		}

	}

	public void writeSuccessGameMessage() {
		System.out.println(Message.ALL_CORRECT);
	}
	
	public void writeInvalidInputMessage() {
		System.out.println(ExceptionMessage.INVALID_INPUT.getMessage());
	}

	public void writeLogoutMessage() {
		System.out.println(Message.LOGOUT_MESSAGE);
	}

	public void writeExceptionMessage(String exceptionMessage) {
		System.out.println(exceptionMessage);
	}

}
