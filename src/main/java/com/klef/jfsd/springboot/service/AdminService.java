package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Nutritionist;
import com.klef.jfsd.springboot.model.User;

public interface AdminService 
{	
	public List<User> ViewAllUsers();
	public Admin checkadminlogin(String uname,String pwd);
	public long usercount();
	public User displayUserById(int userId);
	public String updateuserstatus(String status, int uid);
	public String deleteuser(int uid);
	public String addnutritionist(Nutritionist n);
}
