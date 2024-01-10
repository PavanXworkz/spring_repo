package com.xworkz.rtodepartment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rtodepartment.dto.RTODepartmentDTO;
import com.xworkz.rtodepartment.entity.RTOEntity;
import com.xworkz.rtodepartment.repository.RTODepartmentRepository;

@Service
public class RTODepartmentServiceImplements implements RTODepartmentService {

	@Autowired
	public RTODepartmentRepository repository;

	@Override
	public Set<ConstraintViolation<RTODepartmentDTO>> save(RTODepartmentDTO dto) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<RTODepartmentDTO>> violations = validator.validate(dto);

		if (violations.isEmpty()) {
			if (dto.getPassword().equals(dto.getConfirmPassword())) {
				repository.validateAndSave(dto);
			}
			return violations;
		} else {
			System.out.println("Violation Present");
			return violations;
		}
	}

	@Override
	public boolean findEmail(String emailId) {
		return repository.findByEmail(emailId);
	}

	@Override
	public RTODepartmentDTO login(String email, String otp) {
		RTOEntity entity = repository.login(email, otp);
		if (email != null && otp != null /* & password.length() >= 8 */) {
			if (entity != null) {
				RTODepartmentDTO dto = new RTODepartmentDTO();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmailId().equalsIgnoreCase(email) && dto.getOtp().equals(otp)) {
					return dto;
				} else {
					System.out.println("email or otp is invalid");
					return null;
				}
			} else {
				System.out.println("entity is null");
				return null;
			}
		} else {
			System.out.println("email and password is null");
			return null;
		}
	}

	@Override
	public List<RTODepartmentDTO> findByState(String state) {
		List<RTOEntity> entities = repository.findByState(state);
		List<RTODepartmentDTO> dtos = new ArrayList<RTODepartmentDTO>();
		for (RTOEntity rtoEntity : entities) {
			RTODepartmentDTO dto = new RTODepartmentDTO();
			BeanUtils.copyProperties(rtoEntity, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public boolean updateOTP(RTODepartmentDTO dto, String otp) {
		System.out.println("serviceimpl" + dto + "/" + otp);
		dto.setOtp(otp);
		boolean otpUpdate = repository.updateOTP(dto);
		return otpUpdate;
	}

	@Override
	public List<RTODepartmentDTO> findAll() {
		List<RTOEntity> entities = repository.findAll();
		List<RTODepartmentDTO> dtos = new ArrayList<RTODepartmentDTO>();

		for (RTOEntity rtoEntity : entities) {
			RTODepartmentDTO dto = new RTODepartmentDTO();
			BeanUtils.copyProperties(rtoEntity, dto);
			dtos.add(dto);
		}
		System.out.println(dtos.toString());
		return dtos;
	}

	@Override
	public RTODepartmentDTO updatePassword(String email, String otp) {
		RTOEntity entity = repository.updatePassword(email, otp);
		if (email != null && otp != null /* & password.length() >= 8 */) {
			if (entity != null) {
				RTODepartmentDTO dto = new RTODepartmentDTO();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmailId().equalsIgnoreCase(email) && dto.getOtp().equals(otp)) {
					return dto;
				} else {
					System.out.println("email or otp is invalid");
					return null;
				}
			} else {
				System.out.println("entity is null");
				return null;
			}
		} else {
			System.out.println("email and password is null");
			return null;
		}
	}

	@Override
	public boolean password(RTODepartmentDTO dto, String confirmPassword, String password) {
		dto.setPassword(password);
		dto.setConfirmPassword(confirmPassword);
		boolean newPassword = repository.password(dto, confirmPassword, password);
		return newPassword;
	}

	@Override
	public RTODepartmentDTO offLogin(String emailId, String password) {
		RTOEntity entity = repository.offLogin(emailId, password);
		if (emailId != null && password != null & password.length() >= 8) {
			if (entity != null) {
				RTODepartmentDTO dto = new RTODepartmentDTO();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmailId().equalsIgnoreCase(emailId) && dto.getPassword().equals(password)) {
					return dto;
				} else {
					System.out.println("email or password is invalid");
					return null;
				}
			} else {
				System.out.println("entity is null");
				return null;
			}
		} else {
			System.out.println("email and password is null");
			return null;
		}
	}

	@Override
	public boolean updateCount(RTODepartmentDTO dto) {
		boolean loginCount = repository.updateCount(dto);
		return loginCount;
	}

}
