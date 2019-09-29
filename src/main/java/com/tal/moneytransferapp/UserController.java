package com.tal.moneytransferapp;

import com.tal.moneytransferapp.model.User;
import com.tal.moneytransferapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }


    @GetMapping("/")
    public Iterable <User> all() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/api/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User create() {
        return new User(100000, "New Photo");
    }

}
