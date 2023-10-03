package com.xworkz.resort1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.resort1.dto.Resort1DTO;
import com.xworkz.resort1.service.Resort1Service;

@Component
@RequestMapping("/")
public class Resort1Controller {
	public Resort1Controller() {
		System.out.println(" resort controller");
	}

	@Autowired
	Resort1Service service;

	@PostMapping("/save")
	public String coustemer(@ModelAttribute Resort1DTO dto, Model model) {
		service.onSave(dto);
		model.addAttribute("d", dto);
		return "sucess";
	}

	@GetMapping("viewAll")
	public String viewAll(Model model) {

		System.out.println("Invoking viewAll in controller");
		List<Resort1DTO> dto = service.view();
		if (dto != null) {
			model.addAttribute("dtoValue", dto);
			return "form";
		} else {
			model.addAttribute("message4", "No records");
		}
		return "form";
	}
}