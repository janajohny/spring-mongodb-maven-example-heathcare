package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.entity.Answer;

/**
 * 
 * @author vominhtung
 *
 */
public interface AnswerService {
	
	Answer findById(String id);
	
	void insert(Answer answer);
	
	void update(Answer answer);
	
	Answer findByPatientIdAndQuestionId(String patientId, String questionId);
	
	List<Answer> findByPatientId(String patientId);
	
}
