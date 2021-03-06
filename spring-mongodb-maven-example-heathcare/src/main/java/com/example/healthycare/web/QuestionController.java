package com.example.healthycare.web;

import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;
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
import com.example.healthycare.service.PatientService;
import com.example.healthycare.service.QuestionService;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		mm.put("questions", questionService.findAll());
		return "question/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addQuestionForm(ModelMap mm){
		Question question = new Question();
		mm.addAttribute("question", question);
		return "question/add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addDrug(@ModelAttribute(value = "question")Question question){
		List<Patient>patients = patientService.findAll();
		for (Iterator iterator = patients.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();
			Answer answer = new Answer();
			answer.setQuestion(question);
			patient.getMedicalHistory().getAnswers().add(answer);
			patientService.updateMedicalHistory(patient);
		}
		questionService.insert(question);
		return "redirect:/question";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editQuestionForm(@PathVariable(value = "id")ObjectId id, ModelMap mm){
		Question question = questionService.findById(id);
		mm.addAttribute("question", question);
		return "question/edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editQuestion(@ModelAttribute(value = "question")Question question, ModelMap mm){
		questionService.update(question);
		return "redirect:/question";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String editDrugForm(@PathVariable(value = "id")ObjectId id, ModelMap mm){
		Question question = questionService.findById(id);
		if(question!=null){
			List<Patient>patients = patientService.findAll();
			for (Iterator iterator = patients.iterator(); iterator.hasNext();) {
				Patient patient = (Patient) iterator.next();
				List<Answer>answers = patient.getMedicalHistory().getAnswers();
				for (Iterator iterator2 = answers.iterator(); iterator2.hasNext();) {
					Answer answer = (Answer) iterator2.next();
					if(answer.getQuestion().getId().equals(id)){
						iterator2.remove();
					}
				}
				patientService.updateMedicalHistory(patient);
			}
			questionService.delete(id);
		}
		return "redirect:/question";
	}
}
