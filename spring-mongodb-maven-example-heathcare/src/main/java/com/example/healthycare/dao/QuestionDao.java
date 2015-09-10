package com.example.healthycare.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class QuestionDao{
	
	@Autowired
	private ApplicationContext appContext;
	
	public List<Question>findAll(){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findAll(Question.class);
		
	}
	
	public Question findById(String id){
		Query searchQuestionQuery = new Query(Criteria.where("id").is(new ObjectId(id)));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findOne(searchQuestionQuery, Question.class);
	}
}
