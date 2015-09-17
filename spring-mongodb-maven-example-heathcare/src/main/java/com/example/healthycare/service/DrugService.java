package com.example.healthycare.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.example.healthycare.entity.Drug;
/**
 * 
 * @author vominhtung
 *
 */
public interface DrugService {
	
	List<Drug> findAll();
	
	void insert(Drug drug);
	
	Drug findById(ObjectId id);
	
	void update(Drug drug);
	
	void delete(String id);
}
