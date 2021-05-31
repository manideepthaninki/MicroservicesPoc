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
			System.out.println("4");
			Product product=dbContent.get();

			Reviews review = new Reviews();
			System.out.println("5");
			review.setComment(input.getComment());
			System.out.println("6");
			review.setRating(input.getRating());
			review.setReviewed(input.getReviewed());
			System.out.println("7");
			review.setProduct(product);
			System.out.println("8");
			product.setReviews(Arrays.asList(review));
			System.out.println("9");
			//System.out.println(product);

			productRepo.save(product);
			System.out.println("5");
			return "Review saved Successfully";
		} else
			throw new Exception();
	}

}
