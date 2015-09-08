package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.PrescriptionDao;
import com.example.healthycare.entity.Prescription;
import com.example.healthycare.service.PrescriptionService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value="prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService{

	@Autowired
	private PrescriptionDao prescriptionDao;
	
	@Override
	public List<Prescription> findAll() {
		return prescriptionDao.findAll();
	}

}
