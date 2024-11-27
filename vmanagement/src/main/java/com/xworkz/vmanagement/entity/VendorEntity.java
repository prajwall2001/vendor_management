package com.xworkz.vmanagement.entity;

import java.sql.Date;
import java.time.LocalDate;
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

import org.hibernate.loader.entity.CascadeEntityJoinWalker;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "vendor_registration")
@NamedQuery(name = "isExistNameContactNoEmailWebsite", query = "Select ent from VendorEntity as ent where ent.gstNo=:gn   or ent.contactNo=:cn or ent.email=:vm or ent.website=:web")
@NamedQuery(name = "isExistByEmailOtp", query = "Select ent from VendorEntity as ent where ent.email=:email or ent.otp=:otp")
@NamedQuery(name = "updatedOtpByEmail", query = "select ent from VendorEntity ent where ent.email=:email")
@NamedQuery(name = "findAll", query = "Select et from VendorEntity et")
@NamedQuery(name = "findAllOtp", query = "Select otp from VendorEntity et")
@NamedQuery(name = "findByName", query = "Select et from VendorEntity et where et.name=:name")
@NamedQuery(name = "updateStatusById", query = "UPDATE VendorEntity et SET et.status='APPROVED' WHERE et.id = :id")

public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "gst_no")
	private String gstNo;
	@Column(name = "company_start_date")
	private Date companyStartDate;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "service_type")
	private String serviceType;
	@Column(name = "contact_no")
	private Long contactNo;
	@Column(name = "alternative_no")
	private Long alternativeNo;

	@Column(name = "email")
	private String email;

	@Column(name = "website")
	private String website;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	
	@Column(name = "v_otp")
	private String otp;
	
	@Column(name = "v_otpGenrated_time")
	private LocalDateTime otpGenratedTime;
	
	@Column(name = "status")
	private String status;
}
