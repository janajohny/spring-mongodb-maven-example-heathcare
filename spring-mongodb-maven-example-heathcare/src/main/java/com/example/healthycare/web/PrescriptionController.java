package com.example.healthycare.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.entity.Doctor;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.entity.Prescription;
import com.example.healthycare.service.DoctorService;
import com.example.healthycare.service.PatientService;
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
	private PrescriptionService prescriptionService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		List<Prescription>prescriptions = prescriptionService.findAll();
		mm.put("prescriptions", prescriptions);
		return "prescription/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addPrescriptionForm(ModelMap mm){
		Prescription prescription = new Prescription();
		mm.addAttribute("prescription", prescription);
		mm.addAttribute("patientList", patientService.findAll());
		mm.addAttribute("doctorList", doctorService.findAll());
		return "prescription/create";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addPrescription(@ModelAttribute(value = "prescription")Prescription prescription){
		Doctor doctor = doctorService.findByEmployeeId(prescription.getDoctor().getEmployeeId());
		Patient patient = patientService.findByPatientId(prescription.getPatient().getPatientId());
		prescription.setDoctor(doctor);
		prescription.setPatient(patient);
		prescriptionService.insert(prescription);
		return "redirect:/prescription";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editPrescriptionForm(@PathVariable(value = "id")String id, ModelMap mm){
		Prescription prescription = prescriptionService.findById(id);
		mm.put("prescription", prescription);
		mm.addAttribute("patientList", patientService.findAll());
		mm.addAttribute("doctorList", doctorService.findAll());
		return "prescription/edit";
	}
	
	@RequestMapping(value="/edit/", method = RequestMethod.POST)
	public String editPrescription(@ModelAttribute(value = "prescription")Prescription prescription, ModelMap mm){
		
		prescriptionService.update(prescription);
		return "redirect:/prescription";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deletePrescription(@ModelAttribute(value = "id")String id){
		prescriptionService.delete(id);
		return "redirect:/prescription";
	}
}
