package com.bank.demo.RequestBean;

import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class AccountBean {
    public String userId;

    @Length(min=5,max=20)
    public String password;

    public Integer siteId;
}
