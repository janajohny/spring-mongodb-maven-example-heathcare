package com.example.healthycare.dao;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public interface QuestionDao extends BaseDao<Question>{

	public Question findById(ObjectId id);
	
	public void update(Question question);
	
	public void delete(ObjectId id);

}