//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.maintenanceManagement;

import com.cicosy.tenant_management.model.maintenanceManagement.Schedule;
import com.cicosy.tenant_management.repository.maintenaceManagement.ScheduleRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepo scheduleRepo;

    public ScheduleService() {
    }

    public void addSchedule(Schedule schedule, Long id) {
        this.scheduleRepo.save(schedule);
    }

    public List<Schedule> getAllSchedule() {
        return this.scheduleRepo.findAll();
    }
}
