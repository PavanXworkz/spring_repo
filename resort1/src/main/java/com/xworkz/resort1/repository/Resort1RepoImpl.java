package com.xworkz.resort1.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.resort1.dto.Resort1DTO;
import com.xworkz.resort1.entity.Resort1Entity;

@Component
public class Resort1RepoImpl implements Resort1Repo {

	public Resort1RepoImpl() {
		System.out.println("resort repo constructor");
	}

	@Autowired
	EntityManagerFactory factory;
	Resort1Entity entity = new Resort1Entity();

	@Override
	public boolean validateAndSave(Resort1DTO dto) {
		System.out.println("invoking validate and save method");
		System.out.println(dto);

		entity.setName(dto.getName());
		entity.setEmailId(dto.getEmailId());
		entity.setAddress(dto.getAddress());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setRooms(dto.getRooms());
		entity.setRoomType(dto.getRoomType());
		entity.setNoOfNights(dto.getNoOfNights());
		System.out.println("entity" + entity);

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		manager.close();
		return true;
	}

	@Override
	public List<Resort1Entity> viewAll() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("viewAll");
		List<Resort1Entity> list = query.getResultList();
		list.stream().forEach(System.out::println);
		return list;
	}

	@Override
	public Resort1Entity findById(int id) {

		System.out.println("invoking repo find by id method" + id);
		EntityManager manager = factory.createEntityManager();
		Resort1Entity entity2 = manager.find(Resort1Entity.class, id);
		return entity2;
	}

	@Override
	public List<Resort1Entity> findByName(String name) {
		EntityManager manager = factory.createEntityManager();
		Query qry = manager.createNamedQuery("searchName");
		qry.setParameter("nm", name);
		List<Resort1Entity> entity = qry.getResultList();
		System.out.println("find by name repository" + entity);
		return entity;
	}

	@Override
	public List<Resort1Entity> findEmail(String email) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createNamedQuery("findEmail");
		query.setParameter("email", email);
		List<Resort1Entity> entities = query.getResultList();
		System.out.println("find email repo=" + entities);
		return entities;
	}

	@Override
	public boolean deleteById(int id) {
		EntityManager manager = factory.createEntityManager();
		Resort1Entity entity = manager.find(Resort1Entity.class, id);
		if (entity != null) {
			System.out.println("delete repo" + entity);
			manager.getTransaction().begin();
			manager.remove(entity);
			manager.getTransaction().commit();
			manager.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByEmail(String email) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query = manager.createNamedQuery("deleteByEmail");
		query.setParameter("ml", email);
		int row = query.executeUpdate();
		transaction.commit();
		manager.close();
		return row > 0;
	}

	@Override
	public boolean deleteByName(String name) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		Query query=manager.createNamedQuery("deleteByName");
		query.setParameter("name", name);
		int row=query.executeUpdate();
		transaction.commit();
		manager.close();
		return row>0;
	}
}