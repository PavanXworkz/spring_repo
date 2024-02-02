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

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rto_info")
@NamedQueries({ @NamedQuery(name = "findEmail", query = "select e from RTOEntity e where e.emailId=:email"),
		@NamedQuery(name = "officer", query = "SELECT e FROM RTOEntity e WHERE e.emailId=:eid or e.password=:pws"),
		@NamedQuery(name = "login", query = "select e from RTOEntity e where e.emailId=:eid or e.otp=:otp"),
		@NamedQuery(name = "findbystate", query = "select e from RTOEntity e where e.state=:st"),
		@NamedQuery(name = "findAll", query = "select e from RTOEntity e")
// @NamedQuery(name = "updatePassword", query = "update e RTOEntity set
// e.confirmPassword=:cp, e.password=:ps WHERE e.email=:eml")
})

public class RTOEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Column(name = "dateOfBirth")
	private String dob;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "phoneNumber")
	private long phNo;
	@Column(name = "State")
	private String state;
	@Column(name = "District")
	private String district;
	@Column(name = "password")
	private String password;
	@Column(name = "confirmPassword")
	private String confirmPassword;
	@Column(name = "registerDateAndTime")
	private LocalDateTime registereDateTime;
	@Column(name = "otp")
	private String otp;
	@Column(name = "count")
	private String count;
	@Column(name = "accountStatus")
	private String accountStatus;

}
