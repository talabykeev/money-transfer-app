package com.tal.moneytransferapp.repository;

import com.tal.moneytransferapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
