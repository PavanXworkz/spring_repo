package com.xworkz.rtodepartment.service;

import com.xworkz.rtodepartment.dto.DLDTO;

public interface DlService {
	boolean validateAndSave(DLDTO dldto);

	boolean updateById(int id);

	public DLDTO updateApplication(String applicationNumber);

	public boolean updateById(DLDTO dldto);
}
