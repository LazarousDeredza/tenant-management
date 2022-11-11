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
public class Method {
    @Id
    @SequenceGenerator(
            name = "method_sequence",
            sequenceName = "method_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "method_sequence"
    )
    private Long id;
    private String method;

    public Method(String method) {
        this.method = method;
    }

    public Long getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setMethod(final String method) {
        this.method = method;
    }

    public String toString() {
        return "Method(id=" + this.getId() + ", method=" + this.getMethod() + ")";
    }

    public Method() {
    }

    public Method(final Long id, final String method) {
        this.id = id;
        this.method = method;
    }
}
