package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.entity.Doctor;
/**
 * 
 * @author vominhtung
 *
 */
public interface DoctorService {
	
	List<Doctor>findAll();
	
	void insert(Doctor doctor);
	
	Doctor findById(String id);
	
	void update(Doctor doctor);
	
	void delete(String id);
	
	Doctor findByEmployeeId(String employeeId);
}
