package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Nutritionist;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.service.NutritionistService;

@Controller
public class NutritionistController 
{
    @Autowired
    private NutritionistService nutritionistService;
    
    @GetMapping("nutritionistlogin")
    public ModelAndView nutritionistlogin() {
        ModelAndView mv = new ModelAndView("nutritionistlogin");  // JSP page to be rendered
        mv.addObject("nutritionistlogin", new Nutritionist());  // Add an empty User object to the model
        return mv;
    }
    
    @GetMapping("nutritionisthome")
    public ModelAndView nutritionisthome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nutritionisthome");
        return mv;
    }
    
    @PostMapping("nutritionistlogin")
    public String nutritionistLogin(@RequestParam String email, @RequestParam String password, Model model) {
        Nutritionist nutritionist = nutritionistService.authenticate(email, password);

        if (nutritionist != null) {
            // Login successful, redirect to dashboard
            return "redirect:/nutritionisthome";
        } else {
            // Login failed, show error
            model.addAttribute("error", "Invalid email or password");
            return "nutritionistlogin";
        }
    }
    
    @GetMapping("viewassignedusers")
    public ModelAndView viewAssignedUsers(@RequestParam("nid") int nid) 
    {
        ModelAndView mv = new ModelAndView("viewassignedusers");
        List<User> userList = nutritionistService.getAssignedUsers(nid);
        mv.addObject("userList", userList);
        return mv;
    }
    
    @GetMapping("analyzeuser")
    public ModelAndView analyzeUser(@RequestParam("uid") int uid) 
    {
        ModelAndView mv = new ModelAndView("analyzeuser");
        User user = nutritionistService.getUserDetails(uid);
        String recommendation = nutritionistService.analyzeUserHealth(user);
        mv.addObject("user", user);
        mv.addObject("recommendation", recommendation);
        return mv;
    }

    @GetMapping("createblog")
    public ModelAndView createBlog() 
    {
        ModelAndView mv = new ModelAndView("createblog");
        mv.addObject("nutritionist", new Nutritionist());
        return mv;
    }

    @PostMapping("submitblog")
    public ModelAndView submitBlog(@ModelAttribute("nutritionist") Nutritionist n, @RequestParam("blogContent") String blogContent) 
    {
        String msg = nutritionistService.saveBlogContent(n.getId(), blogContent);
        ModelAndView mv = new ModelAndView("blogsuccess");
        mv.addObject("message", msg);
        return mv;
    }

    @GetMapping("sendhealthalerts")
    public ModelAndView sendHealthAlerts(@RequestParam("uid") int uid, @RequestParam("alert") String alert) 
    {
        nutritionistService.sendHealthAlert(uid, alert);
        return new ModelAndView("alertsuccess");
    }

    @PostMapping("updateuserhealth")
    public ModelAndView updateUserHealth(@RequestParam("uid") int uid, @RequestParam("healthStatus") String healthStatus) 
    {
        String msg = nutritionistService.updateUserHealth(uid, healthStatus);
        ModelAndView mv = new ModelAndView("updatehealthsuccess");
        mv.addObject("message", msg);
        return mv;
    }
}
