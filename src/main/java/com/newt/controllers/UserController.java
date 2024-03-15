package com.newt.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.newt.models.Employee;
import com.newt.models.User;
import com.newt.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

    @PostMapping("/createUser")
	public ResponseEntity<Employee> createUser(@RequestBody User user){
	
		user = new User();
		user.setUsername("joao12@gmail.com");
		user.setPassword("senha123");
		userRepository.save(user);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee emp, User user){
		return emp;
	}


}
