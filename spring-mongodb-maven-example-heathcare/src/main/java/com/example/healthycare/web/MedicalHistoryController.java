package com.example.healthycare.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.dto.UpdateHistoryDTO;
import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.MedicalHistory;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.entity.Question;
import com.example.healthycare.service.AnswerService;
import com.example.healthycare.service.MedicalHistoryService;
import com.example.healthycare.service.PatientService;
import com.example.healthycare.service.QuestionService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/medicalhistory")
public class MedicalHistoryController {
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;
	
	@RequestMapping(value="update/{patientId}", method = RequestMethod.GET)
	public String updateMedicalRecordForm(@PathVariable(value="patientId")String patientId, ModelMap mm){
		List<UpdateHistoryDTO>questionAnswerMap = new ArrayList<UpdateHistoryDTO>();
		Patient patient = patientService.findByPatientId(patientId);
		if (patient != null) {
			if(patient.getMedicalHistory()!=null){
				mm.put("medicalHistory", patient.getMedicalHistory());
				mm.put("patientId", patientId);
			} 
		} else {
		}
		return "medical_record/update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMedicalRecord(@ModelAttribute(value = "medicalHistory") MedicalHistory medicalHistory) {
//		Patient patient = patientService.findByPatientId(medicalHistory.getPatientId());
//		if (patient != null) {
//			patient.setMedicalHistory(medicalHistory);
//			patientService.update(patient);
//		} else {
//		}
		return "redirect:/index";
	}
}
