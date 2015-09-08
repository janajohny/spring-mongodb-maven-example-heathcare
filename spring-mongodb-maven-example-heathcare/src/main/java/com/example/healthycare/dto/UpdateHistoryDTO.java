package com.example.healthycare.dto;

import java.io.Serializable;

import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
public class UpdateHistoryDTO implements Serializable{
	
	private static final long serialVersionUID = -6396698145780432621L;

	private Question question;
	
	private Answer answer;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}
