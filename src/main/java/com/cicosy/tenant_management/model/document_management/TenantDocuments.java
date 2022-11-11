//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.document_management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(
        name = "tenantDocuments"
)
public class TenantDocuments {
    @Id
    @SequenceGenerator(
            name = "tenantDocuments_sequence",
            sequenceName = "tenantDocuments_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tenantDocuments_sequence"
    )
    private Long id;
    private String tenantId;
    private String application_letter;
    private String cr14_form;
    private String cr6_form;
    private String certificate_of_incorporation;
    private String director_id;
    private String bank_statement;
    private String vat_reg;
    private String tax_clearance;
    private String article_of_association;
    private String company_profile;

    public TenantDocuments(String tenantId, String application_letter, String cr14_form, String cr6_form, String certificate_of_incorporation, String director_id, String bank_statement, String vat_reg, String tax_clearance, String article_of_association, String company_profile) {
        this.application_letter = application_letter;
        this.cr14_form = cr14_form;
        this.cr6_form = cr6_form;
        this.certificate_of_incorporation = certificate_of_incorporation;
        this.director_id = director_id;
        this.vat_reg = vat_reg;
        this.tax_clearance = tax_clearance;
        this.article_of_association = article_of_association;
        this.bank_statement = bank_statement;
        this.tenantId = tenantId;
        this.company_profile = company_profile;
    }

    public TenantDocuments() {
    }

    public TenantDocuments(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setCr14(String cr14_form) {
        this.cr14_form = cr14_form;
    }

    public void setCr6(String cr6_form) {
        this.cr6_form = cr6_form;
    }

    public void setVat(String vat_reg) {
        this.vat_reg = vat_reg;
    }

    public void setArticle(String article_of_association) {
        this.article_of_association = article_of_association;
    }

    public void setTax(String tax_clearance) {
        this.tax_clearance = tax_clearance;
    }

    public void setDirector(String director_id) {
        this.director_id = director_id;
    }

    public void setCertificate(String certificate_of_incorporation) {
        this.certificate_of_incorporation = certificate_of_incorporation;
    }

    public void setBankStatement(String bank_statement) {
        this.bank_statement = bank_statement;
    }

    public String getCr14() {
        return this.cr14_form;
    }

    public String getCr6() {
        return this.cr6_form;
    }

    public String getVat() {
        return this.vat_reg;
    }

    public String getArticle() {
        return this.article_of_association;
    }

    public String getTax() {
        return this.tax_clearance;
    }

    public String getDirector() {
        return this.director_id;
    }

    public String getCertificate() {
        return this.certificate_of_incorporation;
    }

    public String getBankStatement() {
        return this.bank_statement;
    }

    public String getApplication() {
        return this.application_letter;
    }

    public Long getId() {
        return this.id;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getCompany_profile() {
        return this.company_profile;
    }

    public void setCompany_profile(String company_profile) {
        this.company_profile = company_profile;
    }

    public void setApplication_letter(String application_letter) {
        this.application_letter = application_letter;
    }

    public String getApplication_letter() {
        return this.application_letter;
    }

    public String getCr14_form() {
        return this.cr14_form;
    }

    public String getCr6_form() {
        return this.cr6_form;
    }

    public String getCertificate_of_incorporation() {
        return this.certificate_of_incorporation;
    }

    public String getDirector_id() {
        return this.director_id;
    }

    public String getBank_statement() {
        return this.bank_statement;
    }

    public String getVat_reg() {
        return this.vat_reg;
    }

    public String getTax_clearance() {
        return this.tax_clearance;
    }

    public String getArticle_of_association() {
        return this.article_of_association;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }

    public void setCr14_form(final String cr14_form) {
        this.cr14_form = cr14_form;
    }

    public void setCr6_form(final String cr6_form) {
        this.cr6_form = cr6_form;
    }

    public void setCertificate_of_incorporation(final String certificate_of_incorporation) {
        this.certificate_of_incorporation = certificate_of_incorporation;
    }

    public void setDirector_id(final String director_id) {
        this.director_id = director_id;
    }

    public void setBank_statement(final String bank_statement) {
        this.bank_statement = bank_statement;
    }

    public void setVat_reg(final String vat_reg) {
        this.vat_reg = vat_reg;
    }

    public void setTax_clearance(final String tax_clearance) {
        this.tax_clearance = tax_clearance;
    }

    public void setArticle_of_association(final String article_of_association) {
        this.article_of_association = article_of_association;
    }

    public String toString() {
        return "TenantDocuments(id=" + this.getId() + ", tenantId=" + this.getTenantId() + ", application_letter=" + this.getApplication_letter() + ", cr14_form=" + this.getCr14_form() + ", cr6_form=" + this.getCr6_form() + ", certificate_of_incorporation=" + this.getCertificate_of_incorporation() + ", director_id=" + this.getDirector_id() + ", bank_statement=" + this.getBank_statement() + ", vat_reg=" + this.getVat_reg() + ", tax_clearance=" + this.getTax_clearance() + ", article_of_association=" + this.getArticle_of_association() + ", company_profile=" + this.getCompany_profile() + ")";
    }

    public TenantDocuments(final Long id, final String tenantId, final String application_letter, final String cr14_form, final String cr6_form, final String certificate_of_incorporation, final String director_id, final String bank_statement, final String vat_reg, final String tax_clearance, final String article_of_association, final String company_profile) {
        this.id = id;
        this.tenantId = tenantId;
        this.application_letter = application_letter;
        this.cr14_form = cr14_form;
        this.cr6_form = cr6_form;
        this.certificate_of_incorporation = certificate_of_incorporation;
        this.director_id = director_id;
        this.bank_statement = bank_statement;
        this.vat_reg = vat_reg;
        this.tax_clearance = tax_clearance;
        this.article_of_association = article_of_association;
        this.company_profile = company_profile;
    }
}
