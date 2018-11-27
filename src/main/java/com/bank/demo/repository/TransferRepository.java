package com.bank.demo.repository;

import com.bank.demo.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {
    List<Transfer> findAll();
    Transfer findByTransferId(Integer transferId);

}
