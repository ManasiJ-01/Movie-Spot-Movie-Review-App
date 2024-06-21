package com.example.demo.services;

import com.example.demo.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String email) {
        // Check if user exists based on email
        User user = userRepository.findByEmail(email);
        return user != null;
    }
}
