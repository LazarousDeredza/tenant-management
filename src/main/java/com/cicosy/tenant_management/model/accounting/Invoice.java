//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.accounting;

import com.cicosy.tenant_management.model.propertyManagement.Compartment;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Invoice {
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
    private Long compartment;
    @Transient
    private Compartment compartmentObject;
    private LocalDate dateIssued = LocalDate.now();
    private String forTheMonthOf;
    private double amount;
    private String dueDate;
    private String status;
    private Long user;
    private String servicesList;
    private long rentalAmount;

    public Invoice(Long compartment, Compartment compartmentObject, LocalDate dateIssued, String forTheMonthOf, double amount, String dueDate, String status, Long user, String servicesList, long rentalAmount) {
        this.compartment = compartment;
        this.compartmentObject = compartmentObject;
        this.dateIssued = dateIssued;
        this.forTheMonthOf = forTheMonthOf;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
        this.servicesList = servicesList;
        this.rentalAmount = rentalAmount;
    }

    public Long getId() {
        return this.id;
    }

    public Long getCompartment() {
        return this.compartment;
    }

    public Compartment getCompartmentObject() {
        return this.compartmentObject;
    }

    public LocalDate getDateIssued() {
        return this.dateIssued;
    }

    public String getForTheMonthOf() {
        return this.forTheMonthOf;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String getStatus() {
        return this.status;
    }

    public Long getUser() {
        return this.user;
    }

    public String getServicesList() {
        return this.servicesList;
    }

    public long getRentalAmount() {
        return this.rentalAmount;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCompartment(final Long compartment) {
        this.compartment = compartment;
    }

    public void setCompartmentObject(final Compartment compartmentObject) {
        this.compartmentObject = compartmentObject;
    }

    public void setDateIssued(final LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public void setForTheMonthOf(final String forTheMonthOf) {
        this.forTheMonthOf = forTheMonthOf;
    }

    public void setAmount(final double amount) {
        this.amount = amount;
    }

    public void setDueDate(final String dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUser(final Long user) {
        this.user = user;
    }

    public void setServicesList(final String servicesList) {
        this.servicesList = servicesList;
    }

    public void setRentalAmount(final long rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public String toString() {
        return "Invoice(id=" + this.getId() + ", compartment=" + this.getCompartment() + ", compartmentObject=" + this.getCompartmentObject() + ", dateIssued=" + this.getDateIssued() + ", forTheMonthOf=" + this.getForTheMonthOf() + ", amount=" + this.getAmount() + ", dueDate=" + this.getDueDate() + ", status=" + this.getStatus() + ", user=" + this.getUser() + ", servicesList=" + this.getServicesList() + ", rentalAmount=" + this.getRentalAmount() + ")";
    }

    public Invoice() {
    }

    public Invoice(final Long id, final Long compartment, final Compartment compartmentObject, final LocalDate dateIssued, final String forTheMonthOf, final double amount, final String dueDate, final String status, final Long user, final String servicesList, final long rentalAmount) {
        this.id = id;
        this.compartment = compartment;
        this.compartmentObject = compartmentObject;
        this.dateIssued = dateIssued;
        this.forTheMonthOf = forTheMonthOf;
        this.amount = amount;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
        this.servicesList = servicesList;
        this.rentalAmount = rentalAmount;
    }
}
