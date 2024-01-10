package com.xworkz.resort1.service;

import java.util.ArrayList;
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

	@Override
	public Resort1DTO findById(int id) {

		System.out.println("invoking service find id metthod=" + id);
		Resort1DTO resort1dto = new Resort1DTO();
		if (id != 0) {
			System.out.println("Id is not null");
			Resort1Entity entity = repo.findById(id);
			if (entity != null) {
				System.out.println("entity is not null");
				BeanUtils.copyProperties(entity, resort1dto);
			} else {
				System.out.println("entity is null");
			}
		}
		return resort1dto;
	}

	@Override
	public List<Resort1DTO> findByName(String name) {
		List<Resort1Entity> entity = repo.findByName(name);
		List<Resort1DTO> dtos = new ArrayList<Resort1DTO>();
		for (Resort1Entity resort1Entity : entity) {
			Resort1DTO resort1dto = new Resort1DTO();
			BeanUtils.copyProperties(resort1Entity, resort1dto);
			dtos.add(resort1dto);
		}
		return dtos;
	}

	@Override
	public List<Resort1DTO> findEmail(String Email) {
		List<Resort1Entity> entities = repo.findEmail(Email);
		List<Resort1DTO> dResort1dtos = new ArrayList<Resort1DTO>();
		for (Resort1Entity resort1Entity : entities) {
			Resort1DTO resort1dto = new Resort1DTO();
			BeanUtils.copyProperties(resort1Entity, resort1dto);
			dResort1dtos.add(resort1dto);
		}
		return dResort1dtos;
	}

	@Override
	public boolean deleteById(int id) {
		boolean delete = false;
		if (id != 0) {
			delete = repo.deleteById(id);
		}
		if (delete != true) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean deleteByEmail(String email) {
		return repo.deleteByEmail(email);
	}

	@Override
	public boolean deleteByName(String name) {
		return repo.deleteByName(name);
	}

}
