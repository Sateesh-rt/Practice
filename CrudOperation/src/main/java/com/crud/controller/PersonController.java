package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Person;
import com.crud.Repository.PersonRepository;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	@Autowired 
	public PersonRepository personrepository;
//	@PostMapping("/add")
//	public Person addData(@RequestBody Person person) {
//		return personservice.saveUser(person);
//	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody Person person)
	{
		personrepository.save(person);
		System.out.println(person);
		return "Data Added";
	}
	
	
	
	

}
