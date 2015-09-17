package com.example.healthycare.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.healthycare.entity.Drug;
import com.example.healthycare.entity.Patient;

@Repository
public class DrugDaoImpl extends BaseDaoImpl<Drug> implements DrugDao{

	@Override
	public Drug findById(ObjectId id) {
		Query searchdrugQuery = new Query(Criteria.where("id").is(id));
		return this.getMongoTemplate().findOne(searchdrugQuery, Drug.class);
	}

	public void update(Drug drug) {
		MongoTemplate mongoTemplate = this.getMongoTemplate();
		Query query = new Query(Criteria.where("id").is(drug.getId()));
		Update update = new Update();
		update.set("drugId", drug.getDrugId());
		update.set("drugName", drug.getDrugName());
		update.set("manufacturer", drug.getManufacturer());
		update.set("description", drug.getDescription());
		mongoTemplate.updateFirst(query, update, Drug.class);
	}

	public void delete(String id) {
		MongoTemplate mongoTemplate = this.getMongoTemplate();
		Query query = new Query(Criteria.where("id").is(new ObjectId(id)));
		mongoTemplate.remove(query, Drug.class);
	}

}
