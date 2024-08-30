package dev.service.cloud.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class QuizOptionPK implements Serializable{
	private Integer id;
	private Integer quiz;
}
