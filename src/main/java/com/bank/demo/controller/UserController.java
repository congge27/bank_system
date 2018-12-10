package com.bank.demo.controller;

import com.bank.demo.RequestBean.UserBean;
import com.bank.demo.mainModel.User;
import com.bank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/adduser")
    public boolean addUser(@RequestBody UserBean userBean){
        if(userBean.uId==null||userBean==null||userBean.uId.length()!=18)
            return false;
        if(userBean.uId.length()>18||userBean.uName.length()>20||userBean.uPhone.length()>11)
            return false;
        User user=new User();
        user.setUId(userBean.uId);
        user.setUName(userBean.uName);
        user.setUphone(userBean.uPhone);
        userRepository.save(user);
        return true;
    }

    @GetMapping(value = "/getalluser")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/getuserbyuid/{uid}")
    public User getUserByUid(@PathVariable String uid){
        return userRepository.findByUId(uid);
    }


    @GetMapping(value = "/getuserbyphone/{phone}")
    public List<User> getUserByPhone(@PathVariable String uphone){
        return userRepository.findByUphone(uphone);
    }
}