package com.example.healthycare.web;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.entity.Answer;
import com.example.healthycare.entity.Drug;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.entity.Question;
import com.example.healthycare.service.AnswerService;
import com.example.healthycare.service.PatientService;
import com.example.healthycare.service.QuestionService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	PatientService patientService;

	@RequestMapping(value="update/{patientId}/{answerId}", method = RequestMethod.GET)
	public String updateMedicalRecordForm(@PathVariable String patientId, @PathVariable String answerId,ModelMap mm){
		Patient patient = patientService.findByPatientId(patientId);
		Answer answer= null;
		for (Iterator iterator = patient.getMedicalHistory().getAnswers().iterator(); iterator.hasNext();) {
			Answer ans = (Answer) iterator.next();
			if(ans.getId().equals(answerId)){
				answer = ans;
			}
		}
		
		mm.addAttribute("answer", answer);
		mm.addAttribute("patientId", patientId);
		return "answer/update";
	}
	
	@RequestMapping(value="update/{patientId}", method = RequestMethod.POST)
	public String updateAnswer(@PathVariable(value="patientId") String patientId,@ModelAttribute(value = "answer") Answer answer, HttpServletRequest request){
		Patient patient = patientService.findByPatientId(patientId);
		for (Iterator iterator = patient.getMedicalHistory().getAnswers().iterator(); iterator.hasNext();) {
			Answer ans = (Answer) iterator.next();
			if(ans.getId().equals(answer.getId())){
				ans.setAnswer(answer.getAnswer());
				patientService.update(patient);
			}
		}
		return "redirect:/medicalhistory/update/"+patientId;
	}
	
	@RequestMapping(value="/create/{patientId}/{questionId}", method = RequestMethod.GET)
	public String addAnswerForm(@PathVariable(value="patientId") String patientId, @PathVariable(value="questionId")String questionId, ModelMap mm){
		Answer answer = new Answer();
		Question question = questionService.findById(questionId);
		answer.setQuestion(question);
		mm.addAttribute("answer", answer);
		return "answer/create";
	}
	
	@RequestMapping(value="/create/{patientId}", method = RequestMethod.POST)
	public String addDrug(@ModelAttribute(value = "answer")Answer answer, @PathVariable(value="patientId")String patientId){
		Patient patient = patientService.findByPatientId(patientId);
		List<Answer>answers = patient.getMedicalHistory().getAnswers();
		if(answers!=null){
			answers.add(answer);
		}
		patientService.update(patient);
		return "redirect:/medicalhistory/update/"+patientId;
	}
}
