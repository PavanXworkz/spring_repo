package com.xworkz.resort1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.resort1.dto.Resort1DTO;
import com.xworkz.resort1.entity.Resort1Entity;
import com.xworkz.resort1.repository.Resort1Repo;

@Component
public class Resort1ServiceImpl implements Resort1Service {

	@Autowired
	private Resort1Repo repo;

	public Resort1ServiceImpl() {
		System.out.println("Resort service implitation");
	}

	@Override
	public boolean onSave(Resort1DTO dto) {
		if (dto != null) {
			System.out.println("details" + dto);
			repo.validateAndSave(dto);
			return true;
		} else {
			System.out.println("details error" + dto);
			return false;
		}
	}

	@Override
	public List<Resort1DTO> view() {
		List<Resort1Entity> entityList = repo.viewAll();

		List<Resort1DTO> dtolist = new ArrayList<Resort1DTO>();

		for (Resort1Entity ent : entityList) {
			Resort1DTO dto1 = new Resort1DTO();
			BeanUtils.copyProperties(ent, dto1);
			dtolist.add(dto1);
		}
		dtolist.stream().forEach(System.out::println);
		return dtolist;
	}
}
