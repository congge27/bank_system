package com.bank.demo.RequestBean;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class TransferBean {
    public String accountIdFrom;

    public String accountIdTo;

    public BigDecimal transferValue;

    public Integer siteId;

    public String staffId;
}
