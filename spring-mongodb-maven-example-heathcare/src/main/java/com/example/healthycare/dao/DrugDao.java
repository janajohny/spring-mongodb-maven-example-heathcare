package com.example.healthycare.dao;

import org.bson.types.ObjectId;

import com.example.healthycare.entity.Drug;

public interface DrugDao extends BaseDao<Drug>{

	Drug findById(ObjectId id);
	
	void update(Drug drug);
	
	void delete(String id);
}
