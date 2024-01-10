package com.xworkz.resort1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException.NotAcceptable;

import com.xworkz.resort1.service.Resort1Service;

@Component
@RequestMapping("/")
public class Resort1DeleteController {

	@Autowired
	Resort1Service service;

	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		System.out.println("controller delete method=" + id);
		boolean delete = service.deleteById(id);
		if (delete == true) {
			model.addAttribute("success", "Record Deleted sucessfull");
			return "form";
		} else {
			model.addAttribute("fail", "deletion un sucessful");
			return "form";
		}
	}

	@GetMapping("Delete_by_Email")
	public String deleteEmail(@RequestParam String emailId, Model model) {
		System.out.println("data deleted........" + emailId);
		boolean deleted = service.deleteByEmail(emailId);
		if (deleted) {
			model.addAttribute("success", "Data deleted sucessful.......");
			return "Delete_by_Email";
		} else {
			model.addAttribute("unsucess", "No record found to delete...");
			return "Delete_by_Email";
		}
	}
	
   @GetMapping("deleteByName/{email}")
	public String deleteByName(@PathVariable String name, Model model) {
		System.out.println("data deleted by name...."+name);
		Boolean deleted=service.deleteByName(name);
		if (deleted) {
			model.addAttribute("success", "deleted sucessfull.....");
		}else {
			model.addAttribute("unssuccess", "NotAcceptable deleted.....");
		}
		return "Find_by_name";
		
	}
}
