package com.bank.demo.repository;

import com.bank.demo.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff,String> {
    Staff findByStaffId(String id);
    List<Staff> findByStaffName(String name);
    List<Staff> findByStaffPhone(String phone);
    List<Staff> findByStaffSite(Integer siteId);
    List<Staff> findAll();
}
