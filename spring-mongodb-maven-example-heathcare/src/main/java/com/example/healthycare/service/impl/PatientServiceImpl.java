package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.PatientDao;
import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.service.PatientService;
/**
 * 
 * @author vominhtung
 *
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientRepository;
	
	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll(Patient.class);
	}

	@Override
	public Patient findByPatientId(String patientId) {
		return patientRepository.findByPatientId(patientId);
	}

	@Override
	public void insert(Patient patient) {
		patientRepository.insert(patient);
	}
	
	@Override
	public void update(Patient patient) {
		patientRepository.update(patient);
	}

	@Override
	public void delete(String patientId) {
		patientRepository.delete(patientId);
	}

}
