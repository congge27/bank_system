package com.bank.demo.controller;

import com.bank.demo.RequestBean.TransferBean;
import com.bank.demo.mainModel.Accountsum;
import com.bank.demo.mainModel.Summary;
import com.bank.demo.model.Account;
import com.bank.demo.model.Transfer;
import com.bank.demo.model.Withdrawal;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.repository.AccountsumRepository;
import com.bank.demo.repository.SummaryRepository;
import com.bank.demo.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/transfer")
public class TransferController {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountsumRepository accountsumRepository;

    @PostMapping(value = "/addtransfer")
    public boolean addTransfer(@RequestBody TransferBean transferBean)
    {
        if(transferBean==null)
            return false;
        Account accountFrom=accountRepository.findByAcconutId(transferBean.accountIdFrom);
        Account accountTo=accountRepository.findByAcconutId(transferBean.accountIdTo);
        if(accountFrom==null||accountTo==null)
            return false;
        if(accountFrom.getAccountBalance().compareTo(transferBean.transferValue)<0){
            return false;
        }
        accountFrom.setAccountBalance(accountFrom.getAccountBalance().subtract(transferBean.transferValue));
        accountTo.setAccountBalance(accountTo.getAccountBalance().add(transferBean.transferValue));
        accountRepository.save(accountFrom);
        accountRepository.save(accountTo);

        Transfer transferFrom=new Transfer();
        Transfer transferTo=new Transfer();

        transferFrom.setSiteId(transferBean.siteId);
        transferTo.setSiteId(DataTest.getSiteId(transferBean.accountIdTo));

        transferFrom.setAccountFromBalance(accountFrom.getAccountBalance());
        transferTo.setAccountFromBalance(accountFrom.getAccountBalance());

        transferFrom.setAccountIdFrom(transferBean.accountIdFrom);
        transferTo.setAccountIdFrom(transferBean.accountIdFrom);

        transferFrom.setAccountIdTo(transferBean.accountIdTo);
        transferTo.setAccountIdTo(transferBean.accountIdTo);

        transferFrom.setAccountToBalance(accountTo.getAccountBalance());
        transferTo.setAccountToBalance(accountTo.getAccountBalance());

        transferFrom.setStaffId(transferBean.staffId);
        transferTo.setStaffId(transferBean.staffId);

        java.util.Date datenow=new java.util.Date();
        java.sql.Date  sqldate=new java.sql.Date(datenow.getTime());
        transferFrom.setTransferDate(sqldate);
        transferTo.setTransferDate(sqldate);

        transferFrom.setTransferValue(transferBean.transferValue);
        transferTo.setTransferValue(transferBean.transferValue);

        transferRepository.save(transferFrom);
        transferRepository.save(transferTo);

        Summary summary=new Summary();
        summary.setDate(sqldate);
        summary.setSummaryId(DataTest.makeSummaryid());
        summary.setValue(transferBean.transferValue);
        summary.setSiteId(transferBean.siteId);
        summary.setAccountIdTo(transferBean.accountIdTo);
        summary.setAccountIdFrom(transferBean.accountIdFrom);
        summary.setType(DepositController.actionType.转账);
        summaryRepository.save(summary);

        Accountsum accountsum1= accountsumRepository.findByAccountId(accountFrom.getAcconutId());
        accountsum1.setAccountBalance(accountFrom.getAccountBalance());
        Accountsum accountsum2= accountsumRepository.findByAccountId(accountTo.getAcconutId());
        accountsum1.setAccountBalance(accountTo.getAccountBalance());
        accountsumRepository.save(accountsum1);
        accountsumRepository.save(accountsum2);
        return true;
    }

    @GetMapping(value = "/getalltransfer")
    public List<Transfer> getAllTransfer()
    {
        return transferRepository.findAll();
    }

    @GetMapping(value = "/getTransferBySiteId/{siteid}")
    public List<Transfer> getDepositBySiteId(@PathVariable Integer siteid)
    {
        return transferRepository.findBySiteId(siteid);
    }
}
