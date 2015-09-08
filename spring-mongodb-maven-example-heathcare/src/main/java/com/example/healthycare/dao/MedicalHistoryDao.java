package com.example.healthycare.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.MedicalHistory;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class MedicalHistoryDao {
	
	@Autowired
	private ApplicationContext appContext;
	
	public MedicalHistory findByPatientId(String patientId){
		Query searchPatientQuery = new Query(Criteria.where("patientId").is(patientId));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findOne(searchPatientQuery,MedicalHistory.class);
	}
	
	public void insert(MedicalHistory medicalHistory){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		mongoOperation.insert(medicalHistory);
	}
}
