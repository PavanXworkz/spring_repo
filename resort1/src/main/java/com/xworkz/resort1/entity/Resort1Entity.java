package com.xworkz.resort1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "resort_check_in")
@NamedQueries({ 
	@NamedQuery(name = "viewAll", query = "select e from Resort1Entity e") ,
	@NamedQuery(name="searchName", query="select e from Resort1Entity e where e.name=:nm"),
	@NamedQuery(name="findEmail", query="select e from Resort1Entity e where e.emailId=:email"),
	@NamedQuery(name="deleteByEmail", query="delete from Resort1Entity e where e.emailId=:ml"),
	@NamedQuery(name="deleteByName", query="delete from Resort1Entity e where e.name=:name")
})
public class Resort1Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String name;
	private String emailId;
	private String address;
	private long phoneNumber;
	private int rooms;
	private String roomType;
	private int noOfNights;
}
