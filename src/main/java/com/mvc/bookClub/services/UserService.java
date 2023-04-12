package com.mvc.bookClub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mvc.bookClub.models.User;
import com.mvc.bookClub.repos.UserRepo;

@Service
public class UserService {
	@Autowired private UserRepo uRepo;
	
	public User register(User user, BindingResult res) {
		
//		Check if passwords are matched
		if(!user.getConfirmPassword().equals(user.getPassword())) {
			res.rejectValue("confirmPassword", "Matches", "The password must match");
		}
//		Check if user already registered 
		Optional<User> optionUser = uRepo.findByEmail(user.getEmail());
		if(optionUser.isPresent()) {
			res.rejectValue("email", "Matches", "This email is already existed");
		}
		
//		Return the user back if validation went ok.
		if(res.hasErrors()) {
			return null;
		} 
		else {
//			Hash the password and then save into the database
			String hashPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashPassword); // <-- save hashed password
			return uRepo.save(user);
		}
	}
	
	public User findById(Long id) {
		return uRepo.findById(id).orElseGet(null);
	}
	
	public User findByEmail(String email) {
//		return uRepo.findByEmail(email).orElse(null);
//		Or user code below
		Optional<User> opUser = uRepo.findByEmail(email);
		return opUser.orElseGet(()->null);
	}
	
	public User updateAndSaveUser(User user) {
		return uRepo.save(user);
	}
	
	public void deleteUserById(Long id) {
		uRepo.deleteById(id);
	}
}
