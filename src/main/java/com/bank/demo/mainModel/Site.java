package com.bank.demo.mainModel;

import javax.persistence.*;
import java.security.PublicKey;

@Entity
@Table(name = "Sites")
public class Site {
    @Id
    @GeneratedValue
    private Integer siteId;

    @Column(length = 20)
    private String siteName;

    @Column(length = 50)
    private String siteAddress;

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }
}
