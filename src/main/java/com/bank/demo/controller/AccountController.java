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
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountsumRepository accountsumRepository;

    @PostMapping(value = "/addaccount")
    public boolean addAccount(@RequestBody AccountBean accountBean) {
        System.out.println(accountBean.userId);
        System.out.println("1534561");

        if(accountBean==null||accountBean.userId.length()!=18||accountBean.password.length()>32||accountBean.password.length()<5)
            return false;
        User user=userRepository.findByUId(accountBean.userId);
        Account account=new Account();
        account.setAcconutId(DataTest.makeAccountid(accountBean.siteId));
        account.setAccountBalance(BigDecimal.valueOf(0));
        account.setUserId(accountBean.userId);
        account.setSiteId(accountBean.siteId);
        account.setPassword(DataTest.getMD5(accountBean.password));
        accountRepository.save(account);

        Accountsum accountsum= new Accountsum();
        accountsum.setAccountBalance(BigDecimal.valueOf(0));
        accountsum.setAccountId(account.getAcconutId());
        accountsum.setUId(accountBean.userId);
        accountsum.setAccountPsw(account.getPassword());
        accountsum.setSiteId(account.getSiteId());
        accountsumRepository.save(accountsum);
        return true;
    }

    @GetMapping(value = "/getaccount/{siteid}")
    public List<Account> getaccountbyid(@PathVariable Integer siteid){
        return accountRepository.findBySiteId(siteid);
    }

    @PostMapping(value = "/islogin")
    public boolean isLogin(@RequestBody LoginBean loginBean){
        if(loginBean.accountId==null||loginBean.password==null)
            return false;
        String id=loginBean.accountId;
        Account account=accountRepository.findByAcconutId(id);
        String pwd=DataTest.getMD5(loginBean.password);
        if(pwd.equals(account.getPassword()))
        {
            return true;
        }
        else return false;
    }
}
