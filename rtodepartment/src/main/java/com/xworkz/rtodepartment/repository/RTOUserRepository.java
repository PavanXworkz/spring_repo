package com.xworkz.rtodepartment.repository;

import java.util.List;

import com.xworkz.rtodepartment.dto.RTOUserDTO;
import com.xworkz.rtodepartment.entity.RTOUserEntity;

public interface RTOUserRepository {

	public abstract boolean validateAndSave(RTOUserDTO userDTO);

	public List<RTOUserEntity> findAll();

	public RTOUserEntity findUser(String appOrContNo, String dto);

	public List<RTOUserEntity> findByState(String state);

	public boolean updateById(int id);
}
