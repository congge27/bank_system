package com.bank.demo.controller;

import com.bank.demo.RequestBean.DepositBean;
import com.bank.demo.RequestBean.WithdrawalBean;
import com.bank.demo.mainModel.Accountsum;
import com.bank.demo.mainModel.Summary;
import com.bank.demo.model.Account;
import com.bank.demo.model.Deposit;
import com.bank.demo.model.Withdrawal;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.repository.AccountsumRepository;
import com.bank.demo.repository.SummaryRepository;
import com.bank.demo.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/withdrawal")
public class WithdrawalController {
    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private AccountsumRepository accountsumRepository;

    /***
     * 增加一个取款记录
     * @return
     */
    @PostMapping(value = "/addwithdrawal")
    public boolean addWithdrawal(@RequestBody WithdrawalBean withdrawalBean)
    {
        if(withdrawalBean==null)
            return false;
        java.util.Date datenow=new java.util.Date();
        java.sql.Date  sqldate=new java.sql.Date(datenow.getTime());
        Account account= accountRepository.findByAcconutId(withdrawalBean.accountId);
        if(account.getAccountBalance().compareTo(withdrawalBean.withdrawalsvalue)<0){
            return false;
        }
        Withdrawal withdrawal=new Withdrawal();
        withdrawal.setAccountBalance(account.getAccountBalance().subtract(withdrawalBean.withdrawalsvalue));
        withdrawal.setAccountid(withdrawalBean.accountId);
        withdrawal.setSiteId(withdrawalBean.siteId);
        withdrawal.setWithdrawalsId(DataTest.makeAccountid(withdrawalBean.siteId));
        withdrawal.setWithdrawalsvalue(withdrawalBean.withdrawalsvalue);
        withdrawal.setStaffId(withdrawalBean.staffId);
        datenow=new java.util.Date();
        sqldate=new java.sql.Date(datenow.getTime());
        withdrawal.setWithDate(sqldate);
        withdrawalRepository.save(withdrawal);

        account.setAccountBalance(withdrawal.getAccountBalance());
        accountRepository.save(account);

        datenow=new java.util.Date();
        sqldate=new java.sql.Date(datenow.getTime());
        Summary summary=new Summary();
        summary.setDate(sqldate);
        summary.setType(DepositController.actionType.取款);
        summary.setAccountIdFrom(account.getAcconutId());
        summary.setAccountIdTo(account.getAcconutId());
        summary.setSiteId(withdrawalBean.siteId);
        summary.setValue(withdrawalBean.withdrawalsvalue);
        summary.setSummaryId(DataTest.makeSummaryid());
        summaryRepository.save(summary);

        Accountsum accountsum= accountsumRepository.findByAccountId(account.getAcconutId());
        accountsum.setAccountBalance(account.getAccountBalance());
        accountsumRepository.save(accountsum);
        return true;
    }

    @GetMapping(value = "/getallwithdrawal")
    public List<Withdrawal> getAllWithdrawal()
    {
        return withdrawalRepository.findAll();
    }

    @GetMapping(value = "/getWithdrawalBySiteId/{siteid}")
    public List<Withdrawal> getDepositBySiteId(@PathVariable Integer siteid)
    {
        return withdrawalRepository.findBySiteId(siteid);
    }


}
