package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {

	
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public String saveUser(@RequestBody User user) {
		repository.save(user);
		return "Data Added Successfully";
	}
	@GetMapping("/get")
	public List<User> get() {
		return repository.findAll();
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable Long id ,@RequestBody User u) {
		User user =repository.findById(id).orElse(null);
		if(user!=null) {
			repository.save(u);
			return "User updated";
		}
		return "UserId not found";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		User user=repository.findById(id).orElse(null);
		if(user!=null) {
			repository.deleteById(id);
			return "User is deleted";
		}
		return "UserId not found";
	}
}

