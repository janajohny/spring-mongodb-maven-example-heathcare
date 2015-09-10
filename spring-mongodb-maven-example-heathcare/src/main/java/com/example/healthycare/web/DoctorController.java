package com.example.healthycare.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.healthycare.entity.Doctor;
import com.example.healthycare.service.DoctorService;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		mm.clear();
		List<Doctor> doctors = doctorService.findAll();
		mm.put("doctors", doctors);
		return "doctor/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addDoctorForm(ModelMap mm){
		Doctor doctor = new Doctor();
		mm.addAttribute("doctor", doctor);
		return "doctor/create";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addDoctor(@ModelAttribute(value = "doctor")Doctor doctor, HttpServletRequest request){
		doctorService.insert(doctor);
		return "redirect:/doctor";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editDoctorForm(@PathVariable(value = "id")String id, ModelMap mm){
		Doctor doctor = doctorService.findById(id);
		mm.put("doctor", doctor);
		return "doctor/edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editDoctor(@ModelAttribute(value = "doctor")Doctor doctor, ModelMap mm){
		doctorService.update(doctor);
		return "redirect:/doctor";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteDoctor(@PathVariable(value ="id") String id){
		doctorService.delete(id);
		return "redirect:/doctor";
	}
}
