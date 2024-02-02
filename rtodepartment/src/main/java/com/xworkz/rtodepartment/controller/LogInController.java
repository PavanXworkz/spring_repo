package com.xworkz.rtodepartment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rtodepartment.dto.RTODepartmentDTO;
import com.xworkz.rtodepartment.dto.RTOUserDTO;
import com.xworkz.rtodepartment.mail.MailService;
import com.xworkz.rtodepartment.service.RTODepartmentService;
import com.xworkz.rtodepartment.service.RTOUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class LogInController {

	@Autowired
	RTODepartmentService service;

	@Autowired
	RTOUserService userService;

	@Autowired
	MailService mailService;

	// Logger logger = LoggerFactory.getLogger(LogInController.class);

	public LogInController() {
		log.info("Running Logger");

	}

	@GetMapping("rto")
	public String connection(@RequestParam String pageConnection, Model model) {
		System.out.println(pageConnection);
		if (pageConnection.equals("ADMIN")) {

			return "SignIn";
		}
		return "index";

	}

	@GetMapping("officer")
	public String offLogin(@RequestParam String emailId, String password, Model model) {
		RTODepartmentDTO dto = service.offLogin(emailId, password);
		if (dto != null) {
			model.addAttribute("d", dto);
			List<RTOUserDTO> dtos = userService.findState(dto.getState());
			if (!dtos.isEmpty()) {
				model.addAttribute("users", dtos);
			} else {
				model.addAttribute("errr", "No users found for the admin's state.");
			}
			return "officerProfile";
		} else {
			model.addAttribute("err", "Invalid Credentials");
			return "officerSignIn";
		}
	}

	@GetMapping("findAll")
	public String findAll(Model model) {
		System.out.println("admin find all controller");
		List<RTODepartmentDTO> dtos = service.findAll();
		model.addAttribute("list", dtos);
		return "adminProfile";

	}

	/*
	 * @GetMapping("login") public String login(@RequestParam String emailId, Model
	 * model) { RTODepartmentDTO dto = null;
	 * 
	 * List<RTODepartmentDTO> dtos = service.findAll(); for (RTODepartmentDTO
	 * rtoDepartmentDTO : dtos) { if (rtoDepartmentDTO.getEmailId().equals(emailId))
	 * { dto = rtoDepartmentDTO; model.addAttribute("emailId", emailId); }
	 * 
	 * } // System.err.println(emailId + "my beautiful otp is " + otp); //
	 * RTODepartmentDTO dto = service.login(emailId, otp);
	 * 
	 * // System.out.println(dto); int randumNumber = (int) ((Math.random() * 90000)
	 * + 10000); boolean mail = mailService.sentMail(emailId,
	 * String.valueOf(randumNumber)); // rtoDepartmentDTO = dto;
	 * System.err.println("my otp is--" + String.valueOf(randumNumber)); if (mail ==
	 * true && dto != null) { service.updateOTP(dto, String.valueOf(randumNumber));
	 * model.addAttribute("d", dto); model.addAttribute("otp", "OTP sent"); return
	 * "SignInOTP"; } else { model.addAttribute("exp",
	 * "*invalid email or password"); return "SignIn"; } }
	 */
	@PostMapping("admin")
	public String adminLogin(@RequestParam String emailId, @RequestParam String otp, Model model, String num) {
		RTODepartmentDTO dto = null;
		if (num.equalsIgnoreCase("SendOtp")) {
			model.addAttribute("emailId", emailId);
			List<RTODepartmentDTO> dtos = service.findAll();
			for (RTODepartmentDTO rtoDTO : dtos) {
				if (rtoDTO.getEmailId().equals(emailId)) {
					System.out.println("================" + emailId + "===============");
					dto = rtoDTO;
				}
			}

			int randomNumber = (int) ((Math.random() * 9000) + 1000);
			boolean mail = mailService.sentMail(emailId, String.valueOf(randomNumber));
			log.info("my otp is==" + String.valueOf(randomNumber));
			System.err.println(String.valueOf(randomNumber));
			if (mail) {
				System.out.println("==============rdm no=============");
				service.updateOTP(dto, String.valueOf(randomNumber));
				System.out.println("*********************************");
				model.addAttribute("dt", dto);
				log.debug("{}" + dto);
				model.addAttribute("otp", "OTP SENT");
				return "SignIn";
			} else {
				model.addAttribute("exp", "*invalid email");
				return "SignIn";
			}
		} else if (num.equalsIgnoreCase("login")) {
			List<RTODepartmentDTO> dtos1 = service.findAll();
			for (RTODepartmentDTO rtoDTO2 : dtos1) {
				if (rtoDTO2.getEmailId().equals(emailId)) {
					dto = rtoDTO2;
				}
			}
			model.addAttribute("emailId", emailId);
			if (dto.getOtp().equalsIgnoreCase(otp)) {
				dto.setCount(0);
				service.updateCount(dto);
				dto.setAccountStatus("active");
				return "adminProfile";
			} else {
				dto.setCount(dto.getCount());
				service.updateCount(dto);
				if (dto.getCount() == 3) {
					model.addAttribute("blocked", "AccountBlocked");
					dto.setAccountStatus("inactive");
				} else {
					model.addAttribute("wrg", "invalid OTP");
				}
				return "SignIn";
			}
		}
		return "adminProfile";
	}

	@PostMapping("updateotp")
	public String updateOTP(@RequestParam String emailId, @RequestParam String otp, Model model) {
		RTODepartmentDTO dto = service.login(emailId, otp);
		if (dto != null) {
			List<RTOUserDTO> dtos = userService.findState(dto.getState());

			if (!dtos.isEmpty()) {

				System.out.println("otp saved");
				model.addAttribute("users", dtos);
			} else {
				model.addAttribute("err", "No applicationfrom this state");
			}
			return "adminProfile";
		} else {
			System.out.println("otp not saved");
			model.addAttribute("op", "invalid otp");
			return "SignIn";
		}
	}

	@PostMapping("updatePassOtp")
	public String updatePassOtp(@RequestParam String emailId, @RequestParam String otp, Model model) {
		RTODepartmentDTO dto = service.updatePassword(emailId, otp);
		if (dto != null) {
			List<RTOUserDTO> dtos = userService.findState(dto.getState());

			if (!dtos.isEmpty()) {

				model.addAttribute("users", dtos);
			} else {
				model.addAttribute("err", "No applicationfrom this state");
			}
			return "forgotpassword";
		} else {
			model.addAttribute("op", "invalid otp");
			return "emailVerifi";
		}
	}

	@PostMapping("updadePassword")
	public String updadePassword(@RequestParam String emailId, Model model) {
		RTODepartmentDTO dto = null;

		List<RTODepartmentDTO> dtos = service.findAll();
		for (RTODepartmentDTO rtoDepartmentDTO : dtos) {
			if (rtoDepartmentDTO.getEmailId().equals(emailId)) {
				dto = rtoDepartmentDTO;
				model.addAttribute("emailId", emailId);
			}

		}
		// System.err.println(emailId + "my beautiful otp is " + otp);
		// RTODepartmentDTO dto = service.login(emailId, otp);

		// System.out.println(dto);
		int randumNumber = (int) ((Math.random() * 90000) + 10000);
		boolean mail = mailService.sentMail(emailId, String.valueOf(randumNumber));
		// rtoDepartmentDTO = dto;
		System.err.println("my otp is" + String.valueOf(randumNumber));
		if (mail == true && dto != null) {
			service.updateOTP(dto, String.valueOf(randumNumber));
			model.addAttribute("d", dto);
			model.addAttribute("otp", "OTP sent");
			return "emailVerifi";

		} else {
			model.addAttribute("exp", "*invalid email or otp");
			return "emailVerifi";

		}

	}

	@PostMapping("passUpdate")
	public String passUpdate(@RequestParam String emailId, @RequestParam String password,
			@RequestParam String confirmPassword, Model model) {
		RTODepartmentDTO dto = null;
		List<RTODepartmentDTO> dtos = service.findAll();
		for (RTODepartmentDTO rtoDepartmentDTO : dtos) {
			if (rtoDepartmentDTO.getEmailId().equals(emailId)) {
				dto = rtoDepartmentDTO;
			}
		}
		if (dto != null) {
			service.password(dto, password, confirmPassword);
			model.addAttribute("pass", "password updated sucessfully");
			return "forgotpassword";
		} else {
			model.addAttribute("paer", "unsucessful");
			return "forgotpassword";
		}

	}

}
