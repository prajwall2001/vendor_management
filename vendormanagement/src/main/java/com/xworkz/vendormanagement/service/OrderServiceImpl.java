package com.xworkz.vendormanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendormanagement.dto.OrderDTO;
import com.xworkz.vendormanagement.entity.OrderEntity;
import com.xworkz.vendormanagement.entity.ProductEntity;
import com.xworkz.vendormanagement.repository.OrderRepository;
import com.xworkz.vendormanagement.repository.ProductRepository;
import com.xworkz.vendormanagement.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public boolean validateAndSave(OrderDTO orderDTO) {
		log.info("Invoking validateAndSave....");
		ProductEntity productEntity = productRepository.getAllProductsById(orderDTO.getProductId());
		System.out.println("productEntity=======" + productEntity);

		if (productEntity != null) {
			OrderEntity orderEntity = new OrderEntity();

			orderDTO.setProductName(productEntity.getProductName());
			orderDTO.setCategory(productEntity.getCategory());
			orderDTO.setProductPrice(productEntity.getProductPrice());
			orderDTO.setDeliveryCharge(productEntity.getDeliveryCharge());
			orderDTO.setDescription(productEntity.getDescription());
			orderDTO.setAvailable(productEntity.getAvailable());
			orderDTO.setOrderDate(LocalDateTime.now());
			orderDTO.setVendor(productEntity.getVendor());
			orderDTO.setProduct(productEntity);

			BeanUtils.copyProperties(orderDTO, orderEntity);

			boolean save = orderRepository.save(orderEntity);
			if (save) {
				log.info("Data saved Successfully");
				return true;
			}
		} else {
			log.error("Product details not found for productId: " + orderDTO.getProductId());
		}

		return false;
	}

	@Override
	public List<OrderDTO> getAllOrdersByVendorId(int vendor_id) {
		log.info("Invoking getAllOrders for vendor id: " + vendor_id);
		List<OrderEntity> orderEntities = orderRepository.viewAllOrders(vendor_id);
		List<OrderDTO> readAll = new ArrayList<OrderDTO>();

		for (OrderEntity orderEntity : orderEntities) {
			OrderDTO dto = new OrderDTO();
			dto.setOrderId(orderEntity.getOrderId());
			dto.setCategory(orderEntity.getCategory());
			dto.setProductName(orderEntity.getProductName());
			dto.setProductPrice(orderEntity.getProductPrice());
			dto.setDeliveryCharge(orderEntity.getDeliveryCharge());
			dto.setDescription(orderEntity.getDescription());
			dto.setAvailable(orderEntity.getAvailable());
			dto.setOrderQuantity(orderEntity.getOrderQuantity());
			dto.setOrderDate(orderEntity.getOrderDate());
			dto.setDeliveryDate(orderEntity.getDeliveryDate());  
			
			dto.setDeliveryAddress(orderEntity.getDeliveryAddress());
			dto.setMessage(orderEntity.getMessage());
			dto.setOrderStatus(orderEntity.getOrderStatus());

			dto.setVendor(orderEntity.getVendor());

			readAll.add(dto);
		}
		System.out.println("Service==========" + readAll);
		return readAll;
	}

	@Override
	public List<OrderDTO> getAllOrdersByEmail(String email) {
		log.info("Fetching all orders for vendor with email: {}", email);
		int vendorId = vendorRepository.getVendorIdByEmail(email);
		System.out.println("vendorid++++++" + vendorId);
		List<OrderEntity> orderDetails = orderRepository.viewAllOrders(vendorId);
		System.out.println("orderDetails=========" + orderDetails);
		List<OrderDTO> readAll = new ArrayList<OrderDTO>();
		for (OrderEntity orderEntity : orderDetails) {
			OrderDTO orderDto = new OrderDTO();
			if (orderEntity.getOrderStatus().equalsIgnoreCase("Ordered")) {
				BeanUtils.copyProperties(orderEntity, orderDto);
				readAll.add(orderDto);
			}

		}
		System.out.println("service=======" + readAll);
		return readAll;
	}
	
	@Override
	public boolean getOrderStatusById(String orderStatus, int id) {
	boolean update = orderRepository.updateOrderStatusById(orderStatus, id);
	System.out.println("update=======================");
	if (update) {
		
		System.out.println("updated Successfully==============================");
		return true;
	}
		return false;
	}

}
