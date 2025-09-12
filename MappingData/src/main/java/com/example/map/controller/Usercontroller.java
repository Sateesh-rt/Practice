package com.example.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.map.Entity.User;
import com.example.map.Repository.Userrepository;

@RestController
@RequestMapping("/api/user")
public class Usercontroller {

	@Autowired
	private Userrepository userRepository;
	@PostMapping("/create")
	public User saveUser(@RequestBody User user) {
		return userRepository.save(user);
	}

}
