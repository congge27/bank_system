package com.bank.demo.repository;

import com.bank.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByAcconutId(String accountid);
    List<Account> findAll();
    List<Account> findBySiteId(Integer siteId);
    List<Account> findByUserId(String userId);
}
