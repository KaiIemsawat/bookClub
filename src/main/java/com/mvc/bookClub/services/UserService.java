package com.mvc.bookClub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.bookClub.repos.UserRepo;

@Service
public class UserService {
	@Autowired private UserRepo uRepo;
}
