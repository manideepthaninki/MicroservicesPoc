package com.mani.eCommerce.usermanagement.service;

import java.sql.SQLException;

import com.mani.eCommerce.usermanagement.entity.User;

public interface UserService {

	User addUser(User user) throws SQLException;
	User getUser(Long id) throws Exception;
	
}
