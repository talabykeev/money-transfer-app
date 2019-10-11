package com.tal.moneytransferapp;

import com.tal.moneytransferapp.model.User;
import com.tal.moneytransferapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public Iterable<User> fetchAllUsers() {

        return userRepository.findAll();
    }
}
