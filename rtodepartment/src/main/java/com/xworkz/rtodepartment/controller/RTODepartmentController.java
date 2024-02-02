package com.xworkz.rtodepartment.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rtodepartment.dto.RTODepartmentDTO;
import com.xworkz.rtodepartment.service.RTODepartmentService;

@Controller
@RequestMapping("/")

public class RTODepartmentController {

	@Autowired
	RTODepartmentService service;

	@PostMapping("save")
	public String validateAndSave(@ModelAttribute RTODepartmentDTO dto, Model model) {
		System.out.println("controller" + dto);
		boolean email = service.findEmail(dto.getEmailId());
		if (email) {
			model.addAttribute("err", "email already exist");
			return "SignUp";
		} else {

			Set<ConstraintViolation<RTODepartmentDTO>> violations = service.save(dto);
			if (violations.isEmpty()) {
				/*
				 * model.addAttribute("save", dto); model.addAttribute("message",
				 * "no violation ");
				 */
				model.addAttribute("succ", "Registration sucessfull");
				return "SignUp";
			} else {
				model.addAttribute("violation", violations);
				return "SignUp";
			}
		}
	}

	@GetMapping("state")
	public String findByState(@RequestParam String state, Model model) {
		List<RTODepartmentDTO> dto = service.findByState(state);
		System.out.println("state rtos" + state);
		model.addAttribute("state", dto);
		return "officerProfile";

	}

}
