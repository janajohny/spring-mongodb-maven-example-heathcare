package com.example.healthycare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.MedicalHistoryDao;
import com.example.healthycare.dao.PatientDao;
import com.example.healthycare.entity.MedicalHistory;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.service.MedicalHistoryService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value="MedicalHistoryService")
public class MedicalHistoryServiceImpl implements MedicalHistoryService{

	@Autowired
	private MedicalHistoryDao medicalHistoryRepository;
	
	@Override
	public MedicalHistory findByPatientId(String patientId) {
		return medicalHistoryRepository.findByPatientId(patientId);
	}

	@Override
	public void insert(MedicalHistory medicalHistory) {
		medicalHistoryRepository.insert(medicalHistory);
	}

}
