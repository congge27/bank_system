package com.bank.demo.controller;

import com.bank.demo.mainModel.Summary;
import com.bank.demo.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/summary")
public class SummaryController {
    @Autowired
    private SummaryRepository summaryRepository;

    @GetMapping(value = "/getallsummary")
    public List<Summary> getAll(){
        return summaryRepository.findAll();
    }

    @GetMapping(value = "/getbysiteid/{siteid}")
    public List<Summary> getBySiteid(@PathVariable Integer siteid)
    {
        return summaryRepository.findBySiteId(siteid);
    }

    @GetMapping(value = "/getbyfromid/{uid}")
    public List<Summary> getByUserIdFrom(@PathVariable String uid){
        return summaryRepository.findByAccountIdFrom(uid);
    }

    @GetMapping(value = "/getbytoid/{uid}")
    public List<Summary> getByUserIdTo(@PathVariable String uid){
        return summaryRepository.findByAccountIdTo(uid);
    }
}
