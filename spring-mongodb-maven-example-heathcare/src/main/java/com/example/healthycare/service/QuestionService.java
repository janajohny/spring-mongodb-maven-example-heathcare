package com.example.healthycare.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.healthycare.dao.BaseDao;
import com.example.healthycare.entity.Question;

public interface QuestionService{

	Question findById(ObjectId id);
	
	List<Question>findAll();
	
	void insert(Question question);
	
	void update(Question question);
	
	void delete(ObjectId id);
}
