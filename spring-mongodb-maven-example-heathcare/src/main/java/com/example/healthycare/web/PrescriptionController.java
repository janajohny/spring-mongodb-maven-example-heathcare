package com.example.healthycare.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.entity.Prescription;
import com.example.healthycare.service.PrescriptionService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
	
	@Autowired
	PrescriptionService prescriptionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		List<Prescription>prescriptions = prescriptionService.findAll();
		mm.put("prescriptions", prescriptions);
		return "prescription/list";
	}
	
}
