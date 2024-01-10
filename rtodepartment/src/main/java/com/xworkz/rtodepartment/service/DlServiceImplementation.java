package com.xworkz.rtodepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rtodepartment.dto.DLDTO;
import com.xworkz.rtodepartment.repository.DLApplicationRepo;

@Service
public class DlServiceImplementation implements DlService {

	@Autowired
	DLApplicationRepo repo;

	@Override
	public boolean validateAndSave(DLDTO dldto) {
		if (dldto != null) {
			repo.validateAndSave(dldto);
			return true;
		} else {
			return false;
		}
	}

}
