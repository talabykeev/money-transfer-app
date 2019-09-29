package com.tal.moneytransferapp.repository;

import com.tal.moneytransferapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {


}
