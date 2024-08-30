package model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class QuizOption {

	private int id;
	
	private String content;
	
	private boolean isAnswer;
	
	private String weirdAnswerMessage;
}
