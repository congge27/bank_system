package com.bank.demo.RequestBean;

import org.hibernate.validator.constraints.Length;

public class LoginBean {
    public String AccountId;

    @Length(min=5,max=20)
    public String password;

    public Integer siteId;

}
