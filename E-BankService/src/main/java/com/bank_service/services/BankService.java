package com.bank_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank_service.client.UserClient;
import com.bank_service.dto.BankDto;
import com.bank_service.model.Bank;
import com.bank_service.repository.BankRepository;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private UserClient userClient;

    public ResponseEntity<?> addBankToUser(BankDto dto, Long userId) {
        ResponseEntity<?> userResponse = userClient.getUserById(userId);

        if (!userResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().body("User not found with id: " + userId);
        }

        Bank bank = new Bank();
        bank.setBankName(dto.getBankName());
        bank.setBranchName(dto.getBranchName());
        bank.setAccountHolderName(dto.getAccountHolderName());
        bank.setIfscCode(dto.getIfscCode());
        bank.setAccountNumber(dto.getAccountNumber());
        bank.setUserId(userId);

        Bank savedBank = bankRepository.save(bank);
        return ResponseEntity.ok(savedBank);
    }

    public ResponseEntity<?> getBanksByUser(Long userId) {
        List<Bank> banks = bankRepository.findByUserId(userId);
        return ResponseEntity.ok(banks);
    }

    public ResponseEntity<?> updateBank(Long bankId, Bank bankDto) {
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new RuntimeException("Bank not found"));

        bank.setBankName(bankDto.getBankName());
        bank.setAccountHolderName(bankDto.getAccountHolderName());
        bank.setBranchName(bankDto.getBranchName());
        bank.setAccountNumber(bankDto.getAccountNumber());
        bank.setIfscCode(bankDto.getIfscCode());

        Bank updatedBank = bankRepository.save(bank);
        return ResponseEntity.ok(updatedBank);
    }

    public void deleteBank(Long id) {
        bankRepository.deleteById(id);
    }
}


