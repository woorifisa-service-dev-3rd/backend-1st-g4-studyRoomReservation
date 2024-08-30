package dev.service.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "quiz_options")
@IdClass(QuizOptionPK.class)
public class QuizOption {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id")
	@ToString.Exclude
	private Quiz quiz;
	
	@Id
	@Column(name = "quiz_option_id")
	private Integer id;
	
	@Column(name = "quiz_option_content")
	private String content;
	
	@Column(name = "is_answer")
	private boolean isAnswer;
	
	@Column(name = "weird_answer_message")
	private String weirdAnswerMessage;
}
