package com.mani.eCommerce.productcatlog.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.eCommerce.productcatlog.entity.Product;
import com.mani.eCommerce.productcatlog.entity.Reviews;
import com.mani.eCommerce.productcatlog.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product createProduct(Product input) throws Exception {

		Product product = new Product();
		product.setName(input.getName());
		product.setBrand(input.getBrand());
		product.setCategory(input.getCategory());
		product.setPrice(input.getPrice());
		product.setAvaliable(Boolean.FALSE);
		return productRepo.save(product);
	}

	@Override
	public String addreview(Long productId, Reviews input) throws Exception {

		Optional<Product> dbContent = productRepo.findById(productId);
		if (dbContent.isPresent()) {
			Product product=dbContent.get();

			Reviews review = new Reviews();
			review.setComment(input.getComment());
			review.setRating(input.getRating());
			review.setReviewed(input.getReviewed());
			review.setProduct(product);
			product.setReviews(Arrays.asList(review));
			productRepo.save(product);
			return "Review saved Successfully";
		} else
			throw new Exception();
	}

}
