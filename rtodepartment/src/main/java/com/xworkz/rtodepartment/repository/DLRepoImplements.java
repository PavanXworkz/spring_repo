package com.xworkz.rtodepartment.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rtodepartment.dto.DLDTO;
import com.xworkz.rtodepartment.entity.DlEntity;

@Repository
public class DLRepoImplements implements DLApplicationRepo {

	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean validateAndSave(DLDTO dldto) {
		EntityManager manager = factory.createEntityManager();
		System.out.println("validate and save" + dldto);
		DlEntity entity = new DlEntity();
		BeanUtils.copyProperties(dldto, entity);
		entity.setRegisterDateTime(LocalDateTime.now());
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

}
