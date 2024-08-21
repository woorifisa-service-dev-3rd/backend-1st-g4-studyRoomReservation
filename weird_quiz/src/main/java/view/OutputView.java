package view;

import java.util.List;

import constants.GameMenuOption;
import constants.LoginMenuOption;
import model.Quiz;
import model.QuizOption;
import constants.Message;
import model.User;

public class OutputView {

	public void writeLoginMenu() {
		for (LoginMenuOption option : LoginMenuOption.values()) {
			System.out.println(option.getId() + ". " + option.getContent());
		}
	}

	public void writeGameMenu() {
		// TODO Auto-generated method stub

	}

	public void writeGameGuide() {
		System.out.println(Message.GAME_GUIDE);
	}

	public void writeQuiz(int num, Quiz quiz) {

		StringBuilder write = new StringBuilder();
		
		// 문제
		write.append("[").append(num).append("-" + quiz.getId()).append("] ").append(quiz.getContent()).append("\n");
		
		List<QuizOption> options = quiz.getOptions();
		for(int i = 0; i < options.size(); i++) {
			write.append(i + 1).append(". ").append(options.get(i).getContent()).append("\n");
		}
		
		write.append("(포기하시려면 0번을 입력하세요 ...)");
		
		System.out.println(write);
	}

	public void writeGameStats(User user) {
		// TODO Auto-generated method stub

	}

	public void writeCorrectAnswerMessage(int num, Quiz quiz) {

		if(quiz.isWeird()) { // 이상한 문제인 경우
			if(num == 10) { // 마지막 문제일 경우
				System.out.println("이상한 점을 발견하셨군요.\n\n");
			}
			else {
				System.out.println("이상한 점을 발견하셨군요. 다음 단계로 이동합니다.. 😮‍💨\n");
			}
		} else { // 정상적인 문제인 경우
			if(num == 10) { // 마지막 문제일 경우
				System.out.println("정답입니다.\n\n");
			}
			else {
				System.out.println("정답입니다. 다음 단계로 이동합니다.. 😮‍💨\n");
			}
		}
	}

	public void writeWrongAnswerMessage(Quiz quiz, int answer, int num) {
		
		if(quiz.isWeird()) { // 이상한 문제인 경우
			
			StringBuilder write = new StringBuilder();
			write.append(quiz.getOptions().get(answer - 1).getWeirdAnswerMessage()).append("\n");

			// TODO 단계 별로 다른 약올리는 메세지 추가
			
			System.out.println(write);
			
		} else { // 정상적인 문제인 경우
			System.out.println("틀렸습니다! 처음으로 되돌아갑니다 🎉🎉");
		}

	}

	public void writeSuccessGameMessage() {
		System.out.println("모든 문제를 맞추셨습니다.\n메인으로 돌아갑니다 .. 😔");
	}

	public void writeLogoutMessage() {
		// TODO Auto-generated method stub
	}

}
