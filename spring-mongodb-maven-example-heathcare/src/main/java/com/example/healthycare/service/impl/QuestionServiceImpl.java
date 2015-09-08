package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.QuestionDao;
import com.example.healthycare.entity.Question;
import com.example.healthycare.service.QuestionService;

@Service(value="QuestionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao questionRepository;
	
	@Override
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public Question findById(String id) {
		return questionRepository.findById(id);
	}

}
