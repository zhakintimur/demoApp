package com.example.demoapp.service;

import com.example.demoapp.dao.AccountDao;
import com.example.demoapp.entity.Account;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public void newAccount() {
        accountDao.create(new Account());
    }

    @Override
    public void deposit(Long id, BigDecimal sum) {
        var account = accountDao.findById(id);
        var balance = account.getBalance();
        account.setBalance(balance.add(sum));
        accountDao.update(account);
    }

    @Override
    public void withdraw(Long id, BigDecimal sum) {
        var account = accountDao.findById(id);
        var balance = account.getBalance();
        account.setBalance(balance.subtract(sum));
        accountDao.update(account);
    }

    @Override
    public void delete(Account account) {
        accountDao.delete(account);
    }
}
