package com.xworkz.resort1.service;

import java.util.List;

import com.xworkz.resort1.dto.Resort1DTO;

public interface Resort1Service {

	abstract boolean onSave(Resort1DTO dto);

	abstract List<Resort1DTO> view();

	abstract Resort1DTO findById(int id);
	
	abstract List<Resort1DTO> findByName(String name);
	
	List<Resort1DTO> findEmail(String Email);
	
	abstract boolean deleteById(int id);
	
	abstract boolean deleteByEmail(String email);
	
	boolean deleteByName(String name);
}
