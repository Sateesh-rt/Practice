package com.example.map.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.map.Entity.User;

public interface Userrepository extends JpaRepository<User,Integer>{

}
