package com.mani.eCommerce.usermanagement.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	private long id;
	private String name;
	private String brand;
	private String category;
	private double price;
	private int stockLeft;
	private boolean isAvaliable;
	private int rating;
	private List<Reviews> reviews;
}
