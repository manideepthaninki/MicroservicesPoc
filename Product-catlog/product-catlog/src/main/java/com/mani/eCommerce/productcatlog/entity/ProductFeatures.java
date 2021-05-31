package com.mani.eCommerce.productcatlog.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "product_features")
@ToString
public class ProductFeatures {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
private String featues;
private String colour;

/*
 * @ManyToOne(fetch = FetchType.LAZY) private Product product;
 */
	
}
