package com.xworkz.vmanagement.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "vendor_registration")
@NamedQuery(name = "isExistNameContactNoEmailWebsite", query = "Select ent from VendorEntity as ent where ent.gstNo=:gn   or ent.contactNo=:cn or ent.email=:vm or ent.website=:web")
@NamedQuery(name = "isExistByEmailOtp", query = "Select ent from VendorEntity as ent where ent.email=:email or ent.otp=:otp")
@NamedQuery(name="updatedOtpByEmail",query = "select ent from VendorEntity ent where ent.email=:email")
@NamedQuery(name = "findAll", query = "Select et from VendorEntity et")
@NamedQuery(name = "findAllOtp", query = "Select otp from VendorEntity et")

public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private int id;
	@NotNull
	@Size(min = 3, max = 30, message = "Name must be between 3-30 characters")
	@Column(name = "name")
	private String name;
	@NotNull
	@Size(min = 3, max = 30, message = "Location must be between 3-30 characters")
	@Column(name = "location")
	private String location;
	@NotNull
	@Size(min = 3, max = 30, message = "GstNo must be between 3-30 characters")
	@Column(name = "gst_no")
	private String gstNo;
	@Column(name = "company_start_date")
	private Date companyStartDate;
	@NotNull
	@Size(min = 3, max = 30, message = "OwnerName must be between 3-30 characters")
	@Column(name = "owner_name")
	private String ownerName;
	@NotNull(message = "ServiceType should not be null")
	@Size(min = 3, max = 30, message = "ServiceType should not be null")
	@Column(name = "service_type")
	private String serviceType;
	@NotNull
	@Column(name = "contact_no")
	private Long contactNo;
	@NotNull
	@Column(name = "alternative_no")
	private Long alternativeNo;
	@NotNull
	@Email
	@Column(name = "email")
	private String email;
	@NotNull
	@Size(min = 3, message = "Website link must be min 300 characters")
	@Column(name = "website")
	private String website;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_date")
	private Date updatedDate;
	@Column(name = "v_otp")
	private String otp;
	@Column(name = "v_otpGenrated_time")
	private LocalDateTime otpGenratedTime;
}
