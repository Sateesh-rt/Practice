package com.userservice.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
   
    private  BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    // 🔹 Register new user
    public User saveUser(User user) {
    	String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    // 🔹 Login (simple matching for now)
    public User login(String name, String password, String role) {
        User user = userRepository.getUserByNameAndRole(name, role);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // login success
        }
        return null; // login fail
    }

    // 🔹 Fetch by ID
    public Optional<User> getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return optional;
        }
        throw new RuntimeException("User Id not found with: " + id);
    }

    // 🔹 Update user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setMobile(userDetails.getMobile());
        user.setRole(userDetails.getRole());

        return userRepository.save(user);
    }

    // 🔹 Delete user
    public void deleteUserData(Long id) {
        userRepository.deleteById(id);
    }

    // 🔹 Check if user exists (used by cart-service & bank-service)
    public boolean existsUser(Long id) {
        return userRepository.existsById(id);
    }
}
