package com.mani.eCommerce.productcatlog.controllers;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class Address {

	private long id;
	private String addressLine1;
	private String addressLine2;
	private String pincode;
	private String country;
	@JsonIgnore
	private User user;
}
