package com.bank.demo.repository;

import com.bank.demo.mainModel.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site,Integer> {
    Site findBySiteId(Integer siteId);
    List<Site> findAll();
}
