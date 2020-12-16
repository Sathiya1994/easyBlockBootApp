package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.RegisterUser;
@CrossOrigin("*")
@RestController
public class EasyBlockController {
	
	@Autowired
	RegisterUser registerUser;
	
	
	@PostMapping("/addUser")
	String addUser(@RequestBody User user) {
		System.out.println("entered");
		return registerUser.registerNewUser(user);
	}
	
	@GetMapping("/authenticateUser")
	String authenticateUser(@RequestBody User user) {
		return registerUser.registerNewUser(user);
	}

}
