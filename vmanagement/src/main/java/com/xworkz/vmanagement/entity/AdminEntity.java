package com.xworkz.vmanagement.dto;

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
@Table(name = "admin_portal")
@NamedQuery(name = "findAllEntity", query = "Select et from AdminEntity et")
@NamedQuery(name = "findByEmailAndPassword", query = "Select et from AdminEntity et where et.email=:email and et.password=:password")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotNull
	@Email
	@Column(name = "a_email")
	private String email;
	@Column(name = "a_password")
	@Size(min = 8, message = "Password must be minimum 8 characters")
	private String password;
}
