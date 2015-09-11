package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.dao.BaseDao;
import com.example.healthycare.entity.Question;

public interface QuestionService{

	Question findById(String id);
	
	List<Question>findAll();
	
	void insert(Question question);
	
	void update(Question question);
	
	void delete(String id);
}
