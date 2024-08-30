package dev.service.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "user_id")
    private String userId;
    private String password;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "game_attempt_count")
    private long gameAttemptCount;
    @Column(name = "game_success_count")
    private long gameSuccessCount;
    @Column(name = "quiz_solved_count")
    private long quizSolvedCount;
    @Column(name = "quiz_correct_count")
    private long quizCorrectCount;
}
