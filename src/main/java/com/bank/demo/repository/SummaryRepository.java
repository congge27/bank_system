package com.bank.demo.repository;

import com.bank.demo.mainModel.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SummaryRepository extends JpaRepository<Summary,String> {
    List<Summary> findAll();
    List<Summary> findByAccountIdFrom(String aId);
    List<Summary> findByAccountIdTo(String aId);
    List<Summary> findByDate(Date date);
    List<Summary> findByDateBetween(Date start,Date stop);
    List<Summary> findBySiteId(Integer siteId);
}
