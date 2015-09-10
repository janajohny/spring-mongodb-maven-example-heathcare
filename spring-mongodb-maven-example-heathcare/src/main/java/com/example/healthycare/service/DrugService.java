package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.entity.Drug;

public interface DrugService {
	
	List<Drug> findAll();
	
	void insert(Drug drug);
	
	Drug findById(String id);
	
	void update(Drug drug);
	
	void delete(String id);
}
