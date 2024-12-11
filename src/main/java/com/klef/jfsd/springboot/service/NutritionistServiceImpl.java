package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Nutritionist;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.NutritionistRepository;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class NutritionistServiceImpl implements NutritionistService 
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NutritionistRepository nutritionistRepository;

    
    public Nutritionist authenticate(String email, String password) 
    {
        Nutritionist nutritionist = nutritionistRepository.findByEmail(email);
        if (nutritionist != null && nutritionist.getPassword().equals(password)) {
            return nutritionist;
        }
        return null;
    }

    @Override
    public User getUserDetails(int uid) 
    {
        // Retrieve user details based on their ID
        return userRepository.findById(uid).orElse(null);
    }

    @Override
    public String analyzeUserHealth(User user) 
    {
        // Placeholder for analyzing the user's health. This could involve complex logic.
        String healthStatus = "Health Analysis: User seems to have a balanced diet. Continue monitoring.";
        user.setHealthConditions(healthStatus);
        userRepository.save(user);
        return healthStatus;
    }

    @Override
    public String saveBlogContent(int id, String blogContent) 
    {
        // Fetch the nutritionist by ID
        Optional<Nutritionist> optionalNutritionist = nutritionistRepository.findById(id);

        if (optionalNutritionist.isPresent()) {
            Nutritionist nutritionist = optionalNutritionist.get();
            nutritionist.getBlogs().add(blogContent);  // Assuming nutritionist has a list of blog content
            nutritionistRepository.save(nutritionist);
            return "Blog content saved successfully";
        } else {
            return "Nutritionist not found";
        }
    }


    @Override
    public void sendHealthAlert(int uid, String alert)
    {
        // Send a health alert to the user (via email, SMS, or other notification)
        User user = userRepository.findById(uid).orElse(null);
        if (user != null) {
            // Logic for sending alert to the user (e.g., email or notification)
            user.setHealthConditions(alert);  // Assuming `User` has a `health conditions` field
            userRepository.save(user);
        }
    }

    @Override
    public String updateUserHealth(int uid, String healthStatus) 
    {
        // Update the user's health status
        User user = userRepository.findById(uid).orElse(null);
        if (user != null) {
            user.setHealthConditions(healthStatus);
            userRepository.save(user);
            return "User health status updated successfully";
        }
        return "User not found";
    }

    @Override
    public List<User> getAssignedUsers(int nid) {
        // Fetch all users assigned to a specific nutritionist by nutritionistId
        return userRepository.findByNutritionistId(nid);
    }

	@Override
	public String addnutritionist(Nutritionist nutritionist) {
		nutritionistRepository.save(nutritionist);
		return "Nutritionist Added Successfully";
	}

	@Override
	public List<Nutritionist> getAllNutritionists() 
	{
		return nutritionistRepository.findAll();
	}

	@Override
	public void deleteNutritionist(int id) 
	{
		if (nutritionistRepository.existsById(id)) {
            nutritionistRepository.deleteById(id);  // Delete nutritionist by id
        }
		
	}

}
