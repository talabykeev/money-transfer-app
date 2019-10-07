package com.tal.moneytransferapp.repository;

import com.tal.moneytransferapp.model.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long>  {


}
