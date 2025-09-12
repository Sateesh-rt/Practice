package com.angular.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class UserService {
	String API_URL ="https://jsonplaceholder.typicode.com/posts";
	
    public ResponseEntity<String> getDummyUsers() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(API_URL, String.class);
        return ResponseEntity.ok(result);
    }
	

}
