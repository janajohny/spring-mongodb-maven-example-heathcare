package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.entity.Prescription;

/**
 * 
 * @author vominhtung
 *
 */
public interface PrescriptionService {
	
	List<Prescription>findAll();

	void insert(Prescription prescription);
	
	void delete(String id);
	
	Prescription findById(String id);
	
	void update(Prescription prescription);
}
