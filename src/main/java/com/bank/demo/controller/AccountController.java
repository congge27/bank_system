package com.bank.demo.controller;

import com.bank.demo.RequestBean.AccountBean;
import com.bank.demo.RequestBean.LoginBean;
import com.bank.demo.mainModel.Accountsum;
import com.bank.demo.mainModel.User;
import com.bank.demo.model.Account;
import com.bank.demo.repository.AccountRepository;
import com.bank.demo.repository.AccountsumRepository;
import com.bank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.PublicKey;

@RestController
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountsumRepository accountsumRepository;

    @PostMapping(value = "/addAccount")
    public Account addAccount(@RequestBody AccountBean accountBean) {
        User user=userRepository.findByUId(accountBean.UserId);
        Account account=new Account();
        account.setAcconutId(DataTest.makeAccountid(accountBean.siteId));
        account.setAccountBalance(BigDecimal.valueOf(0));
        account.setUserId(accountBean.UserId);
        account.setSiteId(accountBean.siteId);
        account.setPassword(DataTest.getMD5(accountBean.password));
        accountRepository.save(account);

        Accountsum accountsum= new Accountsum();
        accountsum.setAccountBalance(BigDecimal.valueOf(0));
        accountsum.setAccountId(account.getAcconutId());
        accountsum.setUId(accountBean.UserId);
        accountsum.setAccountPsw(account.getPassword());
        accountsum.setSiteId(account.getSiteId());
        accountsumRepository.save(accountsum);
        return account;
    }

    @PostMapping(value = "/islogin")
    public boolean isLogin(@RequestBody LoginBean loginBean){
        Account account=accountRepository.findByAcconutId(loginBean.AccountId);
        String pwd=DataTest.getMD5(loginBean.password);
        if(pwd.equals(account.getPassword()))
        {
            return true;
        }
        else return false;
    }


}
