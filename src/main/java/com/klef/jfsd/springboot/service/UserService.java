package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.UserRepository;
@Service
public interface UserService 
{	 	 
	public String UserRegistration(User user);
	public User checkuserlogin(String uemail, String upwd);
	public String updateUserProfile(User user);
	public User displayUserByID(int id);
	public List<User> displayUsersByHealthConditions(String healthConditions);
	 
	 public static final UserRepository userRepository = null;

	    public default String UserRegistration1(User user) {
	        userRepository.save(user);
	        return "User registered successfully!";
	    }
	 
}
