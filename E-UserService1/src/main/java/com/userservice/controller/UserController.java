package com.userservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userservice.dto.LoginRequest;
import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import com.userservice.services.UserService;

@RestController
@RequestMapping("/api/user")  // changed base path for clarity in Gateway
//@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    ObjectMapper mapper;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🔹 Angular signup API
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    // 🔹 Angular login API
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(
                loginRequest.getName(),
                loginRequest.getPassword(),
                loginRequest.getRole()
        );
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Data Mismatched");
    }

    // 🔹 Fetch user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable long id) {
        Optional<User> optional = userService.getUserById(id);
        return ResponseEntity.ok(optional);
    }

    // 🔹 Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    // 🔹 Delete user
    @DeleteMapping("/delete/{id}")
    public void deleteUserDetails(@PathVariable Long id) {
        userService.deleteUserData(id);
    }

    // 🔹 Internal API (for cart-service, bank-service, etc.)
//    @GetMapping("/internal/{id}/exists")
//    public ResponseEntity<Boolean> exists(@PathVariable Long id) {
//        return ResponseEntity.ok(userRepository.existsById(id));
//    }
    @GetMapping("/exists/{id}")
    public boolean userExists(@PathVariable Long id) {
        return userRepository.existsById(id);
    }
    @GetMapping("/bank/{id}")
    public boolean getUserById(@PathVariable Long id) {
        return userRepository.existsById(id);
    }
}
