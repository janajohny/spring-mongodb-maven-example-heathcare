package com.example.healthycare.dao;

import com.example.healthycare.entity.Drug;

public interface DrugDao extends BaseDao<Drug>{

	Drug findById(String id);
	
	void update(Drug drug);
	
	void delete(String id);
}
