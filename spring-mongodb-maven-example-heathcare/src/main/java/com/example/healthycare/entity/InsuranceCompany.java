package com.example.healthycare.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author vominhtung
 *
 */
@Document(collection="insurance_company")
public class InsuranceCompany {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
