package com.xworkz.vendormanagement.repository;

import java.util.List;

import javax.persistence.PersistenceException;

import com.xworkz.vendormanagement.entity.OrderEntity;

public interface OrderRepository {
	public boolean save(OrderEntity orderEntity);
	
	List<OrderEntity> viewAllOrders(int vendorId);
	public boolean updateOrderStatusById(String orderStatus, int id) ;
		
}
