package com.xworkz.rtodepartment.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rtodepartment.dto.DLDTO;
import com.xworkz.rtodepartment.entity.DlEntity;
import com.xworkz.rtodepartment.repository.DLApplicationRepo;

@Service
public class DlServiceImplementation implements DlService {

	@Autowired
	DLApplicationRepo repo;

	@Override
	public boolean validateAndSave(DLDTO dldto) {
		if (dldto != null) {
			int randomNumbers = (int) (Math.random() * 100) + 900;
			String num = String.valueOf(randomNumbers);
			String app = null;
			app = "KA012024" + num;

			if (dldto.getState().equals("Karnataka")) {
				app = "KA2023" + num;
			} else if (dldto.getState().equals("Andhra Pradesh")) {
				app = "AP2023" + num;
			} else if (dldto.getState().equals("Bihar")) {
				app = "BR2023" + num;
			} else if (dldto.getState().equals("Gujarat")) {
				app = "GJ2023" + num;
			} else if (dldto.getState().equals("Kerala")) {
				app = "KL2023" + num;
			}

			dldto.setApplicationNumber(app);
			repo.validateAndSave(dldto);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateById(int id) {
		boolean update = repo.updateById(id);
		return update;
	}

	@Override
	public DLDTO updateApplication(String applicationNumber) {
		DlEntity entity = repo.updateApplication(applicationNumber);
		DLDTO dldto = new DLDTO();
		BeanUtils.copyProperties(entity, dldto);

		return dldto;
	}

	@Override
	public boolean updateById(DLDTO dldto) {
		DlEntity dlEntity = new DlEntity();
		BeanUtils.copyProperties(dldto, dlEntity);
		boolean update = repo.updateById(dlEntity);
		return update;
	}

}
