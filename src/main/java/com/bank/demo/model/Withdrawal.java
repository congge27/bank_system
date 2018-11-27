package com.bank.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Withdrawals")
public class Withdrawal {

    @Id
    @Column(length = 20)
    private String withdrawalsId;

    @Column(length = 19)
    private String Accountid;

    private BigDecimal withdrawalsvalue;

    private BigDecimal accountBalance;

    @Column(updatable = false)
    private Integer siteId;

    private Date withDate;

    private String staffId;

    public String getWithdrawalsId() {
        return withdrawalsId;
    }

    public void setWithdrawalsId(String withdrawalsId) {
        this.withdrawalsId = withdrawalsId;
    }

    public String getAccountid() {
        return Accountid;
    }

    public void setAccountid(String accountid) {
        Accountid = accountid;
    }

    public BigDecimal getWithdrawalsvalue() {
        return withdrawalsvalue;
    }

    public void setWithdrawalsvalue(BigDecimal withdrawalsvalue) {
        this.withdrawalsvalue = withdrawalsvalue;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getWithDate() {
        return withDate;
    }

    public void setWithDate(Date withDate) {
        this.withDate = withDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
