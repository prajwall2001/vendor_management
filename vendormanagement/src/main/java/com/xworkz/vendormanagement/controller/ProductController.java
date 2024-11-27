package com.xworkz.vendormanagement.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xworkz.vendormanagement.dto.ProductDTO;
import com.xworkz.vendormanagement.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveProduct")
	public String showAddProductPage(@Valid ProductDTO dto, Model model) {
		log.info("Invoking showAddProductPage.....");
		boolean save=this.productService.validateAndSave(dto);
		if(save) {
			return "profile";
		}
		return "success";
	}
	
	 @GetMapping("/getproductDetails") 
	 @ResponseBody
		public List<ProductDTO> getProductDetailsByEmail(@RequestParam String email) {
			List<ProductDTO> ProductDetails = productService.getAllProductDetailsByVendorId(email);
			System.err.println(ProductDetails);
			return ProductDetails;
		}
	 
	 @GetMapping("/editProductDetails")
		@ResponseBody
		public ProductDTO updateProductDetails(@RequestParam int id) {
		    ProductDTO productDto = productService.findAllProductEntityById(id);
		    return productDto;
		}
	///update
	@PostMapping("/updateProduct")
	public String updateProductPage(@RequestParam int id, Model model) {
	    try {
	        System.out.println("Id=========================" + id);
	        ProductDTO productDTO = productService.findAllProductEntityById(id);
	        model.addAttribute("productdto", productDTO);
	        return "updateProduct";
	    } catch (EntityNotFoundException e) {
	        model.addAttribute("errorMessage", "Product not found for Id: " + id);
	        return "errorPage"; 
	    }
	}

	
	@PostMapping("/editproductdetailspage")
	public String update(ProductDTO productDto, Model model, int id, HttpSession session) {
		System.out.println("" + id);
		System.out.println("dto============================" + productDto.getId());
		session.setAttribute("id", id);
		System.out.println(id);
		
		boolean update = productService.updateProductById(productDto, productDto.getId());
		if (update) { 
			ProductDTO read = productService.findAllProductEntityById(id);
			model.addAttribute("products", read);
			model.addAttribute("message", "Data updated successfully");
			return "profile";
		} else {
			ProductDTO read = productService.findAllProductEntityById(id);
			model.addAttribute("products", read);
			model.addAttribute("message", "Data not updated successfully");
			return "productupdate";
		}
	}
	

}
