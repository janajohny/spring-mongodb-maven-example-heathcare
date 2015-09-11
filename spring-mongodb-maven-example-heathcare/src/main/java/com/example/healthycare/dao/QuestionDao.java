package com.example.healthycare.dao;

import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public interface QuestionDao extends BaseDao<Question>{

	public abstract Question findById(String id);
	
	public void update(Question question);
	
	public void delete(String id);

}