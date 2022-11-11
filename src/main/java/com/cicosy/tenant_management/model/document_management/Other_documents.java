//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.document_management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(
        name = "other_documents"
)
public class Other_documents {
    @Id
    @SequenceGenerator(
            name = "otherDocuments_sequence",
            sequenceName = "otherDocuments_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "otherDocuments_sequence"
    )
    private Long id;
    @Column(
            name = "tenantId"
    )
    private String tenantId;
    @Column(
            name = "document_name"
    )
    private String document_name;
    @Column(
            name = "otherFile"
    )
    private String otherFile;

    public Other_documents() {
    }

    public Other_documents(String tenantId, String document_name, String otherFile) {
        this.tenantId = tenantId;
        this.document_name = document_name;
        this.otherFile = otherFile;
    }

    public Long getId() {
        return this.id;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getDocument_name() {
        return this.document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getOtherFile() {
        return this.otherFile;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setOtherFile(final String otherFile) {
        this.otherFile = otherFile;
    }

    public String toString() {
        return "Other_documents(id=" + this.getId() + ", tenantId=" + this.getTenantId() + ", document_name=" + this.getDocument_name() + ", otherFile=" + this.getOtherFile() + ")";
    }

    public Other_documents(final Long id, final String tenantId, final String document_name, final String otherFile) {
        this.id = id;
        this.tenantId = tenantId;
        this.document_name = document_name;
        this.otherFile = otherFile;
    }
}
