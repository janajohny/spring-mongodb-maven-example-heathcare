package com.example.healthycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthycare.dao.DrugDao;
import com.example.healthycare.entity.Drug;
import com.example.healthycare.service.DrugService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value ="drugService") 
public class DrugServiceImpl implements DrugService{

	@Autowired
	DrugDao drugDao;
	
	public List<Drug> findAll() {
		return drugDao.findAll(Drug.class);
	}

	public void insert(Drug drug) {
		drugDao.insert(drug);
	}

	public Drug findById(String id) {
		return drugDao.findById(id);
	}

	public void update(Drug drug) {
		drugDao.update(drug);
	}
	
	public void delete(String id){
		drugDao.delete(id);
	}

}
