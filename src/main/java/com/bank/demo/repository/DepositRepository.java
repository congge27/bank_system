package com.bank.demo.repository;

import com.bank.demo.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface DepositRepository extends JpaRepository<Deposit, String> {
    List<Deposit> findAll();
    Deposit findByDepositsId(String deposits_Id);
    void deleteByDepositsId(String deposits_Id);
    List<Deposit> findAllByDepositsValueBetween(BigDecimal small,BigDecimal large);
    List<Deposit> findBySiteId(Integer siteid);
}
