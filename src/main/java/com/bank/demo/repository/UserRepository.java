package com.bank.demo.repository;

import com.bank.demo.mainModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUId(String UId);

    List<User> findByUphone(String phone);

    List<User> findByUName(String name);
}
