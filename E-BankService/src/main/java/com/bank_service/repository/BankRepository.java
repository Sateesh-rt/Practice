package com.bank_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank_service.model.Bank;


import java.util.List;


public interface BankRepository extends JpaRepository<Bank, Long> {
	  List<Bank> findByUserId(Long userId);
}
