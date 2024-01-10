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

import com.xworkz.rtodepartment.dto.RTOUserDTO;
import com.xworkz.rtodepartment.entity.RTOUserEntity;

@Repository
public class RTOUserRepoImpl implements RTOUserRepository {

	public RTOUserRepoImpl() {
		System.out.println("**********RTOUserRepoImpl***************");
	}

	@Autowired
	EntityManagerFactory factory;

	@Override
	public boolean validateAndSave(RTOUserDTO userDTO) {
		System.out.println("user saving repo");
		EntityManager manager = factory.createEntityManager();
		System.out.println("connection established" + manager);
		userDTO.setUserRegisterDateTime(LocalDateTime.now());
		// System.out.println(userDTO);
		userDTO.setApplicationStatu("Pending");
		RTOUserEntity userEntity = new RTOUserEntity();
		// userEntity.setDob(Date.valueOf(userDTO.getDob().toString()));
		// System.out.println("saving"+userEntity);

		// BeanUtils.copyProperties(userDTO, userEntity);
		BeanUtils.copyProperties(userDTO, userEntity);
		// if (userEntity!=null) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(userEntity);
		transaction.commit();
		manager.close();
		return true;
		// }else {
		// System.out.println("data is not saving");
		// return false;
	}

	@Override
	public List<RTOUserEntity> findAll() {
		EntityManager manager = factory.createEntityManager();
		Query fal = manager.createNamedQuery("findAllUser");
		List<RTOUserEntity> entities = fal.getResultList();
		entities.stream().forEach(System.out::println);
		return entities;
	}

	@Override
	public RTOUserEntity findUser(String apporcontno, String dob) {
		EntityManager entityManager = factory.createEntityManager();
		try {
			Query ulogin = entityManager.createNamedQuery("userLogin");
			ulogin.setParameter("apporcontno", apporcontno);
			ulogin.setParameter("dob", dob);
			return (RTOUserEntity) ulogin.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<RTOUserEntity> findByState(String state) {
		EntityManager manager = factory.createEntityManager();
		Query squery = manager.createNamedQuery("findByState");
		squery.setParameter("st", state);
		return squery.getResultList();
	}

	@Override
	public boolean updateById(int id) {
		EntityManager manager = factory.createEntityManager();
		RTOUserEntity entity = manager.find(RTOUserEntity.class, id);
		EntityTransaction transaction = manager.getTransaction();
		if (entity != null) {

			entity.setApplicationStatu("Approved");
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			manager.close();
			return true;
		} else {
			return false;
		}
	}
}
