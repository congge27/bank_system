package com.bank.demo.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @Column(length = 19,updatable = false)
    private String acconutId;

    @Column(length = 18,updatable = false)
    private String userId;

    @Column(updatable = false)
    private Integer siteId;

    @Column(length = 32)
    private String password;

    private BigDecimal accountBalance;

    public String getAcconutId() {
        return acconutId;
    }

    public void setAcconutId(String acconutId) {
        this.acconutId = acconutId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
