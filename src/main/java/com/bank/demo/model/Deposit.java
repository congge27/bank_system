package com.bank.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/***
 * 存款实体类
 */
@Entity
@Table(name = "Deposits")
public class Deposit {
    @Id
    @Column(length = 20)
    private String depositsId;

    @Column(length = 19)
    private String accountId;

    private BigDecimal depositsValue;

    private BigDecimal accountBalance;

    @Column(updatable = false)
    private Integer siteId;

    private Date depositsDateTime;

    private String staffId;

    public String getDepositsId() {
        return depositsId;
    }

    public void setDepositsId(String depositsId) {
        this.depositsId = depositsId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getDepositsValue() {
        return depositsValue;
    }

    public void setDepositsValue(BigDecimal depositsValue) {
        this.depositsValue = depositsValue;
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

    public Date getDepositsDateTime() {
        return depositsDateTime;
    }

    public void setDepositsDateTime(Date depositsDateTime) {
        this.depositsDateTime = depositsDateTime;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
