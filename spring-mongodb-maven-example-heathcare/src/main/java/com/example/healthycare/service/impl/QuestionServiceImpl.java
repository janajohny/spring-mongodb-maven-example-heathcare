package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.QuestionDao;
import com.example.healthycare.dao.QuestionDaoImpl;
import com.example.healthycare.entity.Question;
import com.example.healthycare.service.QuestionService;

@Service(value="questionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDao questionRepository;
	
	@Override
	public List<Question> findAll() {
		return questionRepository.findAll(Question.class);
	}

	@Override
	public Question findById(String id) {
		return questionRepository.findById(id);
	}

	@Override
	public void insert(Question question) {
		questionRepository.insert(question);
	}

	@Override
	public void update(Question question) {
		questionRepository.update(question);
	}

	@Override
	public void delete(String id) {
		questionRepository.delete(id);
	}
	
}
