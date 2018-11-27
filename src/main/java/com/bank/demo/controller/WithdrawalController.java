package com.bank.demo.controller;

import com.bank.demo.RequestBean.DepositBean;
import com.bank.demo.RequestBean.WithdrawalBean;
import com.bank.demo.mainModel.Summary;
import com.bank.demo.model.Account;
import com.bank.demo.model.Deposit;
import com.bank.demo.model.Withdrawal;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.repository.SummaryRepository;
import com.bank.demo.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class WithdrawalController {
    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    /***
     * 增加一个取款记录
     * @return
     */
    @PostMapping(value = "/addwithdrawal")
    public boolean addDeposit(@RequestBody WithdrawalBean withdrawalBean)
    {
        java.util.Date datenow=new java.util.Date();
        java.sql.Date  sqldate=new java.sql.Date(datenow.getTime());
        Account account= accountRepository.findByAcconutId(withdrawalBean.accountId);
        if(account.getAccountBalance().compareTo(withdrawalBean.withdrawalsvalue)<0){
            return false;
        }
        BigDecimal accountval=account.getAccountBalance();
        account.setAccountBalance(accountval.subtract(withdrawalBean.withdrawalsvalue));
        Account account1=accountRepository.save(account);
        return true;
    }

    @GetMapping(value = "/getalldeposit")
    public List<Withdrawal> getAllDeposit()
    {
        return withdrawalRepository.findAll();
    }

    @GetMapping(value = "/getDepositBySiteId/{siteid}")
    public List<Withdrawal> getDepositBySiteId(@PathVariable Integer siteid)
    {
        return withdrawalRepository.findBySiteId(siteid);
    }


}
