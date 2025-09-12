package com.oneToMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oneToMany.Entity.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer>{

}
