package com.xworkz.vmanagement.repository;

import java.util.ArrayList;
import java.util.List;

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
	public VendorEntity isExist(String gstNo, Long contactNo, String email, String website) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		VendorEntity entity = null;
		try {
			Query query = em.createNamedQuery("isExistNameEmailWebsite");
			query.setParameter("gn", gstNo);
			query.setParameter("cn", contactNo);
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



	@Override
	public List<String> findAllByGstNo(String gstNo) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<String> list = new ArrayList<String>();

		try {
			Query query = em.createNamedQuery("findAllByGstNo");

			list = query.getResultList();
			

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return list;
	}
	
	
	@Override
	public List<String> findAllByContactNo(Long contactNo) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<String> lists = new ArrayList<String>();

		try {
			Query query = em.createNamedQuery("findAllByContactNo");

			lists = query.getResultList();
			System.out.println(lists);

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return lists;
	}
	
	
	@Override
	public List<String> findAllByAlternativeNo(Long alternativeNo) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<String> lists = new ArrayList<String>();

		try {
			Query query = em.createNamedQuery("findAllByAlternativeNo");

			lists = query.getResultList();
			System.out.println(lists);

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return lists;
	}
	@Override
	public List<String> findAllByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<String> list = new ArrayList<String>();

		try {
			Query query = em.createNamedQuery("findAllByEmail");

			list = query.getResultList();
			

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return list;
	}
	@Override
	public List<String> findAllByWebsite(String website) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<String> list = new ArrayList<String>();

		try {
			Query query = em.createNamedQuery("findAllByWebsite");

			list = query.getResultList();
			

		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}
		return list;
	}
}
