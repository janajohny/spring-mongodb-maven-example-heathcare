package com.example.healthycare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Prescription;

/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class PrescriptionDao {

	@Autowired
	private ApplicationContext appContext;
	
	public List<Prescription>findAll(){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findAll(Prescription.class);
	}
}
