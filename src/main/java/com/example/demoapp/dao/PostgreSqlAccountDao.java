package com.example.demoapp.dao;

import com.example.demoapp.entity.Account;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PostgreSqlAccountDao implements AccountDao {

    private final DataSource dataSource;

    public PostgreSqlAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Account findById(Long id) {
        String sql = "SELECT * FROM accounts WHERE id = ?";

        try (var conn = dataSource.getConnection()) {
            Account account = null;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account(
                        rs.getLong("id"),
                        rs.getBigDecimal("balance")
                );
            }
            rs.close();
            ps.close();
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Account account) {
        String sql = "INSERT INTO accounts (id, balance) VALUES (?, ?)";

        try (var conn = dataSource.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, account.getId());
            ps.setBigDecimal(2, account.getBalance());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(Account account) {

    }
}
