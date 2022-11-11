//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.accounting;

import com.cicosy.tenant_management.model.propertyManagement.Compartment;
import com.cicosy.tenant_management.model.propertyManagement.Property;
import com.cicosy.tenant_management.model.tenantManagement.Tenant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long id;
    private String paymentDate;
    private Long compartment;
    private Long property;
    private Long type;
    @Column(
            unique = true
    )
    private String reference;
    private Long capturedBy;
    private double amount;
    private String method;
    private Long invoice;
    @Transient
    private Property propertyObject;
    @Transient
    private Compartment compartmentObject;
    @Transient
    private Tenant tenantObject;

    public Payment(String paymentDate, Long compartment, Long property, Long type, String reference, Long capturedBy, double amount, String method, Long invoice, Property propertyObject, Compartment compartmentObject, Tenant tenantObject) {
        this.paymentDate = paymentDate;
        this.compartment = compartment;
        this.property = property;
        this.type = type;
        this.reference = reference;
        this.capturedBy = capturedBy;
        this.amount = amount;
        this.method = method;
        this.invoice = invoice;
        this.propertyObject = propertyObject;
        this.compartmentObject = compartmentObject;
        this.tenantObject = tenantObject;
    }

    public Long getId() {
        return this.id;
    }

    public String getPaymentDate() {
        return this.paymentDate;
    }

    public Long getCompartment() {
        return this.compartment;
    }

    public Long getProperty() {
        return this.property;
    }

    public Long getType() {
        return this.type;
    }

    public String getReference() {
        return this.reference;
    }

    public Long getCapturedBy() {
        return this.capturedBy;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getMethod() {
        return this.method;
    }

    public Long getInvoice() {
        return this.invoice;
    }

    public Property getPropertyObject() {
        return this.propertyObject;
    }

    public Compartment getCompartmentObject() {
        return this.compartmentObject;
    }

    public Tenant getTenantObject() {
        return this.tenantObject;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setPaymentDate(final String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setCompartment(final Long compartment) {
        this.compartment = compartment;
    }

    public void setProperty(final Long property) {
        this.property = property;
    }

    public void setType(final Long type) {
        this.type = type;
    }

    public void setReference(final String reference) {
        this.reference = reference;
    }

    public void setCapturedBy(final Long capturedBy) {
        this.capturedBy = capturedBy;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public void setMethod(final String method) {
        this.method = method;
    }

    public void setInvoice(final Long invoice) {
        this.invoice = invoice;
    }

    public void setPropertyObject(final Property propertyObject) {
        this.propertyObject = propertyObject;
    }

    public void setCompartmentObject(final Compartment compartmentObject) {
        this.compartmentObject = compartmentObject;
    }

    public void setTenantObject(final Tenant tenantObject) {
        this.tenantObject = tenantObject;
    }

    public String toString() {
        return "Payment(id=" + this.getId() + ", paymentDate=" + this.getPaymentDate() + ", compartment=" + this.getCompartment() + ", property=" + this.getProperty() + ", type=" + this.getType() + ", reference=" + this.getReference() + ", capturedBy=" + this.getCapturedBy() + ", amount=" + this.getAmount() + ", method=" + this.getMethod() + ", invoice=" + this.getInvoice() + ", propertyObject=" + this.getPropertyObject() + ", compartmentObject=" + this.getCompartmentObject() + ", tenantObject=" + this.getTenantObject() + ")";
    }

    public Payment() {
    }

    public Payment(final Long id, final String paymentDate, final Long compartment, final Long property, final Long type, final String reference, final Long capturedBy, final double amount, final String method, final Long invoice, final Property propertyObject, final Compartment compartmentObject, final Tenant tenantObject) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.compartment = compartment;
        this.property = property;
        this.type = type;
        this.reference = reference;
        this.capturedBy = capturedBy;
        this.amount = amount;
        this.method = method;
        this.invoice = invoice;
        this.propertyObject = propertyObject;
        this.compartmentObject = compartmentObject;
        this.tenantObject = tenantObject;
    }
}
