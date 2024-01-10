package com.xworkz.resort1.repository;

import java.util.List;

import com.xworkz.resort1.dto.Resort1DTO;
import com.xworkz.resort1.entity.Resort1Entity;

public interface Resort1Repo {

	abstract boolean validateAndSave(Resort1DTO dto);

	abstract List<Resort1Entity> viewAll();

	abstract Resort1Entity findById(int id);

	abstract List<Resort1Entity> findByName(String name);

	List<Resort1Entity> findEmail(String email);

	abstract boolean deleteById(int id);

	abstract boolean deleteByEmail(String email);

	boolean deleteByName(String name);

}
