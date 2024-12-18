package com.xworkz.vendormanagement.repository;

import java.util.List;

import com.xworkz.vendormanagement.entity.ProductEntity;

public interface ProductRepository {
	public boolean save(ProductEntity entity);

	List<ProductEntity> readAll();

	List<ProductEntity> getAllProductDetailsByVendorId(int vendorId);

	// ProductEntity getAllProductDetailsById(int id);

	// update product
	ProductEntity getAllProductsById(int id);

	boolean updateProductDetailsById(ProductEntity productEntity, int id);

}
