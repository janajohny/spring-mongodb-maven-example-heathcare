package com.example.healthycare.service;

import java.util.List;

import com.example.healthycare.entity.Doctor;

public interface DoctorService {
	
	List<Doctor>findAll();
	
	void insert(Doctor doctor);
}
