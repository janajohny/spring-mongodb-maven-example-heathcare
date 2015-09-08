package com.example.healthycare.dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Patient;
import com.mongodb.WriteResult;

/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class AnswerDao {

	@Autowired
	private ApplicationContext appContext;
	
	public Answer findById(String id){
		Query searchPatientQuery = new Query(Criteria.where("id").is(id));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findOne(searchPatientQuery, Answer.class);
	}
	
	public void insert(Answer answer){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		mongoOperation.insert(answer);
	}
	
	public Answer findByPatientIdAndQuestionId(String patientId, String questionId) {
		Query searchAnswerQuery = new Query(Criteria.where("patientId").is(patientId).and("question.id").is(new ObjectId(questionId)));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Answer answer = (Answer)mongoOperation.findOne(searchAnswerQuery, Answer.class);
		return answer;
	}
	
	public void update(Answer answer){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("id").is(answer.getId()));
		Update update = new Update();
		query.fields().include("answer");
		update.set("answer", answer.getAnswer());
		mongoOperation.updateFirst(query, update, Answer.class);
	}
	
	public List<Answer> findByPatientId(String patientId){
		Query searchAnswerQuery = new Query(Criteria.where("patientId").is(patientId));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		List<Answer> answers = (List<Answer>)mongoOperation.find(searchAnswerQuery, Answer.class);
		return answers;
	}
}
