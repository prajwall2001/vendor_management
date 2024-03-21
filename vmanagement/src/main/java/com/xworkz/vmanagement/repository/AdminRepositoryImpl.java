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

import com.xworkz.vmanagement.dto.AdminEntity;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	@Autowired
	private EntityManagerFactory emf;

//	@Override
//	public List<AdminEntity> findAllEntity() {
//		EntityManager em = emf.createEntityManager();
//		System.out.println("Created EM");
//		EntityTransaction et = em.getTransaction();
//
//		List<AdminEntity> list = new ArrayList<AdminEntity>();
//		try {
//			et.begin();
//			Query query = em.createNamedQuery("findAll");
//
//			list = query.getResultList();
//			et.commit();
//		} catch (PersistenceException pe) {
//			System.out.println("PersistenceException in save:" + pe.getMessage());
//			et.rollback();
//		} finally {
//			System.out.println("Closing resources");
//			em.close();
//			System.out.println("Em closed");
//		}
//		return list;
//	}

	@Override
	public boolean findEmailAndPassword(String email, String password) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		System.out.println("Created EM");

		List<AdminEntity> list = new ArrayList<AdminEntity>();
		try {
			et.begin();
			Query query = em.createNamedQuery("findByEmailAndPassword");
			query.setParameter("email", email);
			query.setParameter("password", password);

			list =  query.getResultList();
			et.commit();
			return true;
		} catch (PersistenceException pe) {
			System.out.println("PersistenceException in save:" + pe.getMessage());
			et.rollback();

		} finally {
			System.out.println("Closing resources");
			em.close();
			System.out.println("Em closed");
		}

		return false;
	}

}
