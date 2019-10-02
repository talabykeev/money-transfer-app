package com.tal.moneytransferapp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tal.moneytransferapp.model.Transaction;
import com.tal.moneytransferapp.model.User;
import com.tal.moneytransferapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/")
    public Iterable <User> all() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity <Object>delete(@PathVariable Long id) {
        try {
            userRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) throws JsonMappingException {
        User savedUser = userRepository.findById(id).get();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        savedUser = objectMapper.updateValue(savedUser, user);
        userRepository.save(savedUser);

        return savedUser;
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<Iterable<Transaction>> findTransactionByUser(@PathVariable Long id) {

        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();
        return ResponseEntity.ok(user.getTransactions());
    }

   @GetMapping(path = {"/search", "/search/"})
    public Iterable<User> search(@RequestParam String firstName) {
        return userRepository.findByFirstName(firstName);
   }

}
