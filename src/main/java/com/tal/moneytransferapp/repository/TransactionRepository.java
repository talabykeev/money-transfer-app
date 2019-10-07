package com.tal.moneytransferapp.repository;

import com.tal.moneytransferapp.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query(value = "Select * From users limit 10",nativeQuery = true)
    Iterable<Transaction> fetchUSD();

}
