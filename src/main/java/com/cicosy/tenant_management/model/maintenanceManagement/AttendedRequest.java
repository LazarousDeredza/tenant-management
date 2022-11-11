//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.maintenanceManagement;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AttendedRequest {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private String request;
    private String description;
    private LocalDate dateLogged;
    private String tenantId;
    private LocalDate dateAttended = LocalDate.now();

    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateLogged() {
        return this.dateLogged;
    }

    public void setDateLogged(LocalDate dateLogged) {
        this.dateLogged = dateLogged;
    }

    public LocalDate getDatAttended() {
        return this.dateAttended;
    }

    public void setDatAttended(LocalDate datAttended) {
        this.dateAttended = datAttended;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public LocalDate getDateAttended() {
        return this.dateAttended;
    }

    public void setDateAttended(final LocalDate dateAttended) {
        this.dateAttended = dateAttended;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AttendedRequest)) {
            return false;
        } else {
            AttendedRequest other = (AttendedRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$Id = this.getId();
                Object other$Id = other.getId();
                if (this$Id == null) {
                    if (other$Id != null) {
                        return false;
                    }
                } else if (!this$Id.equals(other$Id)) {
                    return false;
                }

                Object this$request = this.getRequest();
                Object other$request = other.getRequest();
                if (this$request == null) {
                    if (other$request != null) {
                        return false;
                    }
                } else if (!this$request.equals(other$request)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                label62: {
                    Object this$dateLogged = this.getDateLogged();
                    Object other$dateLogged = other.getDateLogged();
                    if (this$dateLogged == null) {
                        if (other$dateLogged == null) {
                            break label62;
                        }
                    } else if (this$dateLogged.equals(other$dateLogged)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$tenantId = this.getTenantId();
                    Object other$tenantId = other.getTenantId();
                    if (this$tenantId == null) {
                        if (other$tenantId == null) {
                            break label55;
                        }
                    } else if (this$tenantId.equals(other$tenantId)) {
                        break label55;
                    }

                    return false;
                }

                Object this$dateAttended = this.getDateAttended();
                Object other$dateAttended = other.getDateAttended();
                if (this$dateAttended == null) {
                    if (other$dateAttended != null) {
                        return false;
                    }
                } else if (!this$dateAttended.equals(other$dateAttended)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AttendedRequest;
    }

    public int hashCode() {
        boolean  PRIME = true;
        int result = 1;
        Object $Id = this.getId();
        result = result * 59 + ($Id == null ? 43 : $Id.hashCode());
        Object $request = this.getRequest();
        result = result * 59 + ($request == null ? 43 : $request.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $dateLogged = this.getDateLogged();
        result = result * 59 + ($dateLogged == null ? 43 : $dateLogged.hashCode());
        Object $tenantId = this.getTenantId();
        result = result * 59 + ($tenantId == null ? 43 : $tenantId.hashCode());
        Object $dateAttended = this.getDateAttended();
        result = result * 59 + ($dateAttended == null ? 43 : $dateAttended.hashCode());
        return result;
    }

    public String toString() {
        return "AttendedRequest(Id=" + this.getId() + ", request=" + this.getRequest() + ", description=" + this.getDescription() + ", dateLogged=" + this.getDateLogged() + ", tenantId=" + this.getTenantId() + ", dateAttended=" + this.getDateAttended() + ")";
    }

    public AttendedRequest(final Long Id, final String request, final String description, final LocalDate dateLogged, final String tenantId, final LocalDate dateAttended) {
        this.Id = Id;
        this.request = request;
        this.description = description;
        this.dateLogged = dateLogged;
        this.tenantId = tenantId;
        this.dateAttended = dateAttended;
    }

    public AttendedRequest() {
    }
}
