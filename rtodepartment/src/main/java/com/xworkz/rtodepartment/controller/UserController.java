package com.xworkz.rtodepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rtodepartment.dto.RTOUserDTO;
import com.xworkz.rtodepartment.service.RTOUserService;

@Controller
@RequestMapping("/")
public class UserController {

	public UserController() {
		System.out.println(" user constructor");
	}

	@Autowired
	RTOUserService userService;

	@PostMapping("saveuser")
	public String save(@ModelAttribute RTOUserDTO userDTO, Model model) {
		List<RTOUserDTO> list = userService.findAll();
		for (RTOUserDTO rtoUserDTO : list) {
			if (rtoUserDTO.getEmailId().equalsIgnoreCase(userDTO.getEmailId())) {
				model.addAttribute("email", "Email already exist");
				return "UserSignUp";
			}
			if (rtoUserDTO.getContactNo() == userDTO.getContactNo()) {
				model.addAttribute("phone", "Phone Number already exist");
				return "UserSignUp";
			}
			if (rtoUserDTO.getAdhNo() == userDTO.getAdhNo()) {
				model.addAttribute("adh", "Applicant Details already exist");
				return "UserSignUp";
			}
		}
		System.out.println("user controller .......");
		userService.save(userDTO);
		System.out.println("**************usersave***************************" + userDTO);
		model.addAttribute("dt", userDTO);
		model.addAttribute("d", "successful");
		// model.addAttribute("appNo", "registration sucessful"+"Application Number"+
		// userDTO.getApplicationNumber());
		System.out.println("print" + userDTO);
		return "UserSignUp";
	}

	@GetMapping("logIn")
	public String logIn(@RequestParam String apporcontno, @RequestParam String dob, Model model) {
		RTOUserDTO dto = userService.findUser(apporcontno, dob);
		if (dto != null) {

			model.addAttribute("user", dto);
			return "userProfile";
		} else {
			model.addAttribute("err", "incalid details");
			return "userLogin";
		}
	}

	@GetMapping("approveUser")

	public String update(@RequestParam int id, Model model) {
		boolean update = userService.updateById(id);
		if (update == true) {
			model.addAttribute("d", id);
			model.addAttribute("up", "updated sucessfully");
			return "adminProfile";
		} else {
			model.addAttribute("nd", "update un sucessful");
		}
		return "adminProfile";

	}

}
