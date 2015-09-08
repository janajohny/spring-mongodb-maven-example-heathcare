package com.example.healthycare.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author vominhtung
 *
 */
@Document(collection = "medical_history")
public class MedicalHistory {

	@Id
	private ObjectId id = new ObjectId() ;
	
	private String note;
	
	private List<Answer>answers;
	
	public MedicalHistory() {
		answers= new ArrayList<Answer>();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
