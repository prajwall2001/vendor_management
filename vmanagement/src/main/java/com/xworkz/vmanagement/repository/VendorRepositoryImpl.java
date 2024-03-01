package com.xworkz.vmanagement.repository;

import java.time.LocalDateTime;
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
			Query query = em.createNamedQuery("isExistNameContactNoEmailWebsite");
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
	public List<VendorEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		List<VendorEntity> list = new ArrayList<VendorEntity>();
		try {
			Query query = em.createNamedQuery("findAll");

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
	public void updatedOtpByEmail(String email, String otp) {
		System.out.println("Invoking the updatedOtpByEmail");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			Query query = em.createNamedQuery("updatedOtpByEmail");
			query.setParameter("email", email);
			Object obj = query.getSingleResult();
			VendorEntity entity = (VendorEntity) obj;
			if (entity != null) {
				entity.setOtp(otp);
				entity.setOtpGenratedTime(LocalDateTime.now());
				em.merge(entity);
				et.commit();
				System.out.println("UpdatedOtpByEMail is updated");
			}
		} catch (PersistenceException e) {
			et.rollback();
			System.out.println("PersistenceException in updateOtpByEmail " + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
	}

	@Override
	public VendorEntity isExistByEmailOtp(String email, String otp) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Created EM");
		VendorEntity entity = null;
		try {
			Query query = em.createNamedQuery("isExistByEmailOtp");
			query.setParameter("em", email);
			query.setParameter("ot", otp);
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
