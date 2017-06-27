package com.hrd.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrd.model.User;
import com.hrd.services.UserService;

//RestController = @Contoller + @ResponseBody
@Controller
@RequestMapping("/admin")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping("/dashboard")
	public String dashboard(ModelMap model){
		model.addAttribute("DASHBOARD", userService.countGender());
		return "/admin/dashboard";
	}
	
	
	@RequestMapping("/user-ls")
	public String userList(ModelMap model){
		model.addAttribute("USERLIST", userService.findAll());
		return "/admin/user-ls";
	}
	
	@RequestMapping("/detail/{hash_user}")
	public String userDetail(@PathVariable("hash_user") String userHash, ModelMap model){
		model.addAttribute("USERDETAIL", userService.findByUserHast(new User(userHash)));
		return "/admin/user-profile";
	}
	
	@RequestMapping("/user-cu")
	public String userCu(ModelMap model){
		model.addAttribute("USERCU", new User());
		return "/admin/user-cu";
	}
	
	@PostMapping("/user-c")
	public String user(@ModelAttribute User user, ModelMap model){
		Timestamp tstm = new Timestamp(System.currentTimeMillis());
		String username = user.getUsername();
		String email = user.getEmail();
		String gender = user.getGender();
		String phonenumber = user.getPhoneNumber();
		userService.save(new User(0, username, email, gender, phonenumber,"t","lolololo", tstm));
		return "redirect:/admin/user-ls";
	}

	
	
	@RequestMapping("/delete/{user_hash}")
	public String delete(@PathVariable("user_hash") String userHash){
		userService.deleteByUserHash(userHash);
		return "redirect:/admin/user-ls"; 
	}
	
	
	@RequestMapping("/update/{user_hash}")
	public String userUpdate(@PathVariable("user_hash") String userHash, ModelMap model){
		List<User> users = userService.findByUserHast(new User(userHash));	
		User user = users.get(0);
		model.addAttribute("USERUPDATE", user);
		return "/admin/user-update";
	}
	
	@PostMapping("/user-updated/{user_hash}")
	public String user2(@PathVariable("user_hash") String userHash, @ModelAttribute User user2, ModelMap model){
		Timestamp tstm = new Timestamp(System.currentTimeMillis());
		String username = user2.getUsername();
		String email = user2.getEmail();
		String gender = user2.getGender();
		String phonenumber = user2.getPhoneNumber();
		userService.updateByUserHash(new User(0, username, email, gender, phonenumber,"t",userHash, tstm));
		return "redirect:/admin/user-ls"; 
	}
	
	
}
