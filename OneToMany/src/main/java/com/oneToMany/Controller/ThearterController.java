package com.oneToMany.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oneToMany.Entity.Theater;
import com.oneToMany.Service.TheaterService;

@RestController
@RequestMapping("/api/theater")
public class ThearterController {

	@Autowired
	private TheaterService service;
	@PostMapping("/add")
	public Theater addTheater(@RequestBody Theater theater) {
		return service.add(theater);
	}
	
	@GetMapping("/get")
	public Theater fetchTheater() {
		return service.getData();
	}
}
