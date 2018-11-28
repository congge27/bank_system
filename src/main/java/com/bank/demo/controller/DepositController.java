package com.bank.demo.controller;

import com.bank.demo.RequestBean.DepositBean;
import com.bank.demo.mainModel.Summary;
import com.bank.demo.model.Account;
import com.bank.demo.model.Deposit;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.repository.DepositRepository;
import com.bank.demo.repository.SummaryRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/deposit")
public class DepositController {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SummaryRepository summaryRepository;

    @GetMapping(value = "/depositlist")
    public List<Deposit> depositList() throws ParseException {
        for(int i=0;i<=10;i++)
        {
            Deposit deposit=new Deposit();
            deposit.setAccountBalance((BigDecimal.valueOf(200)));
            deposit.setAccountId("user"+i);
            deposit.setDepositsValue(BigDecimal.valueOf(6000));
            deposit.setDepositsDateTime(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").parse("2018-01-01 10:00:00").getTime()));
            deposit.setSiteId(i%2);
            deposit.setDepositsId(deposit.getSiteId().toString()+"-"+i);
            deposit.setStaffId("staff"+i);
            depositRepository.save(deposit);
        }
        return depositRepository.findAll();
    }

    /***
     * 增加一个存款记录
     * @return
     */
    @PostMapping(value = "/adddeposit")
    public boolean addDeposit(@RequestBody DepositBean depositBean)
    {
        if(depositBean==null)
            return false;
        java.util.Date datenow=new java.util.Date();
        java.sql.Date  sqldate=new java.sql.Date(datenow.getTime());

        Account account= accountRepository.findByAcconutId(depositBean.accountId);
        BigDecimal accountval=account.getAccountBalance();
        account.setAccountBalance(accountval.add(depositBean.depositsValue));
        Account account1=accountRepository.save(account);

        Deposit deposit=new Deposit();
        deposit.setStaffId(depositBean.staffId);
        deposit.setSiteId(depositBean.siteId);
        deposit.setDepositsId(DataTest.makeAccountid(depositBean.siteId));
        deposit.setDepositsValue(depositBean.depositsValue);
        deposit.setAccountBalance(account.getAccountBalance());
        deposit.setAccountId(depositBean.accountId);
        deposit.setDepositsDateTime(sqldate);
        depositRepository.save(deposit);

        Summary summary=new Summary();
        summary.setType(1);
        summary.setAccountIdFrom(account.getAcconutId());
        summary.setAccountIdTo(account.getAcconutId());
        summary.setSiteId(depositBean.siteId);
        summary.setValue(depositBean.depositsValue);
        summary.setSummaryId(DataTest.makeSummaryid());
        summary.setDate(sqldate);
        summaryRepository.save(summary);


        return true;
    }

    @GetMapping(value = "/getalldeposit")
    public List<Deposit> getAllDeposit()
    {
        return depositRepository.findAll();
    }

    @GetMapping(value = "/getDepositBySiteId/{siteid}")
    public List<Deposit> getDepositBySiteId(@PathVariable Integer siteid)
    {
        return depositRepository.findBySiteId(siteid);
    }


}
