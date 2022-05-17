package com.example.demoapp.service;

import com.example.demoapp.entity.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account getById(Long id);
    void newAccount();
    void deposit(Long id, BigDecimal sum);
    void withdraw(Long id, BigDecimal sum);
    void delete(Account account);
}
