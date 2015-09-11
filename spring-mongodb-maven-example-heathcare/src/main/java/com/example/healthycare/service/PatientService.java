package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Patient;
/**
 * 
 * @author vominhtung
 *
 */
public interface PatientService {

	List<Patient>findAll();
	
	Patient findByPatientId(String patientId);
	
	void insert(Patient patient);
	
	void updateMedicalHistory(Patient patient);
	
	void delete(String patientId);
	
	void update(Patient patient);
}
