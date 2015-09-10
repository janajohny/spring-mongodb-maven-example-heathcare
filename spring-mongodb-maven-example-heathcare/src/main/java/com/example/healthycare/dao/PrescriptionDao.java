package com.example.healthycare.dao;

import org.springframework.stereotype.Repository;
import com.example.healthycare.entity.Prescription;
/**
 * 
 * @author vominhtung
 *
 */
@Repository
public interface PrescriptionDao extends BaseDao<Prescription>{

	public abstract void delete(String id);

	public abstract Prescription findById(String id);

	public abstract void update(Prescription prescription);

}