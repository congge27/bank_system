package com.bank.demo.repository;

import com.bank.demo.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
public interface WithdrawalRepository extends JpaRepository<Withdrawal,String> {
    List<Withdrawal> findAll();
    Withdrawal findByWithdrawalsId(String Withdrawal_Id);
    void deleteByWithdrawalsId(String withdrawal_Id);
    List<Withdrawal> findByWithdrawalsvalueBetween(BigDecimal small, BigDecimal large);
    List<Withdrawal> findBySiteId(Integer siteid);
}
