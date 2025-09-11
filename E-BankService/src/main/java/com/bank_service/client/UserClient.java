package com.bank_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="E-UserService1")
public interface UserClient {
	 @GetMapping("/api/user/bank/{id}")
	    ResponseEntity<?> getUserById(@PathVariable("id") Long id);

}
