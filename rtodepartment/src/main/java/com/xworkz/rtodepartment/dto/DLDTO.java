package com.xworkz.rtodepartment.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DLDTO {
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private String gender;
	private String occupation;
	private String education;
	private String bloodGroup;
	private String citizenship;
	private long citizenshipNumber;
	private String citizenshipIssuedDistict;
	private String passportNumber;
	private String countryPassport;
	private String mark;
	private String witnwssFirstName;
	private String witnessMiddleName;
	private String witnessLastName;
	private String witnessRelation;
	private String trainerName;
	private String licenceNumber;
	private LocalDateTime registerDateTime;
	private String applicationNumber;
	private String state;
	private String status;
	private String file;
}
