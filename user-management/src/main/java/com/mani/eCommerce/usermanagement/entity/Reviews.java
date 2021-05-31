package com.mani.eCommerce.usermanagement.entity;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class Reviews {

	private long id;
	private String comment;
	private String reviewed;
	private int rating;
	@JsonIgnore
	private Product product;
}
