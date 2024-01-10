package com.xworkz.rtodepartment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class RTOUserDTO {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String state;
//	private String country;
	private String dob;
	private int age;
	private String bloodGroup;
	private String Qualification;
	private String placeOfBirth;
	private String rtoOffice;
	private int permanentPinCode;
	private int presentPinCode;
	private String emailId;
	private long contactNo;
	private long adhNo;
	private String permanentAddress;
	private String currentAddress;
	private LocalDateTime userRegisterDateTime;
	private String applicationNumber;
	private String applicationStatu;
	private String otp;

}
