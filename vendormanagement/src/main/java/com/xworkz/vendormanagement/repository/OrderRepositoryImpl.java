package com.xworkz.vendormanagement.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.vendormanagement.entity.OrderEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public boolean save(OrderEntity orderEntity) {
		log.info("Invoking save...");
		log.info("OrderEntity Passed:" + orderEntity);
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			log.info("Et begin");
			em.persist(orderEntity);
			log.info("Persist complete");
			et.commit();

		} catch (PersistenceException pe) {
			log.info("PersistenceException in save:" + pe.getMessage());
			et.rollback();
		} finally {
			log.info("Closing resources");
			em.close();
		}

		return true;
	}

	@Override
	public List<OrderEntity> viewAllOrders(int vendorId) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			Query query = entityManager.createNamedQuery("viewAllOrdersByVendorId");
			query.setParameter("vendorId", vendorId);
			List<OrderEntity> read = query.getResultList();
			return read;
		} catch (Exception e) {
		} finally {

		}
		return null;
	}
	
	@Override
	public boolean updateOrderStatusById(String orderStatus, int id) {
		System.out.println("this is status method repo");
		 EntityManager entityManager = emf.createEntityManager();
		    EntityTransaction entityTransaction = entityManager.getTransaction();
		    try {
		        entityTransaction.begin();
		        OrderEntity entity = entityManager.find(OrderEntity.class, id);
		        if (entity != null) {
		            
		            entity.setOrderStatus(orderStatus);
		            entityManager.merge(entity); 
		            entityTransaction.commit(); 
		            return true;
		        } else {
		            
		            return false;
		        }
		    } catch (PersistenceException e) {
		        e.printStackTrace();
		        if (entityTransaction.isActive()) {
		            entityTransaction.rollback();
		        }
		        return false;
		    } finally {
		        entityManager.close();
		    }		
	}
	
}
