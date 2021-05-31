package com.mani.eCommerce.productcatlog.services;

import org.springframework.stereotype.Service;

import com.mani.eCommerce.productcatlog.entity.Product;
import com.mani.eCommerce.productcatlog.entity.Reviews;


public interface ProductService {

	Product createProduct(Product product) throws Exception;

	String addreview(Long parseLong, Reviews input) throws Exception;
	
}
