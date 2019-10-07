package com.tal.moneytransferapp.repository;

import com.tal.moneytransferapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findTop10ByFirstNameAndLastName(String firstName, String lastName);
    Iterable<User> findTop10ByLastName(String lastName);
    Iterable<User> findTop10ByFirstName(String firstName);

    @Query(value = "Select * From users limit 10",nativeQuery = true)
    Iterable<User> fetchTop10();

    Iterable<User> findByFirstName(String chyngyz);
}
