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

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Nutritionist;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.NutritionistService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController 
{
    @Autowired
    private AdminService adminService;

    @Autowired
    private NutritionistService nutritionistService; // Add service for nutritionists

    @GetMapping("adminlogin")
    public ModelAndView adminlogin() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminlogin");
        return mv;
    }

    @GetMapping("adminhome")
    public ModelAndView adminhome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminhome");
        return mv;
    }

    @PostMapping("checkadminlogin")
    public ModelAndView checkadminlogin(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String auname = request.getParameter("auname");
        String apwd = request.getParameter("apwd");

        Admin admin = adminService.checkadminlogin(auname, apwd);
        if (admin != null) {
            mv.setViewName("adminhome");
            long count = adminService.usercount();
            mv.addObject("usercount", count);
        } else {
            mv.setViewName("adminloginfail");
            mv.addObject("message", "Login Failed");
        }
        return mv;
    }

    @GetMapping("viewallusers")
    public ModelAndView viewallusers() {
        ModelAndView mv = new ModelAndView();
        List<User> userlist = adminService.ViewAllUsers();
        mv.setViewName("viewallusers");
        mv.addObject("userlist", userlist);
        
        long count = adminService.usercount();
        mv.addObject("usercount", count);
        return mv;
    }

    @GetMapping("deleteuser")
    public ModelAndView deleteUser(@RequestParam("id") int userId) {
        ModelAndView mv = new ModelAndView();
        String message = adminService.deleteuser(userId);
        if (message.contains("success")) {
            mv.setViewName("deletesuccess");
            mv.addObject("message", message);
        } else {
            mv.setViewName("deletefailure");
            mv.addObject("message", message);
        }
        return mv;
    }

    @GetMapping("updateuserstatus")
    public ModelAndView updateuserstatus() {
        ModelAndView mv = new ModelAndView();
        List<User> userlist = adminService.ViewAllUsers();
        mv.setViewName("updateuserstatus");
        mv.addObject("userlist", userlist);
        return mv;
    }

    @GetMapping("updatestatus")
    public String updatestatus(@RequestParam("id") int uid, @RequestParam("status") String status) {
        adminService.updateuserstatus(status, uid);
        return "redirect:/updateuserstatus";
    }

    @GetMapping("delete")
    public String deleteoperation(@RequestParam("id") int uid) {
        adminService.deleteuser(uid);
        return "redirect:/deleteuser";
    }

    @GetMapping("adminlogout")
    public ModelAndView adminlogout() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminlogin");
        return mv;
    }

    // GET method for displaying the Add Nutritionist form
    @GetMapping("addnutritionist")
    public String addNutritionistForm(Model model) {
        model.addAttribute("nutritionist", new Nutritionist());  // Add a new Nutritionist object to the model
        return "addnutritionist";  // Name of the JSP file (addnutritionist.jsp)
    }

    // POST method for handling the form submission
    @PostMapping("addnutritionist")
    public String addNutritionist(@ModelAttribute("nutritionist") Nutritionist nutritionist, Model model) {
        // Call the service method to add the nutritionist
        String message = nutritionistService.addnutritionist(nutritionist);
        model.addAttribute("message", message);  // Add a message to be displayed in the view
        return "redirect:/adminhome";  // Redirect to a page after adding the nutritionist (could be the admin home page or a list of nutritionists)
    }
    
    @GetMapping("viewallnutritionists")
    public ModelAndView viewAllNutritionists() 
    {
        List<Nutritionist> nutritionists = nutritionistService.getAllNutritionists();
        ModelAndView mv = new ModelAndView("viewallnutritionists");
        mv.addObject("nutritionistList", nutritionists);
        mv.addObject("nutritionistCount", nutritionists.size());
        return mv;
    }

    
    @GetMapping("deletenutritionist")
    public String deleteNutritionist(@RequestParam("id") int id) 
    {
        nutritionistService.deleteNutritionist(id);  // Your service logic for deletion
        return "redirect:/viewallnutritientists";  // Redirect back to the list
    }

}
