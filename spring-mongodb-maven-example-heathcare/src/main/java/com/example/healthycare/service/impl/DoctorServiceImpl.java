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
	private DoctorDao doctorDao;
	
	@Override
	public List<Doctor> findAll() {
		return doctorDao.findAll(Doctor.class);
	}

	@Override
	public void insert(Doctor doctor) {
		doctorDao.insert(doctor);
	}

	@Override
	public Doctor findById(String id) {
		return doctorDao.findById(id);
	}

	@Override
	public void update(Doctor doctor) {
		doctorDao.update(doctor);
	}

	@Override
	public void delete(String id) {
		doctorDao.delete(id);
	}

	public Doctor findByEmployeeId(String employeeId) {
		return doctorDao.findByEmployeeId(employeeId);
	}
}
