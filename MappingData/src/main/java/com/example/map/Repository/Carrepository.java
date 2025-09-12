package com.example.map.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.map.Entity.Car;

public interface Carrepository extends JpaRepository<Car, Integer>{

}
