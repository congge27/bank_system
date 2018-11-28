package com.bank.demo.controller;

import com.bank.demo.mainModel.Accountsum;
import com.bank.demo.repository.AccountsumRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accountsum")
public class AccountSumController {
    private AccountsumRepository accountsumRepository;
    /*
    List<Accountsum> findBySiteId(Integer siteid);
    Accountsum findByAccountId(String accountId);
    List<Accountsum> findByUId(String uId);
    */
    @GetMapping(value = "/getall")
    public List<Accountsum> getAll(){
        List<Accountsum> list=accountsumRepository.findAll();
        return list;
    }

    @GetMapping(value = "/getbyaccountid/{id}")
    public Accountsum getByAccountId(@PathVariable String id){
        return accountsumRepository.findByAccountId(id);
    }

    @GetMapping(value = "/getbysiteid/{siteid}")
    public List<Accountsum> getBySiteId(@PathVariable Integer siteid){
        return accountsumRepository.findBySiteId(siteid);
    }

    @GetMapping(value = "/getbyuid/{userid}")
    public List<Accountsum> getByUserId(@PathVariable String userid){
        return accountsumRepository.findByUId(userid);
    }

}
