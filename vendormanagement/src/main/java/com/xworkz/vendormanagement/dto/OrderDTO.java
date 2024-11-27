package com.xworkz.vendormanagement.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Id;

import com.xworkz.vendormanagement.entity.ProductEntity;
import com.xworkz.vendormanagement.entity.VendorEntity;

import lombok.Data;

@Data
public class OrderDTO {
	@Id
	private int orderId;
	private int productId;
	private int vendorId;
	private String category;
	private String productName;
	private double productPrice;
	private double deliveryCharge;
	private String description;
	private String available;
	private int orderQuantity;
	private LocalDateTime orderDate;
	private String deliveryDate;
	private String deliveryAddress;
	private String message;
	private  String orderStatus;
	private ProductEntity product;
	private VendorEntity vendor;
	private double orderAmount;
	private double amountPaid;
	private String paymentStatus;
	private double totalAmountToPay;
	private double balanceAmount;
	
}
