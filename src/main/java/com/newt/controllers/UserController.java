package com.newt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newt.models.User;
import com.newt.repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

    @PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		userRepository.save(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}    

	@GetMapping("/getUser{id}")
	public ResponseEntity<List<User>> findById(@RequestBody @PathVariable Long id){
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<List<User>> getUsers(){
		return null;
	}


}
