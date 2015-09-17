package com.example.healthycare.web;

import java.util.Date;
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

import com.example.healthycare.entity.Doctor;
import com.example.healthycare.entity.Drug;
import com.example.healthycare.entity.Patient;
import com.example.healthycare.entity.Prescription;
import com.example.healthycare.service.DoctorService;
import com.example.healthycare.service.DrugService;
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
	
	@Autowired
	private DrugService drugService;
	
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
		Date createDate= new Date();
		prescription.setCreateDate(createDate);
		prescriptionService.insert(prescription);
		return "redirect:/prescription";
	}
	
	@RequestMapping(value="/drug/add/{prescriptionId}", method = RequestMethod.POST)
	public String addDrug(@ModelAttribute(value = "drug")Drug drug, @PathVariable(value="prescriptionId") String id){
		Prescription prescription = prescriptionService.findById(id);
		Drug newDrug = drugService.findById(drug.getId());
		newDrug.setDescription(drug.getDescription());
		prescription.getDrugs().add(newDrug);
		prescriptionService.update(prescription);
		return "redirect:/prescription/edit/"+id;
	}
	@RequestMapping(value="/drug/delete/{prescriptionId}/{drugId}", method = RequestMethod.GET)
	public String deleteDrug(@PathVariable(value = "prescriptionId")String prescriptionId, @PathVariable(value="drugId") String drugId){
		Prescription prescription = prescriptionService.findById(prescriptionId);
		List<Drug>drugs = prescription.getDrugs();
		for (Iterator iterator = drugs.iterator(); iterator.hasNext();) {
			Drug drug = (Drug) iterator.next();
			if(drug.getId().equals(new ObjectId(drugId))){
				iterator.remove();
				prescriptionService.update(prescription);
			}
		}
		return "redirect:/prescription/edit/"+prescriptionId;
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editPrescriptionForm(@PathVariable(value = "id")String id, ModelMap mm){
		Drug drug = new Drug();
		mm.addAttribute("drug", drug);
		Prescription prescription = prescriptionService.findById(id);
		mm.put("prescription", prescription);
		mm.addAttribute("patientList", patientService.findAll());
		mm.addAttribute("doctorList", doctorService.findAll());
		mm.addAttribute("drugs", drugService.findAll());
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
	
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public String detailPrescription(@ModelAttribute(value = "id")String id, ModelMap mm){
		Prescription prescription = prescriptionService.findById(id);
		mm.addAttribute("prescription", prescription);
		return "prescription/detail";
	}
}
