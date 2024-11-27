package com.xworkz.vendormanagement.service;

import java.util.List;

import com.xworkz.vendormanagement.dto.OrderDTO;

public interface OrderService {
    boolean validateAndSave(OrderDTO orderDTO);
	
	List<OrderDTO> getAllOrdersByVendorId(int vendor_id);
	
	List<OrderDTO> getAllOrdersByEmail(String email);
	
	public boolean getOrderStatusById(String orderStatus, int id) ;
	
}
