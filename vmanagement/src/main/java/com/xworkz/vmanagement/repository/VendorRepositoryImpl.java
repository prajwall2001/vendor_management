package com.xworkz.vmanagement.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vmanagement.dto.VendorEntity;

@Repository
public class VendorRepositoryImpl implements VendorRepository {

	@Autowired
	private EntityManagerFactory emf;

	public VendorRepositoryImpl() {
		System.out.println("Invoking VendorRepositoryImpl... ");
	}

	@Override
	public boolean save(VendorEntity entity) {
		System.out.println("Invoking save...");
		System.out.println("Entity Passed:" + entity);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("Et begin");
			em.persist(entity);
			System.out.println("Persist complete");
			et.commit();

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());
			et.rollback();
		} finally {
			System.out.println("Closing resources");
			em.close();
		}

		return true;

	}

	@Override
	public VendorEntity isExist(String name, String email, String website) {

		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		VendorEntity entity = null;
		try {
			Query query = em.createNamedQuery("isExistNameEmailWebsite");
			query.setParameter("vn", name);
			query.setParameter("vm", email);
			query.setParameter("web", website);
			entity = (VendorEntity) query.getSingleResult();

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return entity;
	}
}
