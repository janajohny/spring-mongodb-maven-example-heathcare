package com.example.healthycare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Patient;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class PatientDao {
	
	@Autowired
	private ApplicationContext appContext;
	
	public List<Patient>findAll(){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findAll(Patient.class);
		
	}
	
	public Patient findByPatientId(String patientId){
		Query searchPatientQuery = new Query(Criteria.where("patientId").is(patientId));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findOne(searchPatientQuery,Patient.class);
	}
	
	public void insert(Patient patient){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		mongoOperation.insert(patient);
	}
	
	public void update(Patient patient){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("patientId").is(patient.getPatientId()));
		Update update = new Update();
		update.set("patientId", patient.getPatientId());
		update.set("firstName", patient.getFirstName());
		update.set("lastName", patient.getLastName());
		update.set("age", patient.getAge());
		update.set("medicalHistory", patient.getMedicalHistory());
		update.set("birthDate", patient.getBirthDate());
		mongoOperation.updateFirst(query, update, Patient.class);
	}
	
	public void delete(String patientId){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("patientId").is(patientId));
		mongoOperation.remove(query, Patient.class);
	}
	
}