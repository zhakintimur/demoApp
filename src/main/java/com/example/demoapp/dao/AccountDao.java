package com.example.demoapp.dao;

import com.example.demoapp.entity.Account;

public interface AccountDao {
    Account findById(Long id);
    void create(Account account);
    void update(Account account);
    void delete(Account account);
}
