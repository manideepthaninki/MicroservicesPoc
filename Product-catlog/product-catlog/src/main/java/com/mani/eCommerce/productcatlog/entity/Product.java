package com.mani.eCommerce.productcatlog.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String brand;
	private String category;
	private double price;
	private int stockLeft;
	private boolean isAvaliable;
	private int rating;
	
	/*
	 * @OneToMany( cascade = CascadeType.ALL,mappedBy = "product") private
	 * List<ProductFeatures> features;
	 */
	  
	  @OneToMany(cascade =CascadeType.ALL,mappedBy = "product") 
	   private List<Reviews> reviews;
	 
	
}
