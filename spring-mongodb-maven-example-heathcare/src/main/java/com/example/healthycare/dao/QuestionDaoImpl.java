package com.example.healthycare.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Drug;
import com.example.healthycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao {
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.QuestionDao#findById(java.lang.String)
	 */
	@Override
	public Question findById(ObjectId id){
		Query searchQuestionQuery = new Query(Criteria.where("id").is(id));
		MongoTemplate mongoTemplate = this.getMongoTemplate();
		return mongoTemplate.findOne(searchQuestionQuery, Question.class);
	}

	@Override
	public void update(Question question) {
		MongoTemplate mongoTemplate = this.getMongoTemplate();
		Query query = new Query(Criteria.where("id").is(question.getId()));
		Update update = new Update();
		update.set("question", question.getQuestion());
		mongoTemplate.updateFirst(query, update, Question.class);
	}

	@Override
	public void delete(ObjectId id) {
		MongoTemplate mongoTemplate = this.getMongoTemplate();
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, Question.class);
	}
}
