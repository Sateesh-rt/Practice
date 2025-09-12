package com.oneToMany.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneToMany.Entity.Theater;
import com.oneToMany.Repository.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	private TheaterRepository repository;
	
	public Theater add(Theater theater) {
		return repository.save(theater);
	}
	public List<Theater> getData() {
		return repository.findAll();
	}
}
