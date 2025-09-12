package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.Entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
