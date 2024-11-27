package com.xworkz.vendormanagement.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.xworkz.vendormanagement.dto.OrderDTO;
import com.xworkz.vendormanagement.dto.ProductDTO;
import com.xworkz.vendormanagement.dto.VendorDTO;
import com.xworkz.vendormanagement.entity.VendorEntity;
import com.xworkz.vendormanagement.service.OrderService;
import com.xworkz.vendormanagement.service.ProductService;
import com.xworkz.vendormanagement.service.VendorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequestMapping("/")
@Controller
public class VendorController {

	public VendorController() {
		log.info("Invoking RegistrationController....");

	}

	@Autowired
	private VendorService service;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/info")
	public String clicking() {
		log.info("Invoking clicking()....");
		return "index";
	}

	@PostMapping("/vendorRegister")
	public String save(@Valid VendorDTO dto, BindingResult errors, Model model) {
		log.info("Invoking save");
		log.info("Is VendorEntity is valid:" + errors.hasErrors());

		model.addAttribute("dto", dto);
		if (errors.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(e -> System.err.println(e.getObjectName() + ":meassage " + e.getDefaultMessage()));
			model.addAttribute("errors", objectErrors);
			return "register";
		} else {
			String uniqueError = service.isExistByGstNoContactNoEmailWebsite(dto.getGstNo(), dto.getContactNo(),
					dto.getEmail(), dto.getWebsite());
			if (uniqueError != null) {
				model.addAttribute("uniqueError", uniqueError);
				return "register";
			} else {
				model.addAttribute("msg", "Vendor information saved successfully");

			}

			this.service.validateAndSave(dto);
			// this.service.sendEmail(dto.getEmail(),dto.getOwnerName());
			return "login";
		}
	}

	@GetMapping(value = "/saveLoginOtp/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email, Model model) {
		log.info("emailId=================" + email);
		boolean saveOTP = service.saveOtpByLoginEmailID(email);
		if (saveOTP) {
			model.addAttribute("message", "OTP sent To your register mail id");
			log.info("saveOTP===" + saveOTP);
			return "saveOTP";

		} else {
			return "OTP NOT SAVE";
		}
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, String otp, Model model, HttpSession session) {

		log.info("this is login method");
		session.setAttribute("email", email);
		String login = service.validateLoginOTP(email, otp);
		if (login.equalsIgnoreCase("OTP validated")) {
			
//			List<ProductDTO> allProducts = productService.getAllProductsOfLoginVendor(0);
//			if (allProducts != null) {
//				model.addAttribute("products", allProducts);
//			}
			return "profile";
		} else if (login.equalsIgnoreCase("OTP expired")) {
			model.addAttribute("message1", "OTP expired");
			return "login";
		}
		model.addAttribute("message1", "OTP invalid");
		return "login";
	}

	@GetMapping("/display")
	public void displayUserImageByEmail(HttpServletResponse response, @RequestParam String email, HttpSession session)
			throws IOException {
		session.setAttribute("email", email);
		String imagePath = service.findImagePathByEmail(email);
		System.out.println("=================================");
		System.err.println("imagePath========================" + imagePath);
		File file = new File("D:\\vendorImage\\" + imagePath);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();

	}
	
	@GetMapping("/editprofilepage")
	public String editProfilePage(@RequestParam String email, Model model) {
		System.out.println("email=========================" + email);
		VendorDTO dto = service.findAllVendorEntityByEmail(email);
		model.addAttribute("read", dto);
		return "updateVendor";
	}
	
	
	@PostMapping("/editprofile")
	public String update(VendorDTO dto, Model model, String email, HttpSession session) {
		System.out.println("" + email);
		System.out.println("dto============================" + dto.getEmail());
		session.setAttribute("email", email);
		System.out.println(email);
		if (email == null) {
			return "redirect:/login"; 
		}
		VendorDTO update = service.updateVendorEntityByEmail(dto, dto.getEmail()); 
		System.out.println("----------------------------------"+update);
		if (update != null && update.getEmail() != null) { 
			VendorDTO read = service.findAllVendorEntityByEmail(update.getEmail());
			model.addAttribute("readSave", read);
			model.addAttribute("message", "Data updated successfully");
			return "updateVendor";
		} else {
			VendorDTO read = service.findAllVendorEntityByEmail(email); 
			model.addAttribute("readSave", read);
			model.addAttribute("message", "Data not updated successfully");
			return "profile";
		}
	}
	
	
	//view all  orders
	@GetMapping("/getAllOrders")
	@ResponseBody
	public ResponseEntity<List<OrderDTO>> readProduct(@RequestParam String email,Model model) {
		System.err.println("email============================"+email);
		List<OrderDTO> orderDetails=orderService.getAllOrdersByEmail(email);
		System.out.println("orderDetails this is controller----"+orderDetails);
		if(orderDetails!=null) {
		return ResponseEntity.ok(orderDetails);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}
	
	@PostMapping("/updateOrderStatus")
	@ResponseBody
	public ResponseEntity<String> updateOrderStatus(@RequestParam int id, @RequestParam String status) {
	    System.out.println("Order ID: " + id);
	    System.out.println("New Status: " + status);

	    boolean update = orderService.getOrderStatusById(status, id);
	    if (update) {
	        System.out.println("Update Successful");
	        // Return a success response with HTTP status code 200 (OK)
	        return ResponseEntity.ok("Order status updated successfully");
	    } else {
	        // If update failed, return an error response with HTTP status code 500 (Internal Server Error)
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update order status");
	    }
	}



}
