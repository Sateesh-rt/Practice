package com.bank_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank_service.dto.BankDto;
import com.bank_service.model.Bank;
import com.bank_service.services.BankService;

@RestController
@RequestMapping("/api/Bank")

public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addData(@RequestBody BankDto dto, @PathVariable Long userId) {
        return bankService.addBankToUser(dto, userId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getBanks(@PathVariable Long userId) {
        return bankService.getBanksByUser(userId);
    }

    @PutMapping("/{bankId}")
    public ResponseEntity<?> updateBank(@PathVariable Long bankId, @RequestBody Bank bankDto) {
        return bankService.updateBank(bankId, bankDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBankDetails(@PathVariable Long id) {
        bankService.deleteBank(id);
    }
}



