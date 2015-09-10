package com.example.healthycare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.healthycare.entity.Patient;
/**
 * 
 * @author vominhtung
 *
 * @param <T>
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T>  {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public  List<T> findAll(Class<T> entityClass){
		return mongoTemplate.findAll(entityClass);
	}
	
	@Override
	public void insert(T t){
		mongoTemplate.insert(t);
	}
	
	@Override
	public void remove(T t){
		mongoTemplate.remove(t);
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
}
