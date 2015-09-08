package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.AnswerDao;
import com.example.healthycare.entity.Answer;
import com.example.healthycare.service.AnswerService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value="answerService")
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerDao answerRepository;
	
	public Answer findById(String id){
		return answerRepository.findById(id);
	}

	@Override
	public void insert(Answer answer) {
		answerRepository.insert(answer);
		
	}

	@Override
	public Answer findByPatientIdAndQuestionId(String patientId, String questionId) {
		return answerRepository.findByPatientIdAndQuestionId(patientId, questionId);
	}
	
	@Override
	public void update(Answer answer){
		answerRepository.update(answer);
	}

	@Override
	public List<Answer> findByPatientId(String patientId) {
		return answerRepository.findByPatientId(patientId);
	}

}
