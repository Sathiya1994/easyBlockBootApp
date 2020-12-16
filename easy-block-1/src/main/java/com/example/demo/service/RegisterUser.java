package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
@Component
public class RegisterUser {

	@Autowired
	UserRepository userRepository;
	
	
	public String registerNewUser(User user) {
		user.setUserId(user.getUsername());
		boolean isUserNotExist =isUserExist(user);
		if(!isUserNotExist) {
		userRepository.save(user);
		}
	return  !isUserNotExist? "saved":"not saved";
	}
	
	public String authenticateUser(User user) {
		User savedUser=	userRepository.findById(user.getUserId()).orElse(new User());
		return savedUser.getUsername().equals("") ? "user not exist" : "authenticate";
	}
	
	private boolean isUserExist(User user) {
		Optional<User>userList = userRepository.findById(user.getUserId());
		return userList.isPresent();
	}
}
