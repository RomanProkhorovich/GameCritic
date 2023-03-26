package com.example.Services.Interface;

import com.example.Models.User.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserServiceInterface {
    Optional<User> findByName(String name);
    User save(User user);
}
