package com.xworkz.rtodepartment.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.rtodepartment.dto.RTODepartmentDTO;

public interface RTODepartmentService {

	public Set<ConstraintViolation<RTODepartmentDTO>> save(RTODepartmentDTO dto);

	boolean findEmail(String emailId);

	RTODepartmentDTO offLogin(String emailId, String password);

	RTODepartmentDTO login(String email, String otp);

	List<RTODepartmentDTO> findByState(String State);

	public boolean updateOTP(RTODepartmentDTO dto, String OTP);

	List<RTODepartmentDTO> findAll();

	public boolean password(RTODepartmentDTO dto, String confirmPassword, String password);

	RTODepartmentDTO updatePassword(String email, String otp);

	public boolean updateCount(RTODepartmentDTO dto);
}
