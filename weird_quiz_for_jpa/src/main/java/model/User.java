package dev.service.cloud.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String userId;
    private String password;
    private String userName;
    private long gameAttemptCount;
    private long gameSuccessCount;
    private long quizSolvedCount;
    private long quizCorrectCount;
}
