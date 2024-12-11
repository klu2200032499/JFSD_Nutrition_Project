package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String UserRegistration(User user) 
	{
		userRepository.save(user);
		return "User Registered Successfully";
	}

	@Override
	public User checkuserlogin(String uemail, String upwd) 
	{
		return userRepository.checkuserlogin(uemail, upwd);
	}


	@Override
	public User displayUserByID(int id) 
	{
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> displayUsersByHealthConditions(String healthConditions) 
	{
		return userRepository.findUsersByHealthConditions(healthConditions);
	}
	
	@Override
	public String updateUserProfile(User user) 
	{
	    User existingUser = userRepository.findById(user.getId()).orElse(null);
	    if (existingUser != null) {
	        BeanUtils.copyProperties(user, existingUser, "id");  // copy all except id
	        userRepository.save(existingUser);
	        return "User Updated Successfully";
	    } else {
	        return "User not found";
	    }
	}

}
