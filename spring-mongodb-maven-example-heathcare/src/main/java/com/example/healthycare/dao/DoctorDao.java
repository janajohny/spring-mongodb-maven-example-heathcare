package com.example.healthycare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import com.example.healthycare.entity.Doctor;

/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class DoctorDao {

	@Autowired
	private ApplicationContext appContext;
	
	public List<Doctor> findAll(){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		List<Doctor> doctors = (List<Doctor>)mongoOperation.findAll(Doctor.class);
		return doctors;
	}
	
	public void insert(Doctor doctor){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		mongoOperation.insert(doctor);
	}
}
