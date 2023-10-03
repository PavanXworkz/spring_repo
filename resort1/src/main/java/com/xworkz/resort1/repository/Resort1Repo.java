package com.xworkz.resort1.repository;

import java.util.List;

import com.xworkz.resort1.dto.Resort1DTO;
import com.xworkz.resort1.entity.Resort1Entity;

public interface Resort1Repo {

	abstract boolean validateAndSave(Resort1DTO dto);

	abstract List<Resort1Entity> viewAll();
}
