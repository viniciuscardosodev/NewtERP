package com.newt;


import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;

import com.newt.models.Employee;
import com.newt.models.User;


@SpringBootApplication
public class NewterpApplication {

	public static void main(String[] args) {

		UUID id = new UUID(0, 0);
		User user = new User(id, "joao@gmail.com", "senha123");
		Employee em = new Employee(user, "joao", 100.00);

		SpringApplication.run(NewterpApplication.class, args);
	}

	@PostMapping
	public static void crud(){

	}

	
}
