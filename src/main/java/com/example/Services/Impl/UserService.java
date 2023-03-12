package com.example.Services.Impl;

import com.example.Models.User;
import com.example.Repository.UserRepository;
import com.example.Services.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("UserServiceInterface")
public class UserService implements UserServiceInterface {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Optional<User> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public User save(User user) {
        return repo.save(user);
    }
}
