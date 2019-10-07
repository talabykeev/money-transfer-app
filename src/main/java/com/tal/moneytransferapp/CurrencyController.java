package com.tal.moneytransferapp;

import com.tal.moneytransferapp.model.Currency;
import com.tal.moneytransferapp.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/currencies")


public class CurrencyController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/")
    public ResponseEntity<Iterable<Currency>> all() {
        Iterable<Currency> currencies = currencyRepository.findAll();

        if(!currencies.iterator().hasNext()) {
            return new ResponseEntity<>( /* null */ HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(currencies);
    }


    @GetMapping("/{id}")
    public ResponseEntity <Currency> findCurrencyById(@PathVariable Long id) {

        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if(!optionalCurrency.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Currency currency = optionalCurrency.get();
        return ResponseEntity.ok(currency);
    }

}
