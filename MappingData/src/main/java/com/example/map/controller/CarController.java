package com.example.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.map.Entity.Car;
import com.example.map.Repository.Carrepository;

@RestController
@RequestMapping("/api/cars")
public class CarController {
@Autowired
private Carrepository carrepository;

@PutMapping("/update/{id}")
public String update(@PathVariable int id, @RequestBody Car c) {
	Car car=carrepository.findById(id).orElse(null);
	if(car!=null) {
		carrepository.save(c);
		return "updated Succesfully";
	}
	return "id is not found";
	
}
@DeleteMapping("/delete/{id}")
public String delete(@PathVariable int id) {
	Car car=carrepository.findById(id).orElse(null);
	if(car!=null) {
		carrepository.deleteById(id);
		return "Record Deleted Successfully";
		
		
	}
	return "Record is not found";
	
}


}
