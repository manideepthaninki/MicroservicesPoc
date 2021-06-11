package com.mani.eCommerce.usermanagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mani.eCommerce.usermanagement.entity.Address;
import com.mani.eCommerce.usermanagement.entity.User;
import com.mani.eCommerce.usermanagement.entity.User1;
import com.mani.eCommerce.usermanagement.repository.User1Repo;
import com.mani.eCommerce.usermanagement.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
     private UserRepo userRepo;


	@Autowired
     private User1Repo user1Repo;
	@Override
	public User addUser(User input) throws SQLException {


    User user=new User();

     user.setName(input.getName());
     user.setMobileNumber(input.getMobileNumber());
     user.setRole(input.getRole());
     List<Address> adrresses=new ArrayList<>();
     
     input.getAddress().stream().forEach(rec->{
    	
    	 Address address=new Address();
    	 address.setAddressLine1(rec.getAddressLine1());
    	 address.setAddressLine2(rec.getAddressLine2());
    	 address.setCountry(rec.getCountry());
    	 address.setPincode(rec.getPincode());
    	 adrresses.add(address); 
    	 address.setUser(user);
     });
     
     user.setAddress(adrresses);
		
		
     return userRepo.save(user);
	
	}
	
	@Override
	public User getUser(Long id) throws Exception {
		Optional<User> user=userRepo.findById(id);
		user.orElseThrow(()->new Exception("No user Found"));
		
			return user.get();
		
	}

	public User1 saveUser1(User1 user) throws Exception {

		
		User1 dbObj=user1Repo.save(user);
		
		if(dbObj.getId()!=0) {
			return dbObj;
		}
		else throw new Exception("Failed to save");
		
		
	}

	public List<User1> allUser1() throws Exception {

		Optional<List<User1>> users=Optional.of(user1Repo.findAll());
		users.orElseThrow(()-> new Exception("No Users Found"));
		 return users.get();
			
	}



}
