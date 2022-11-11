//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.maintenanceManagement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@JsonAutoDetect
public class MaintenanceRequests {
    @Id
    @SequenceGenerator(
            name = "maintenanceRequest_sequence",
            sequenceName = "maintenanceRequest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "maintenanceRequest_sequence"
    )
    private Long id;
    private String request;
    private String description;
    private String levelOfUrgency;
    private String tenantId;
    private LocalDate dateLogged = LocalDate.now();
    private LocalDate overdueDate = LocalDate.now().plusDays(7L);
    private String status;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "fk_id"
    )
    private Schedule schedule;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLevelOfUrgency() {
        return this.levelOfUrgency;
    }

    public void setLevelOfUrgency(String levelOfUrgency) {
        this.levelOfUrgency = levelOfUrgency;
    }

    public LocalDate getDateLogged() {
        return this.dateLogged;
    }

    public void setDateLogged(LocalDate dateLogged) {
        this.dateLogged = dateLogged;
    }

    public LocalDate getOverdueDate() {
        return this.overdueDate;
    }

    public void setOverdueDate(LocalDate overdueDate) {
        this.overdueDate = overdueDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MaintenanceRequests)) {
            return false;
        } else {
            MaintenanceRequests other = (MaintenanceRequests)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label119: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label119;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label119;
                    }

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

                label105: {
                    Object this$description = this.getDescription();
                    Object other$description = other.getDescription();
                    if (this$description == null) {
                        if (other$description == null) {
                            break label105;
                        }
                    } else if (this$description.equals(other$description)) {
                        break label105;
                    }

                    return false;
                }

                Object this$levelOfUrgency = this.getLevelOfUrgency();
                Object other$levelOfUrgency = other.getLevelOfUrgency();
                if (this$levelOfUrgency == null) {
                    if (other$levelOfUrgency != null) {
                        return false;
                    }
                } else if (!this$levelOfUrgency.equals(other$levelOfUrgency)) {
                    return false;
                }

                label91: {
                    Object this$tenantId = this.getTenantId();
                    Object other$tenantId = other.getTenantId();
                    if (this$tenantId == null) {
                        if (other$tenantId == null) {
                            break label91;
                        }
                    } else if (this$tenantId.equals(other$tenantId)) {
                        break label91;
                    }

                    return false;
                }

                Object this$dateLogged = this.getDateLogged();
                Object other$dateLogged = other.getDateLogged();
                if (this$dateLogged == null) {
                    if (other$dateLogged != null) {
                        return false;
                    }
                } else if (!this$dateLogged.equals(other$dateLogged)) {
                    return false;
                }

                label77: {
                    Object this$overdueDate = this.getOverdueDate();
                    Object other$overdueDate = other.getOverdueDate();
                    if (this$overdueDate == null) {
                        if (other$overdueDate == null) {
                            break label77;
                        }
                    } else if (this$overdueDate.equals(other$overdueDate)) {
                        break label77;
                    }

                    return false;
                }

                label70: {
                    Object this$status = this.getStatus();
                    Object other$status = other.getStatus();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label70;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label70;
                    }

                    return false;
                }

                Object this$schedule = this.getSchedule();
                Object other$schedule = other.getSchedule();
                if (this$schedule == null) {
                    if (other$schedule != null) {
                        return false;
                    }
                } else if (!this$schedule.equals(other$schedule)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MaintenanceRequests;
    }

    public int hashCode() {
        boolean  PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $request = this.getRequest();
        result = result * 59 + ($request == null ? 43 : $request.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $levelOfUrgency = this.getLevelOfUrgency();
        result = result * 59 + ($levelOfUrgency == null ? 43 : $levelOfUrgency.hashCode());
        Object $tenantId = this.getTenantId();
        result = result * 59 + ($tenantId == null ? 43 : $tenantId.hashCode());
        Object $dateLogged = this.getDateLogged();
        result = result * 59 + ($dateLogged == null ? 43 : $dateLogged.hashCode());
        Object $overdueDate = this.getOverdueDate();
        result = result * 59 + ($overdueDate == null ? 43 : $overdueDate.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $schedule = this.getSchedule();
        result = result * 59 + ($schedule == null ? 43 : $schedule.hashCode());
        return result;
    }

    public String toString() {
        return "MaintenanceRequests(id=" + this.getId() + ", request=" + this.getRequest() + ", description=" + this.getDescription() + ", levelOfUrgency=" + this.getLevelOfUrgency() + ", tenantId=" + this.getTenantId() + ", dateLogged=" + this.getDateLogged() + ", overdueDate=" + this.getOverdueDate() + ", status=" + this.getStatus() + ", schedule=" + this.getSchedule() + ")";
    }

    public MaintenanceRequests() {
    }

    public MaintenanceRequests(final Long id, final String request, final String description, final String levelOfUrgency, final String tenantId, final LocalDate dateLogged, final LocalDate overdueDate, final String status, final Schedule schedule) {
        this.id = id;
        this.request = request;
        this.description = description;
        this.levelOfUrgency = levelOfUrgency;
        this.tenantId = tenantId;
        this.dateLogged = dateLogged;
        this.overdueDate = overdueDate;
        this.status = status;
        this.schedule = schedule;
    }
}
