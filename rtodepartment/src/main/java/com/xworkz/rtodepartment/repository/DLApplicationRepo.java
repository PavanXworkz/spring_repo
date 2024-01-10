package com.xworkz.rtodepartment.repository;

import com.xworkz.rtodepartment.dto.DLDTO;

public interface DLApplicationRepo {
	public abstract boolean validateAndSave(DLDTO dldto);
}
