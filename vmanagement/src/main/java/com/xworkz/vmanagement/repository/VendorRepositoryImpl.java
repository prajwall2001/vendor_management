package com.xworkz.vmanagement.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vmanagement.dto.VendorDTO;

@Repository
public class VendorRepositoryImpl implements VendorRepository {

	@Autowired
	private EntityManagerFactory emf;
	
	
	public VendorRepositoryImpl() {
		System.out.println("Invoking VendorRepositoryImpl... ");
	}

	@Override
	public boolean save(VendorDTO dto) {
		System.out.println("Invoking save...");
		System.out.println("DTO Passed:" + dto);
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            System.out.println("Et begin");
            em.persist(dto);
            System.out.println("Persist complete");
            et.commit();
            

        }
        catch(PersistenceException pe){
            System.out.println("PersistenceException in save:"+pe.getMessage());
            et.rollback();
        }
        finally {
            System.out.println("Closing resources");
            em.close();
        }

        return true;
   

	}
}
