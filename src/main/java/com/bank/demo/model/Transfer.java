package com.bank.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transferId;

    @Column(length = 19)
    private String accountIdFrom;

    @Column(length = 19)
    private String accountIdTo;

    private BigDecimal transferValue;
    private BigDecimal accountFromBalance;
    private BigDecimal accountToBalance;

    @Column(updatable = false)
    private Integer siteId;

    private Date transferDate;

    private String staffId;

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public String getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(String accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public String getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(String accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public BigDecimal getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(BigDecimal transferValue) {
        this.transferValue = transferValue;
    }

    public BigDecimal getAccountFromBalance() {
        return accountFromBalance;
    }

    public void setAccountFromBalance(BigDecimal accountFromBalance) {
        this.accountFromBalance = accountFromBalance;
    }

    public BigDecimal getAccountToBalance() {
        return accountToBalance;
    }

    public void setAccountToBalance(BigDecimal accountToBalance) {
        this.accountToBalance = accountToBalance;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
