package com.example.healthycare.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.service.PatientService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap mm){
		mm.put("patients", patientService.findAll());
		return "index";
	}
}
