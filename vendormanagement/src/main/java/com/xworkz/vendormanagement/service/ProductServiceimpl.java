package com.xworkz.vendormanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.vendormanagement.dto.ProductDTO;
import com.xworkz.vendormanagement.entity.ProductEntity;
import com.xworkz.vendormanagement.entity.VendorEntity;
import com.xworkz.vendormanagement.repository.ProductRepository;
import com.xworkz.vendormanagement.repository.VendorRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceimpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private VendorRepository vendorRepository;

	public ProductServiceimpl() {
		log.info("Invoking AddProductService");
	}

	@Override
	public boolean validateAndSave(ProductDTO addProductDTO) {
		log.info("Invoking validateAndSave....");
		ProductEntity entity = new ProductEntity();
		VendorEntity vendorEntity = vendorRepository.findAllVendorEntityByEmail(addProductDTO.getEmail());

		if (vendorEntity == null) {
			log.error("Vendor entity not found for email: {}", addProductDTO.getEmail());
			return false;
		}

		addProductDTO.setVendor(vendorEntity);
		BeanUtils.copyProperties(addProductDTO, entity);

		boolean save = this.productRepository.save(entity);
		if (save) {
			return true;
		}

		return false;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		log.info("Invoking getAllProducts.....");
		ProductEntity entity = new ProductEntity();
		List<ProductEntity> productsEntity = productRepository.readAll();
		List<ProductDTO> readAll = new ArrayList<ProductDTO>();

		for (ProductEntity addProductEntity : productsEntity) {
			ProductDTO dto = new ProductDTO();
			dto.setId(addProductEntity.getId());
			dto.setCategory(addProductEntity.getCategory());
			dto.setProductName(addProductEntity.getProductName());
			dto.setProductPrice(addProductEntity.getProductPrice());
			dto.setDeliveryCharge(addProductEntity.getDeliveryCharge());
			dto.setDescription(addProductEntity.getDescription());
			dto.setAvailable(addProductEntity.getAvailable());
			dto.setVendor(addProductEntity.getVendor());
			
			readAll.add(dto);
		}
		return readAll;

	}

	@Override
	public List<ProductDTO> getAllProductDetailsByVendorId(String email) {

		int vendorId = vendorRepository.getVendorIdByEmail(email);

		List<ProductEntity> readAll = productRepository.getAllProductDetailsByVendorId(vendorId);
		List<ProductDTO> readAllProducts = new ArrayList<ProductDTO>();
		for (ProductEntity productEntity : readAll) {
			ProductDTO ProductDTO = new ProductDTO();
			BeanUtils.copyProperties(productEntity, ProductDTO);
			readAllProducts.add(ProductDTO);
		}
		return readAllProducts;
	}

	@Override
	public boolean updateProductById(ProductDTO productDTO, int id) {
	    if (productDTO == null) {
	        throw new IllegalArgumentException("ProductDTO cannot be null");
	    }
	    ProductEntity productEntity = productRepository.getAllProductsById(id);
	    if (productEntity != null) {
	        productEntity.setId(productDTO.getId());
	        productEntity.setCategory(productDTO.getCategory());
	        productEntity.setProductName(productDTO.getProductName());
	        productEntity.setProductPrice(productDTO.getProductPrice());
	        productEntity.setDeliveryCharge(productDTO.getDeliveryCharge());
	        productEntity.setDescription(productDTO.getDescription());
	        productEntity.setAvailable(productDTO.getAvailable());

	        // Assuming repo.updateById() method handles both update and save
	        boolean update = productRepository.updateProductDetailsById(productEntity, productEntity.getId());
	        if (update) {
	            System.out.println("Updated successfully");
	            return true;
	        } else {
	            throw new RuntimeException("Update failed");
	        }
	    } 
	        return false; 	    
	}

	@Override
	public ProductDTO findAllProductEntityById(int id) {
	    ProductDTO productDTO = new ProductDTO();
	    ProductEntity entity = productRepository.getAllProductsById(id);
	    if (entity != null) {
	        productDTO.setId(entity.getId());
	        productDTO.setCategory(entity.getCategory());
	        productDTO.setProductName(entity.getProductName());
	        productDTO.setProductPrice(entity.getProductPrice());
	        productDTO.setDeliveryCharge(entity.getDeliveryCharge());
	        productDTO.setDescription(entity.getDescription());
	        productDTO.setAvailable(entity.getAvailable());
	    } else {
	        throw new EntityNotFoundException("Product not found for Id: " + id);
	    }
	    return productDTO;
	}
	
	
	@Override
	public List<ProductDTO> getAllProductsOfLoginVendor(int vendor_id) {
	    log.info("Invoking getAllProducts for vendor id: " + vendor_id);
	    List<ProductEntity> productsEntity = productRepository.getAllProductDetailsByVendorId(vendor_id);
	    List<ProductDTO> readAll = new ArrayList<>();

	    for (ProductEntity addProductEntity : productsEntity) {
	        ProductDTO dto = new ProductDTO();
	        dto.setId(addProductEntity.getId());
	        dto.setCategory(addProductEntity.getCategory());
	        dto.setProductName(addProductEntity.getProductName());
	        dto.setProductPrice(addProductEntity.getProductPrice());
	        dto.setDeliveryCharge(addProductEntity.getDeliveryCharge());
	        dto.setDescription(addProductEntity.getDescription());
	        dto.setAvailable(addProductEntity.getAvailable());
	        dto.setVendor(addProductEntity.getVendor());
	        
	        readAll.add(dto);
	    }
	    System.out.println("Login vendors========="+readAll);
	    return readAll;
	}
	
	

}
