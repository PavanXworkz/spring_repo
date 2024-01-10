package com.xworkz.rtodepartment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogInDTO {

	private String emailId;
	private String password;
	private String otp;
	private String confirmPassword;

}
