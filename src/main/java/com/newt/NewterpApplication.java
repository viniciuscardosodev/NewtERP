package com.newt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NewterpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewterpApplication.class, args);
	}

	@GetMapping("/")
	public String homepage(){
		return "index";
	}

}
