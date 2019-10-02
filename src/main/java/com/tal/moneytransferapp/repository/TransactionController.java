package com.tal.moneytransferapp.repository;


import com.tal.moneytransferapp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/transactions")


public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/")
    public ResponseEntity<Iterable<Transaction>> all() {
        Iterable<Transaction> transactions = transactionRepository.findAll();

        if(!transactions.iterator().hasNext()) {
            return new ResponseEntity<>( /* null */ HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Transaction> findTransactionById(@PathVariable Long id) {

        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if(!optionalTransaction.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Transaction transaction = optionalTransaction.get();
        return ResponseEntity.ok(transaction);
    }

}

