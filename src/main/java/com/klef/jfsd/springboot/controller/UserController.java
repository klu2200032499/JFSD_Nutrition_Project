package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@GetMapping("about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@GetMapping("userreg")
	public ModelAndView userreg()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userreg");
		return mv;
	}
	
	@GetMapping("userlogin")
    public ModelAndView showUserLoginPage() {
        ModelAndView mv = new ModelAndView("userlogin");  // JSP page to be rendered
        mv.addObject("userlogin", new User());  // Add an empty User object to the model
        return mv;
    }

    // POST method to check user login credentials
    @PostMapping("checkuserlogin")
    public ModelAndView checkUserLogin(@RequestParam("uemail") String uemail, 
                                       @RequestParam("upwd") String upwd, 
                                       HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        
        User user = userService.checkuserlogin(uemail, upwd);
        
        if (user != null) {
            // Login successful
            HttpSession session = request.getSession();
            session.setAttribute("user", user);  // Save user object in session
            mv.setViewName("userhome");  // Redirect to the user home page
            mv.addObject("message", "Login Successful!.");
            System.out.println("Login syccessful !");
        } else {
            // Login failed
            mv.setViewName("userlogin");
            mv.addObject("message", "Login failed. Please check your credentials.");
        }
        return mv;
    }
	
    @PostMapping("insertuser")
    public ModelAndView insertuser(HttpServletRequest request) {
        String name = request.getParameter("uname");
        String password = request.getParameter("upwd");
        String email = request.getParameter("uemail");

        if (name == null || password == null || email == null) {
            ModelAndView mv = new ModelAndView("userreg");
            mv.addObject("message", "All fields are required.");
            return mv;
        }
        else {

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);

        // Assuming you have a service method for user registration
        String msg = userService.UserRegistration(user);

        if (msg.equals("Registration successful")) {
            ModelAndView mv = new ModelAndView("/userhome");
            mv.addObject("message", "Registration success");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("userreg");
            mv.addObject("message", "Registration failed. Please try again.");
            return mv;
        }
        }
    }

    @RequestMapping("/userhome")
    public ModelAndView userHome() {
        ModelAndView mv = new ModelAndView("userhome"); // View name for the user home page
        return mv;
    }

	@GetMapping("userhome")
	public ModelAndView userhome()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userhome");
		return mv;
	}
	
	@GetMapping("userprofile")
	public ModelAndView userprofile()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userprofile");
		return mv;
	}
	
	@GetMapping("updateuser")
	public ModelAndView updateuser()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("updateuser");
		return mv;
	}
	
	@GetMapping("usercontactus")
	public ModelAndView usercontactus()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usercontactus");
		return mv;
	}
	
	@GetMapping("userlogout")
	public ModelAndView userlogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		 
		session.removeAttribute("user");
		//session.invalidate(); - to remove all session attributes
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userlogout");
		return mv;
	}
	
	@PostMapping("updateuserprofile")
	public ModelAndView updateuserprofile(HttpServletRequest request) 
	{
	    ModelAndView mv = new ModelAndView();
	    
	    try 
	    {
	        int id = Integer.parseInt(request.getParameter("uid"));
	        String name = request.getParameter("uname");
	        String gender = request.getParameter("ugender");
	        String dob = request.getParameter("udob");
	        double height = Double.parseDouble(request.getParameter("uheight"));
	        double weight = Double.parseDouble(request.getParameter("uweight"));
	        String activityLevel = request.getParameter("uactivitylevel");
	        String dietaryPreferences = request.getParameter("udietarypreferences");
	        String allergies = request.getParameter("uallergies");
	        String healthConditions = request.getParameter("uhealthconditions");
	        String password = request.getParameter("upwd");
	        String location = request.getParameter("ulocation");
	        String contact = request.getParameter("ucontact");
	        double targetWeight = Double.parseDouble(request.getParameter("utargetweight"));
	        String goal = request.getParameter("ugoal");

	        User user = new User();
	        user.setId(id);
	        user.setName(name);
	        user.setGender(gender);
	        user.setDateOfBirth(dob);
	        user.setHeight(height);
	        user.setWeight(weight);
	        user.setActivityLevel(activityLevel);
	        user.setDietaryPreferences(dietaryPreferences);
	        user.setAllergies(allergies);
	        user.setHealthConditions(healthConditions);
	        user.setPassword(password);
	        user.setLocation(location);
	        user.setContact(contact);
	        user.setTargetWeight(targetWeight);
	        user.setGoal(goal);

	        String msg = userService.updateUserProfile(user);

	        User updatedUser = userService.displayUserByID(id);
	        
	        HttpSession session = request.getSession();
	        session.setAttribute("user", updatedUser); // "user" is the session variable
	        
	        // Set the view for success and add success message
	        mv.setViewName("updatesuccess");
	        mv.addObject("message", msg);
	      
	    } 
	    catch (Exception e) 
	    {
	        // In case of error, set the error view and message
	        mv.setViewName("updateerror");
	        mv.addObject("message", e.getMessage());
	    }
	    return mv;
	}
	
	@GetMapping("usersessionexpiry")
	public ModelAndView usersessionexpiry()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("usersessionexpiry");
		return mv;
	}
	
	@GetMapping("viewusersbyhealthcondition")
	public ModelAndView viewUsersByHealthCondition(HttpServletRequest request) 
	{
	    ModelAndView mv = new ModelAndView("viewusersbyhealthcondition");
	    
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user"); // Assuming "user" is the session object
	    
	    List<User> userList = userService.displayUsersByHealthConditions(user.getHealthConditions());
	    
	    mv.addObject("userList", userList);
	    
	    return mv;
	}

	
}
