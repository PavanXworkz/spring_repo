package com.xworkz.rtodepartment.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dlapplication")
public class DlEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private long CitizenshipNumber;
	private String citizenshipIssuedDistict;
	private String passportNumber;
	private String countryPassport;
	private String mark;
	private String witnwssFirstName;
	private String witnessMiddleName;
	private String witnessLastName;
	private String witnessRelation;
	private String witnessName;
	private String licenceNumber;
	private LocalDateTime registerDateTime;

}
