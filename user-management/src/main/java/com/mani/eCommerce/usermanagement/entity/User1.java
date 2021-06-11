package com.mani.eCommerce.usermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class User1 {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
private String firstName;
private String lastName;
private String phone;
private String email;
private String password;
private String address;
} 