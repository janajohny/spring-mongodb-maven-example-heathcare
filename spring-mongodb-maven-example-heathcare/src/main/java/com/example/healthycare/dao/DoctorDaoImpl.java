package com.example.healthycare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Doctor;
import com.example.healthycare.entity.MedicalHistory;
import com.example.healthycare.entity.Patient;

/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class DoctorDaoImpl extends BaseDaoImpl<Doctor> implements DoctorDao {

	@Autowired
	private ApplicationContext appContext;
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.DoctorDao#findById(java.lang.String)
	 */
	public Doctor findById(String id){
		Query searchPatientQuery = new Query(Criteria.where("id").is(id));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findOne(searchPatientQuery,Doctor.class);
	}
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.DoctorDao#update(com.example.healthycare.entity.Doctor)
	 */
	public void update(Doctor doctor){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("id").is(doctor.getId()));
		Update update = new Update();
		update.set("employeeId", doctor.getEmployeeId());
		update.set("firstName", doctor.getFirstName());
		update.set("lastName", doctor.getLastName());
		update.set("age", doctor.getAge());
		mongoOperation.updateFirst(query, update, Doctor.class);
	}
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.DoctorDao#delete(java.lang.String)
	 */
	public void delete(String id){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("id").is(id));
		mongoOperation.remove(query, Doctor.class);
	}
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.DoctorDao#findByEmployeeId(java.lang.String)
	 */
	public Doctor findByEmployeeId(String employeeId){
		Query searchPatientQuery = new Query(Criteria.where("employeeId").is(employeeId));
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		return mongoOperation.findOne(searchPatientQuery,Doctor.class);
	}

}
