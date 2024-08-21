package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuizOption {

	private int id;
	
	private String content;
	
	private boolean isAnswer;
	
	private String weirdAnswerMessage;

	@Override
	public String toString() {
		return "QuizOption [id=" + id + ", content=" + content + ", isAnswer=" + isAnswer + ", weirdAnswerMessage="
				+ weirdAnswerMessage + "]";
	}
}
