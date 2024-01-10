package com.xworkz.rtodepartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.rtodepartment.dto.DLDTO;
import com.xworkz.rtodepartment.service.DlService;

@Controller
@RequestMapping("/")
public class DlConroller {
	@Autowired
	DlService service;

	@PostMapping("dl")
	public String save(@ModelAttribute DLDTO dldto, Model model) {
		service.validateAndSave(dldto);
		model.addAttribute(null, model);
		return "DLapplication";

	}
}
