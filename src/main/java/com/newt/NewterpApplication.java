package com.newt;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class NewterpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewterpApplication.class, args);
	}

	@GetMapping()
	public String index(){
		// Returns the homepage of the front-end application.
		return "index.html";
	}
	
}
