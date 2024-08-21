package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int gameAttemptCount;
    private int gameSuccessCount;
    private int quizSolvedCount;
    private int quizCorrectCount;
}
