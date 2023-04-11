package com.mvc.bookClub.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.bookClub.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll(); // Might not be using
	
	Optional<User> findByEmail(String email);
}
