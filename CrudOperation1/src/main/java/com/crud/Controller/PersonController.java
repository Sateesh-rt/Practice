package com.crud.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Person;
import com.crud.Repository.PersonRepository;
import com.crud.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	@Autowired
	public PersonRepository repository;
	
	@Autowired
	private PersonService personService;
	
	
	
	@PostMapping("/add")
	public String addUser(@RequestBody Person person) {
		 repository.save(person);
		 return "Data Added";
		
	}
	@GetMapping("/get")
	public List<Person> getUser(){
		return repository.findAll();
	}
	@PutMapping("/update/{id}")
	public Person update(@PathVariable int id,@RequestBody Person person) {
		return personService.updateUser(id, person);
}
	@DeleteMapping("/delete/{id}")
	public Person delete(@PathVariable int id, @RequestBody Person person) {
		return  personService.deleteData(id, person);
		 
	}
}
