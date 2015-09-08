package com.example.healthycare.service;

import com.example.healthycare.entity.MedicalHistory;

public interface MedicalHistoryService {

	MedicalHistory findByPatientId(String patientId);
	
	void insert(MedicalHistory medicalHistory);
}
