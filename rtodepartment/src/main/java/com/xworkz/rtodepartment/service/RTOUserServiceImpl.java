package com.xworkz.rtodepartment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rtodepartment.dto.RTOUserDTO;
import com.xworkz.rtodepartment.entity.RTOUserEntity;
import com.xworkz.rtodepartment.repository.RTOUserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RTOUserServiceImpl implements RTOUserService {

	public RTOUserServiceImpl() {
		log.info("Running Logger");
		System.out.println("***********RTOUserServiceImpl*****");
	}

	@Autowired
	RTOUserRepository repository;

	@Override
	public boolean save(RTOUserDTO userDTO) {
		System.out.println("user service" + userDTO);
		if (userDTO != null) {
			System.out.println("**state*********************" + userDTO.getState());
			int randomNumbers = (int) (Math.random() * 100) + 900;
			String num = String.valueOf(randomNumbers);
			String app = null;
			if (userDTO.getState().equals("Karnataka")) {
				app = "KA2023LLR" + num;
			} else if (userDTO.getState().equals("Andhra Pradesh")) {
				app = "AP2023LLR" + num;
			} else if (userDTO.getState().equals("Bihar")) {
				app = "BR2023LLR" + num;
			} else if (userDTO.getState().equals("Gujarat")) {
				app = "GJ2023LLR" + num;
			} else if (userDTO.getState().equals("Kerala")) {
				app = "KL2023LLR" + num;
			}
			userDTO.setApplicationNumber(app);
			repository.validateAndSave(userDTO);
			return true;
		} else {
			System.out.println("found error");
			return false;
		}
	}

	@Override
	public List<RTOUserDTO> findAll() {
		List<RTOUserEntity> userEntities = repository.findAll();
		List<RTOUserDTO> rtoUserDTOs = new ArrayList<RTOUserDTO>();

		for (RTOUserEntity rtoUserEntity : userEntities) {
			System.out.println(rtoUserEntity);
			RTOUserDTO userDTO = new RTOUserDTO();
			BeanUtils.copyProperties(rtoUserEntity, userDTO);
			rtoUserDTOs.add(userDTO);
		}
		System.out.println(rtoUserDTOs.toString());
		return rtoUserDTOs;
	}

	@Override
	public RTOUserDTO findUser(String apporcontno, String dob) {
		RTOUserEntity entity = repository.findUser(apporcontno, dob);
		if (entity != null) {
			RTOUserDTO dto = new RTOUserDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public List<RTOUserDTO> findState(String state) {
		List<RTOUserEntity> entity = repository.findByState(state);
		List<RTOUserDTO> list = new ArrayList<RTOUserDTO>();
		for (RTOUserEntity rtoUserEntity : entity) {
			RTOUserDTO dto = new RTOUserDTO();
			BeanUtils.copyProperties(rtoUserEntity, dto);
			list.add(dto);
		}
		return list;
	}

	@Override
	public boolean updateById(int id) {
		boolean update = repository.updateById(id);
		return update;
	}

	@Override
	public RTOUserDTO getApplicationNo(String applicationNumber) {
		RTOUserEntity entity = repository.findApplication(applicationNumber);
		RTOUserDTO dto = new RTOUserDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
