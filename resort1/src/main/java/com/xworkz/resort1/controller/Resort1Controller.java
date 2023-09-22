package com.xworkz.resort1.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.resort1.dto.Resort1DTO;


@Component
@RequestMapping("/")
public class Resort1Controller {

	@PostMapping("/save")
	public String coustemer(@ModelAttribute Resort1DTO dto,Model model) {
		model.addAttribute("d",dto );
		return "index.jsp";
}
}