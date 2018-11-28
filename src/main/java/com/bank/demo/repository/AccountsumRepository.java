package com.bank.demo.repository;

import com.bank.demo.mainModel.Accountsum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsumRepository extends JpaRepository<Accountsum,String> {
    List<Accountsum> findBySiteId(Integer siteid);
    Accountsum findByAccountId(String accountId);
    List<Accountsum> findByUId(String uId);

}
