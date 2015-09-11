package com.example.healthycare.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.entity.Patient;
import com.example.healthycare.service.AnswerService;
import com.example.healthycare.service.PatientService;
import com.example.healthycare.service.QuestionService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;
	
	@RequestMapping(value="detail/{patientId}", method = RequestMethod.GET)
	public String detail(@PathVariable(value="patientId")String patientId, ModelMap mm){
		Patient patient = patientService.findByPatientId(patientId);
		mm.put("patient", patient);
		return "patient/detail";
	}
	
	@RequestMapping(value="add", method = RequestMethod.GET)
	public String detail(ModelMap mm){
		Patient patient = new Patient();
		mm.addAttribute("p", patient);
		return "patient/add";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	@Transactional
	public String updatePatient(@ModelAttribute(value = "p")Patient patient){
		patientService.insert(patient);
		return "redirect:/index";
	}
	
	@RequestMapping(value="edit/{patientId}", method = RequestMethod.GET)
	public String editPatientForm(@PathVariable(value = "patientId")String patientId, ModelMap mm){
		Patient patient = patientService.findByPatientId(patientId);
		mm.put("patient", patient);
		return "patient/edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editPatient(@ModelAttribute(value = "patient")Patient patient, ModelMap mm){
		patientService.update(patient);
		mm.put("patient", patient);
		return "redirect:/index";
	}
	
	@RequestMapping(value="delete/{patientId}", method = RequestMethod.GET)
	public String deletePatient(@PathVariable(value = "patientId")String patientId){
		patientService.delete(patientId);
		return "redirect:/index";
	}
}
