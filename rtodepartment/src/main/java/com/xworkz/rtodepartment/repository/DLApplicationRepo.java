package com.xworkz.rtodepartment.repository;

import com.xworkz.rtodepartment.dto.DLDTO;
import com.xworkz.rtodepartment.entity.DlEntity;

public interface DLApplicationRepo {
	public abstract boolean validateAndSave(DLDTO dldto);

	public boolean updateById(int id);

	// public DlEntity findUser(String applicationNumber, String dob);

	public DlEntity updateApplication(String applicationNumber);

	public boolean updateById(DlEntity entity);

}
