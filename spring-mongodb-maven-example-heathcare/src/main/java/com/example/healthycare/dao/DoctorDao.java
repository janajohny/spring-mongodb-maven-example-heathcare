package com.example.healthycare.dao;

import com.example.healthycare.entity.Doctor;
/**
 * 
 * @author vominhtung
 *
 */
public interface DoctorDao extends BaseDao<Doctor>{

	public abstract Doctor findById(String id);

	public abstract void update(Doctor doctor);

	public abstract Doctor findByEmployeeId(String employeeId);
	
	public abstract void delete(String id);

}