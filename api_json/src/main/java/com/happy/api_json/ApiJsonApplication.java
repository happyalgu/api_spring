package com.happy.api_json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.happy.api_json.user.Role;
import com.happy.api_json.user.ERole;
import com.happy.api_json.repository.UserRepository;

@SpringBootApplication
public class ApiJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiJsonApplication.class, args);
	}
	
	}