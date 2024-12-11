package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Nutritionist;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.NutritionistRepository;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService 
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private NutritionistRepository nutritionistRepository;

    @Override
    public List<User> ViewAllUsers() 
    {
        return userRepository.findAll();  // Retrieve all users from the repository
    }

    @Override
    public Admin checkadminlogin(String uname, String pwd) 
    {
        return adminRepository.checkadminlogin(uname, pwd); 
    }

    @Override
    public long usercount() 
    {
        return userRepository.count();  // Return the count of all users
    }

    @Override
    public User displayUserById(int userId) 
    {
    	return userRepository.findById(userId).get();
    }

    @Override
    public String updateuserstatus(String status, int uid) 
    {
    	 userRepository.updateUserStatus(status, uid);
		 return "User Status Updated Successfully";
    }

    @Override
    public String deleteuser(int uid) 
    {
    	 userRepository.deleteById(uid);
		 return "User Deleted Successfully";
    }


    @Override
    public String addnutritionist(Nutritionist n) 
    {
        Nutritionist existingNutritionist = nutritionistRepository.findByEmail(n.getEmail());
        if (existingNutritionist != null) {
            return "Nutritionist already exists with this email";
        }
        nutritionistRepository.save(n);
        return "Nutritionist Added Successfully";
    }

}
