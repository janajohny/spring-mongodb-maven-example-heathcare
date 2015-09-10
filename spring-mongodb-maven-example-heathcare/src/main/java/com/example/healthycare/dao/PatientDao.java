package com.example.healthycare.dao;

import com.example.healthycare.entity.Patient;

public interface PatientDao extends BaseDao<Patient>{

	public abstract Patient findByPatientId(String patientId);

	public abstract void update(Patient patient);

	public abstract void delete(String patientId);

}