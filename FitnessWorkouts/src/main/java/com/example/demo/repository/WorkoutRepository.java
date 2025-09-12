package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long>{

}
