package com.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.Person;
import com.crud.Repository.PersonRepository;

@Service
public class PersonService 
{
	@Autowired
	 private PersonRepository  personRepository;
	 
	 public Person updateUser(int id,Person person)
	 {
		 Person data=personRepository.findById(id).orElse(null);
		 
		 if(data!=null) {
		 
		return personRepository.save(person);
		 }
		 
		 return data;
		 
	 }
	 public Person deleteData(int id,Person person) {
		 Person data=personRepository.findById(id).orElse(null);
		 if(data!=null) {
			 personRepository.deleteById(id);
		 }
		 return data;
	 }
	 

}
