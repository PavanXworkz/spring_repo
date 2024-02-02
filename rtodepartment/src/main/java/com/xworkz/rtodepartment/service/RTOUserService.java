package com.xworkz.rtodepartment.service;

import java.util.List;

import com.xworkz.rtodepartment.dto.RTOUserDTO;

public interface RTOUserService {

	public abstract boolean save(RTOUserDTO userDTO);

	public List<RTOUserDTO> findAll();

	public RTOUserDTO findUser(String apporcontno, String dob);

	public List<RTOUserDTO> findState(String state);

	public boolean updateById(int id);

	public RTOUserDTO getApplicationNo(String applicationNumber);
}
