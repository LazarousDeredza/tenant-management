//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.controler.maintenanceManagement;

import com.cicosy.tenant_management.model.maintenanceManagement.Schedule;
import com.cicosy.tenant_management.service.maintenanceManagement.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/maintenance"})
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    public ScheduleController() {
    }

    @PostMapping({"/{id}/schedule"})
    public void addSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        this.scheduleService.addSchedule(schedule, id);
    }

    @RequestMapping({"getAllSchedule"})
    public List<Schedule> getAllMaintenanceRequests() {
        return this.scheduleService.getAllSchedule();
    }
}
