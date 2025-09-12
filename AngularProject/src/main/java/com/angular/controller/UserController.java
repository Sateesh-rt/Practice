package com.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {
	//it provides dummy json object data
	@Autowired
	private UserService userservice;
	
	@GetMapping("/Data")
	public ResponseEntity<String> getAllPosts() {
        return userservice.getDummyUsers();
    }
		
	

}
