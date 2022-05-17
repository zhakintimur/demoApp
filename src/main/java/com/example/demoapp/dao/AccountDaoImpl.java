package com.example.demoapp.dao;

import com.example.demoapp.entity.Account;

import java.util.LinkedList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private final List<Account> accountList = new LinkedList<>();

    @Override
    public Account findById(Long id) {
        return accountList.stream().filter(acc -> id.equals(acc.getId())).findFirst().orElseThrow();
    }

    @Override
    public void create(Account account) {
        accountList.add(account);
    }

    @Override
    public void update(Account account) {
        accountList.stream().filter(acc -> account.getId().equals(acc.getId())).forEach(acc -> acc = account);
    }

    @Override
    public void delete(Account account) {
        accountList.stream().filter(acc -> account.getId().equals(acc.getId())).iterator().remove();
    }
}
