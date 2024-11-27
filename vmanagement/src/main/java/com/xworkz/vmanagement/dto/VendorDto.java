package com.xworkz.vmanagement.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class VendorDto {

	private int id;
	@NotNull
	@Size(min = 3, max = 30, message = "Name must be between 3-30 characters")
	private String name;
	@NotNull
	@Size(min = 3, max = 30, message = "Location must be between 3-30 characters")
	private String location;
	@NotNull
	@Size(min = 3, max = 30, message = "GstNo must be between 3-30 characters")
	private String gstNo;
	private Date companyStartDate;
	@NotNull
	@Size(min = 3, max = 30, message = "OwnerName must be between 3-30 characters")
	private String ownerName;
	@NotNull(message = "ServiceType should not be null")
	@Size(min = 3, max = 30, message = "ServiceType should not be null")
	private String serviceType;
	@NotNull
	private Long contactNo;
	@NotNull
	private Long alternativeNo;
	@NotNull
	@Email
	private String email;
	@NotNull
	@Size(min = 3, message = "Website link must be min 300 characters")
	private String website;
	private String createdBy;
	private LocalDate createdDate;
	private String updatedBy;
	private LocalDate updatedDate;
	private String otp;
	private LocalDateTime otpGenratedTime;
	private String status;
}
