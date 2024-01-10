package com.xworkz.rtodepartment.repository;

import java.util.List;

import com.xworkz.rtodepartment.dto.RTODepartmentDTO;
import com.xworkz.rtodepartment.entity.RTOEntity;

public interface RTODepartmentRepository {
	boolean validateAndSave(RTODepartmentDTO dto);

	boolean findByEmail(String emailId);

	public RTOEntity offLogin(String emailId, String password);

	RTOEntity login(String emailId, String otp);

	List<RTOEntity> findByState(String state);

	public boolean updateOTP(RTODepartmentDTO dto);

	public List<RTOEntity> findAll();

	RTOEntity updatePassword(String emailId, String otp);

	boolean password(RTODepartmentDTO dto, String confirmPassword, String password);

	public boolean updateCount(RTODepartmentDTO dto);
}
