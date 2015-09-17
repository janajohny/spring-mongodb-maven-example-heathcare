package com.example.healthycare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Patient;
import com.example.healthycare.entity.Prescription;

/**
 * 
 * @author vominhtung
 *
 */
@Repository
public class PrescriptionDaoImpl  extends BaseDaoImpl<Prescription> implements PrescriptionDao {

	@Autowired
	private ApplicationContext appContext;
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.PrescriptionDao#delete(java.lang.String)
	 */
	public void delete(String id){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("id").is(id));
		mongoOperation.remove(query, Prescription.class);
	}
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.PrescriptionDao#findById(java.lang.String)
	 */
	public Prescription findById(String id){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("id").is(id));
		return mongoOperation.findOne(query, Prescription.class);
	}
	
	/* (non-Javadoc)
	 * @see com.example.healthycare.dao.PrescriptionDao#update(com.example.healthycare.entity.Prescription)
	 */
	public void update(Prescription prescription){
		MongoOperations mongoOperation = (MongoOperations)appContext.getBean("mongoTemplate");
		Query query = new Query(Criteria.where("id").is(prescription.getId()));
		Update update = new Update();
		update.set("doctor", prescription.getDoctor());
		update.set("patient", prescription.getPatient());
		update.set("description", prescription.getDescription());
		update.set("drugs", prescription.getDrugs());
		mongoOperation.updateFirst(query, update, Prescription.class);
	}

	public void delete(Prescription t) {
		// TODO Auto-generated method stub
		
	}
}
