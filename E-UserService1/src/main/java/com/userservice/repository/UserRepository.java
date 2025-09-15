package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.userservice.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
   

	@Query(value = "SELECT * FROM users WHERE name = :name AND role = :role", nativeQuery = true)
	User getUserByNameAndRole(@Param("name") String name, @Param("role") String role);

	
	
	     
}
