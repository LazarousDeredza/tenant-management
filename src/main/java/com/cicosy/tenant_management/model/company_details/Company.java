//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.company_details;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(
        name = "company_details"
)
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;
    private String company_name;
    private String company_location;
    private String company_logo;
    private String company_banner;

    public Long getId() {
        return this.id;
    }

    public String getCompany_name() {
        return this.company_name;
    }

    public String getCompany_location() {
        return this.company_location;
    }

    public String getCompany_logo() {
        return this.company_logo;
    }

    public String getCompany_banner() {
        return this.company_banner;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setCompany_name(final String company_name) {
        this.company_name = company_name;
    }

    public void setCompany_location(final String company_location) {
        this.company_location = company_location;
    }

    public void setCompany_logo(final String company_logo) {
        this.company_logo = company_logo;
    }

    public void setCompany_banner(final String company_banner) {
        this.company_banner = company_banner;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Company)) {
            return false;
        } else {
            Company other = (Company)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label71: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label71;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label71;
                    }

                    return false;
                }

                Object this$company_name = this.getCompany_name();
                Object other$company_name = other.getCompany_name();
                if (this$company_name == null) {
                    if (other$company_name != null) {
                        return false;
                    }
                } else if (!this$company_name.equals(other$company_name)) {
                    return false;
                }

                label57: {
                    Object this$company_location = this.getCompany_location();
                    Object other$company_location = other.getCompany_location();
                    if (this$company_location == null) {
                        if (other$company_location == null) {
                            break label57;
                        }
                    } else if (this$company_location.equals(other$company_location)) {
                        break label57;
                    }

                    return false;
                }

                Object this$company_logo = this.getCompany_logo();
                Object other$company_logo = other.getCompany_logo();
                if (this$company_logo == null) {
                    if (other$company_logo != null) {
                        return false;
                    }
                } else if (!this$company_logo.equals(other$company_logo)) {
                    return false;
                }

                Object this$company_banner = this.getCompany_banner();
                Object other$company_banner = other.getCompany_banner();
                if (this$company_banner == null) {
                    if (other$company_banner == null) {
                        return true;
                    }
                } else if (this$company_banner.equals(other$company_banner)) {
                    return true;
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Company;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $company_name = this.getCompany_name();
        result = result * 59 + ($company_name == null ? 43 : $company_name.hashCode());
        Object $company_location = this.getCompany_location();
        result = result * 59 + ($company_location == null ? 43 : $company_location.hashCode());
        Object $company_logo = this.getCompany_logo();
        result = result * 59 + ($company_logo == null ? 43 : $company_logo.hashCode());
        Object $company_banner = this.getCompany_banner();
        result = result * 59 + ($company_banner == null ? 43 : $company_banner.hashCode());
        return result;
    }

    public String toString() {
        return "Company(id=" + this.getId() + ", company_name=" + this.getCompany_name() + ", company_location=" + this.getCompany_location() + ", company_logo=" + this.getCompany_logo() + ", company_banner=" + this.getCompany_banner() + ")";
    }

    public Company(final Long id, final String company_name, final String company_location, final String company_logo, final String company_banner) {
        this.id = id;
        this.company_name = company_name;
        this.company_location = company_location;
        this.company_logo = company_logo;
        this.company_banner = company_banner;
    }

    public Company() {
    }
}
