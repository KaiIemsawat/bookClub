package com.mvc.bookClub.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.bookClub.models.User;
import com.mvc.bookClub.services.UserService;

@Controller
public class MainController {
	
	@Autowired private UserService uServ;
	
//	Login and register page
	@GetMapping("/")
	public String homePage(@ModelAttribute("registerUser") User user) {
		
		return "reglog";
	}
	
	
//	Welcome page
	@GetMapping("/welcome")
	public String welcomePage() {

		
		return null;
	}
	
//	Register if valid
	@PostMapping("/welcome")
	public String register(
			@Valid @ModelAttribute("registerUser") User user
			, BindingResult res
			) {
//		If there is any error 
		if(res.hasErrors()) {
			return "reglog";
		}
		return null;
	}
	
//	Login user if valid
	@PostMapping("/login")
	public String loginUser() {
		return null;
	}
	
//	logout by clear session / return to login/register page
	@GetMapping() 
	public String logout() {
		return null;	
	}
	
}
