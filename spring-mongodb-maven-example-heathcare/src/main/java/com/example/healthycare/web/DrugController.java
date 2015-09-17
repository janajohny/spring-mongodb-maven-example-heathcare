package com.example.healthycare.web;

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
import com.example.healthycare.service.DrugService;
/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/drug")
public class DrugController {
	
	@Autowired
	private DrugService drugService; 

	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		List<Drug> drugs = drugService.findAll();
		mm.put("drugs", drugs);
		return "drug/list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addDrugForm(ModelMap mm){
		Drug drug = new Drug();
		mm.addAttribute("drug", drug);
		return "drug/add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addDrug(@ModelAttribute(value = "drug")Drug drug){
		drugService.insert(drug);
		return "redirect:/drug";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editDrugForm(@PathVariable(value = "id")ObjectId id, ModelMap mm){
		Drug drug = drugService.findById(id);
		mm.addAttribute("drug", drug);
		return "drug/edit";
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.POST)
	public String editDrugForm(@ModelAttribute(value = "drug")Drug drug, ModelMap mm){
		drugService.update(drug);
		return "redirect:/drug";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String editDrugForm(@PathVariable(value = "id")String id){
		drugService.delete(id);
		return "redirect:/drug";
	}
}
