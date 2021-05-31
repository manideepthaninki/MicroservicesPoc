package com.mani.eCommerce.usermanagement.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String addressLine1;
	private String addressLine2;
	private String pincode;
	private String country;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
}
