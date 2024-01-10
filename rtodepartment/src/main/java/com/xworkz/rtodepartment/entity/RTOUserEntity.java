package com.xworkz.rtodepartment.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_rto")
@NamedQueries({ @NamedQuery(name = "findAllUser", query = "select e from RTOUserEntity e"),
		@NamedQuery(name = "findByState", query = "SELECT e from RTOUserEntity e WHERE e.state=:st"),
		@NamedQuery(name = "userLogin", query = "SELECT e FROM RTOUserEntity e WHERE(e.applicationNumber=:apporcontno OR e.contactNo=:apporcontno) AND e.dob=:dob") })
public class RTOUserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	@Column(name = "MiddleName")
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
