package com.mani.eCommerce.productcatlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mani.eCommerce.productcatlog.entity.Product;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
