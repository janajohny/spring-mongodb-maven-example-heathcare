package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.DoctorDao;
import com.example.healthycare.entity.Doctor;
import com.example.healthycare.service.DoctorService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value="doctorService")
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorRepository;
	
	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	@Override
	public void insert(Doctor doctor) {
		doctorRepository.insert(doctor);
	}
	
}
