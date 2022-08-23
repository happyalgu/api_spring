package com.happy.api_json.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happy.api_json.repository.UserRepository;
import com.happy.api_json.user.User;



@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/clients")
	public ResponseEntity<List<User>> getUser() {
		List<User> students = userRepository.findAll();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PostMapping("/clients/")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User std = userRepository.save(user);
		return new ResponseEntity<>(std, HttpStatus.OK);
	}

	@PutMapping("/clients/")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		Optional<User> std = userRepository.findById(user.getId());
		User stdUpdated = std.get();
		stdUpdated.setUsername(user.getUsername());
		stdUpdated.setEmail(user.getEmail());
		stdUpdated.setRoles(user.getRoles());
		User studentUpdated = userRepository.save(stdUpdated);
		return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/clients/{id}")
	public ResponseEntity<String> createUser(@PathVariable(name = "id") Long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<>("Client id: "+ id + " deleted successfully", HttpStatus.OK);
	}
}