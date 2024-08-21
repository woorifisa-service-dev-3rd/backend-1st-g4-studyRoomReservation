package model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Quiz {

	private long id;
	
	private String content;
	
	private boolean isWeird;
	
	private List<QuizOption> options = new ArrayList<>();
}
