package com.xworkz.rtodepartment.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RTODepartmentDTO {

	private int id;
	@Size(min = 3, max = 30, message = "min=3, should not exceed 30 characters")
	private String firstName;
	@Size(min = 2, max = 30, message = "min= 2, max=30")
	private String lastName;
	@NotBlank
	@NotEmpty
	private String dob;
	@Email
	private String emailId;
	@Positive
	@Min(value = 1000000000L, message = "should not be less then 10 digits")
	@Max(value = 9999999999L, message = "should not be more than 10 digits")
	private long phNo;
	@NotBlank
	@NotEmpty
	private String state;
	@NotBlank
	@NotEmpty
	private String district;
	@NotEmpty
	@NotBlank
	@NotEmpty
	private String password;
	@NotBlank
	@NotEmpty
	private String confirmPassword;

	private LocalDateTime registereDateTime;
	private String otp;
	private int count;
	private String accountStatus;
}
