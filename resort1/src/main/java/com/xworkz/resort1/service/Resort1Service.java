package com.xworkz.resort1.service;
import java.util.List;

import com.xworkz.resort1.dto.Resort1DTO;

public interface Resort1Service {

	abstract boolean onSave(Resort1DTO dto);
	abstract List<Resort1DTO> view();
}
