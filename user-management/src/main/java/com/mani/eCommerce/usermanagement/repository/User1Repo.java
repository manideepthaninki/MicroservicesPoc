package com.mani.eCommerce.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mani.eCommerce.usermanagement.entity.User1;

@Repository
public interface User1Repo  extends JpaRepository<User1, Long>{

}
