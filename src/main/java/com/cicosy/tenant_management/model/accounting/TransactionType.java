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
public class TransactionType {
    @Id
    @SequenceGenerator(
            name = "type_sequence",
            sequenceName = "type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "type_sequence"
    )
    private Long id;
    private String type;

    public TransactionType(String type) {
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String toString() {
        return "TransactionType(id=" + this.getId() + ", type=" + this.getType() + ")";
    }

    public TransactionType() {
    }

    public TransactionType(final Long id, final String type) {
        this.id = id;
        this.type = type;
    }
}
