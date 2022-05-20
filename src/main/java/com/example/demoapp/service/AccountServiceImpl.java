package com.example.demoapp.service;

import com.example.demoapp.dao.AccountDao;
import com.example.demoapp.entity.Account;
import com.example.demoapp.util.AccountIdSequence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountDao accountDao;

    public AccountServiceImpl(@Qualifier("inMemoryAccountDao") AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public void newAccount() {
        accountDao.create(new Account(AccountIdSequence.next(), BigDecimal.ZERO));
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
