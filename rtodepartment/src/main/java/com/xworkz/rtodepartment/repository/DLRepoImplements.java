package com.xworkz.rtodepartment.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
		dldto.setRegisterDateTime(LocalDateTime.now());
		dldto.setStatus("Pending");
		DlEntity entity = new DlEntity();
		BeanUtils.copyProperties(dldto, entity);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public boolean updateById(int id) {
		EntityManager manager = factory.createEntityManager();
		DlEntity entity = manager.find(DlEntity.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if (entity != null) {

			entity.setStatus("Approved");
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			manager.close();
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @Override public DlEntity findUser(String applicationNumber, String dob) {
	 * EntityManager entityManager = factory.createEntityManager(); try { Query
	 * ulogin = entityManager.createNamedQuery("dlLogin");
	 * ulogin.setParameter("applicationNumber", applicationNumber);
	 * ulogin.setParameter("dob", dob); return (DlEntity) ulogin.getSingleResult();
	 * } catch (NoResultException e) { return null; }
	 * 
	 * }
	 */

	@Override
	public DlEntity updateApplication(String applicationNumber) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("uplode");
		query.setParameter("dlnumber", applicationNumber);
		DlEntity entity = (DlEntity) query.getSingleResult();
		return entity;
	}

	@Override
	public boolean updateById(DlEntity entity) {
		EntityManager manager = factory.createEntityManager();
		if (entity != null) {
			manager.getTransaction().begin();
			manager.merge(entity);
			manager.getTransaction().commit();
			manager.close();
		}
		return true;
	}

}
