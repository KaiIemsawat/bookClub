package com.mvc.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@GetMapping("/welcomePage") // <--- match with PostMapping below and form:form action=""
	public String welcomePage(HttpSession sess, Model model) {
		Long userId = (Long) sess.getAttribute("userId"); // <-- need type casting (Long) // *** Need to use ("thisValue") same as * below  
		model.addAttribute("loggedUser", uServ.findById(userId));
		return "welcomePage";
	}
	
//	Register if valid
	@PostMapping("/register") // <--- match with GetMapping above and form:form action=""
	public String register(
			@Valid @ModelAttribute("registerUser") User user
			, BindingResult res
			, HttpSession sess
			) {
		User newUser = uServ.register(user, res); // <--- call additional validation here
		
//		If there is any error 
		if(res.hasErrors()) {
			return "reglog";
		}
		
//		At this point, user is already registered from register method (in userServices file)
		sess.setAttribute("userId", newUser.getId()); // <-- ("thisValue") needs to be the same as * above
//		direct to welcome 
		return "redirect:/welcomePage";
	}
	
//	Login user if valid
	@PostMapping("/login")
	public String loginUser() {
		return null;
	}
	
//	logout by clear session / return to login/register page
	@GetMapping("/logout") 
	public String logout(HttpSession sess) {
		
		sess.invalidate();
		return "redirect:/";	
	}
	
}
