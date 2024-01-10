package com.xworkz.rtodepartment.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.rtodepartment.dto.RTODepartmentDTO;
import com.xworkz.rtodepartment.entity.RTOEntity;

@Repository

public class RTODepartmentRepositoryImplements implements RTODepartmentRepository {

	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean validateAndSave(RTODepartmentDTO dto) {
		EntityManager manager = factory.createEntityManager();
		System.out.println("validate and save repo" + dto);
		RTOEntity entity = new RTOEntity();
		BeanUtils.copyProperties(dto, entity);
		System.out.println("save" + entity);
		entity.setRegistereDateTime(LocalDateTime.now());
		boolean em = findByEmail(dto.getEmailId());
		if (em) {
			return false;
		} else {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			manager.close();
			return true;
		}
	}

	@Override
	public boolean findByEmail(String emailId) {
		EntityManager manager = factory.createEntityManager();
		RTOEntity entity = new RTOEntity();
		Query query = manager.createNamedQuery("findEmail");
		query.setParameter("email", emailId);
		try {
			entity = (RTOEntity) query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		if (entity.getEmailId().equals(emailId)) {
			System.err.println("emailId matched");
			return true;
		} else {
			System.err.println("emailId not matched");
			return false;
		}
	}

	@Override
	public RTOEntity login(String emailId, String otp) {

		EntityManager manager = factory.createEntityManager();
		Query login = manager.createNamedQuery("login");
		login.setParameter("eid", emailId);
		login.setParameter("otp", otp);
		System.out.println("login query accepting in repo 00000000000000000");
		try {
			// login.setParameter("psw", otp);
			return (RTOEntity) login.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<RTOEntity> findByState(String state) {
		EntityManager manager = factory.createEntityManager();
		System.out.println("connection established" + manager);
		Query stnm = manager.createNamedQuery("findbystate");
		System.out.println("#############################");
		stnm.setParameter("st", state);
		List<RTOEntity> entities = stnm.getResultList();
		return entities;
	}

	@Override
	public boolean updateOTP(RTODepartmentDTO dto) {
		System.out.println("repo@@@@@@@@@@@@@@@@@@@2SSS" + dto);
		EntityManager manager = factory.createEntityManager();
		RTOEntity entity = new RTOEntity();
		System.out.println("copy entity");
		BeanUtils.copyProperties(dto, entity);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public List<RTOEntity> findAll() {
		System.out.println("read all");
		EntityManager manager = factory.createEntityManager();
		Query fal = manager.createNamedQuery("findAll");
		return (List<RTOEntity>) fal.getResultList();
	}

	// verify email
	@Override
	public RTOEntity updatePassword(String emailId, String otp) {

		EntityManager manager = factory.createEntityManager();
		Query login = manager.createNamedQuery("login");
		login.setParameter("eid", emailId);
		login.setParameter("otp", otp);
		System.out.println("login query accepting in repo 00000000000000000");
		try {
			// login.setParameter("psw", otp);
			return (RTOEntity) login.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean password(RTODepartmentDTO dto, String confirmPassword, String password) {
		EntityManager manager = factory.createEntityManager();
		RTOEntity entity = new RTOEntity();
		BeanUtils.copyProperties(dto, entity);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public RTOEntity offLogin(String emailId, String password) {
		EntityManager manager = factory.createEntityManager();
		Query login = manager.createNamedQuery("officer");
		login.setParameter("eid", emailId);
		login.setParameter("pws", password);
		return (RTOEntity) login.getSingleResult();
	}

	@Override
	public boolean updateCount(RTODepartmentDTO dto) {
		EntityManager manager = factory.createEntityManager();
		RTOEntity entity = new RTOEntity();
		BeanUtils.copyProperties(dto, entity);
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
		manager.close();
		return true;
	}

}
