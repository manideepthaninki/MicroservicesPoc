package com.mani.eCommerce.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mani.eCommerce.usermanagement.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
