package com.cartservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "E-UserService1")
public interface UserClient {
	 @GetMapping("/api/user/exists/{id}")
	    boolean userExists(@PathVariable("id") Long id);
}
