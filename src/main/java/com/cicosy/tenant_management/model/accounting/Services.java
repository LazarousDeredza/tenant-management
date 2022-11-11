//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.accounting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Services {
    @Id
    @SequenceGenerator(
            name = "invoice_sequence",
            sequenceName = "invoice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_sequence"
    )
    private Long id;
    private String serviceName;
    private double amount;

    public Services(String serviceName, double amount) {
        this.serviceName = serviceName;
        this.amount = amount;
    }

    public Long getId() {
        return this.id;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setServiceName(final String serviceName) {
        this.serviceName = serviceName;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public String toString() {
        return "Services(id=" + this.getId() + ", serviceName=" + this.getServiceName() + ", amount=" + this.getAmount() + ")";
    }

    public Services() {
    }

    public Services(final Long id, final String serviceName, final double amount) {
        this.id = id;
        this.serviceName = serviceName;
        this.amount = amount;
    }
}
