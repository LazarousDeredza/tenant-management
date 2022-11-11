//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.model.maintenanceManagement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonAutoDetect
public class Schedule {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private LocalDate scheduleDate;
    private String team;

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public LocalDate getScheduleDate() {
        if (this.scheduleDate.isBefore(LocalDate.now())) {
            this.setScheduleDate((LocalDate)null);
        }

        return this.scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Schedule)) {
            return false;
        } else {
            Schedule other = (Schedule)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$Id = this.getId();
                    Object other$Id = other.getId();
                    if (this$Id == null) {
                        if (other$Id == null) {
                            break label47;
                        }
                    } else if (this$Id.equals(other$Id)) {
                        break label47;
                    }

                    return false;
                }

                Object this$scheduleDate = this.getScheduleDate();
                Object other$scheduleDate = other.getScheduleDate();
                if (this$scheduleDate == null) {
                    if (other$scheduleDate != null) {
                        return false;
                    }
                } else if (!this$scheduleDate.equals(other$scheduleDate)) {
                    return false;
                }

                Object this$team = this.getTeam();
                Object other$team = other.getTeam();
                if (this$team == null) {
                    if (other$team != null) {
                        return false;
                    }
                } else if (!this$team.equals(other$team)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Schedule;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $Id = this.getId();
        result = result * 59 + ($Id == null ? 43 : $Id.hashCode());
        Object $scheduleDate = this.getScheduleDate();
        result = result * 59 + ($scheduleDate == null ? 43 : $scheduleDate.hashCode());
        Object $team = this.getTeam();
        result = result * 59 + ($team == null ? 43 : $team.hashCode());
        return result;
    }

    public String toString() {
        return "Schedule(Id=" + this.getId() + ", scheduleDate=" + this.getScheduleDate() + ", team=" + this.getTeam() + ")";
    }

    public Schedule(final Long Id, final LocalDate scheduleDate, final String team) {
        this.Id = Id;
        this.scheduleDate = scheduleDate;
        this.team = team;
    }

    public Schedule() {
    }
}
