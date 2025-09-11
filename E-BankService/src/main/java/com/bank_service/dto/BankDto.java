package com.bank_service.dto;

public class BankDto {
	private String bankName;
	 private String branchName;
	 private String accountHolderName;
	 private String ifscCode;
	 private Long accountNumber;
	 public String getBankName() {
		 return bankName;
	 }
	 public void setBankName(String bankName) {
		 this.bankName = bankName;
	 }
	 public String getBranchName() {
		 return branchName;
	 }
	 public void setBranchName(String branchName) {
		 this.branchName = branchName;
	 }
	 public String getAccountHolderName() {
		 return accountHolderName;
	 }
	 public void setAccountHolderName(String accountHolderName) {
		 this.accountHolderName = accountHolderName;
	 }
	 public String getIfscCode() {
		 return ifscCode;
	 }
	 public void setIfscCode(String ifscCode) {
		 this.ifscCode = ifscCode;
	 }
	 public Long getAccountNumber() {
		 return accountNumber;
	 }
	 public void setAccountNumber(Long accountNumber) {
		 this.accountNumber = accountNumber;
	 }
	 
}
