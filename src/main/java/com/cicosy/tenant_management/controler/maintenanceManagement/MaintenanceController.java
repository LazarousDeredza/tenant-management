
package com.cicosy.tenant_management.controler.maintenanceManagement;

import com.cicosy.tenant_management.model.maintenanceManagement.AttendedRequest;
import com.cicosy.tenant_management.model.maintenanceManagement.MaintenanceRequests;
import com.cicosy.tenant_management.service.maintenanceManagement.MaintenanceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/maintenance"})
public class MaintenanceController {
    @Autowired
    private MaintenanceService maintenanceService;

    public MaintenanceController() {
    }

    @RequestMapping({"getAll"})
    public List<MaintenanceRequests> getAllMaintenanceRequests() {
        return this.maintenanceService.getAllMaintenanceRequests();
    }

    @RequestMapping({"getAllScheduled"})
    public List<MaintenanceRequests> getAllScheduled() {
        return this.maintenanceService.getScheduled();
    }

    @GetMapping({"/{id}"})
    public MaintenanceRequests getMaintenanceRequestsById(@PathVariable Long id) throws Exception {
        return this.maintenanceService.getMaintenanceRequestsById(id);
    }

    @GetMapping(
            path = {"/status/{status}"}
    )
    public List<MaintenanceRequests> getMaintenanceRequestsByStatus(@PathVariable String status) {
        return this.maintenanceService.overdueRequest(status);
    }

    @PostMapping
    public void addStudent(@RequestBody MaintenanceRequests maintenanceRequest) {
        this.maintenanceService.addMaintenanceRequest(maintenanceRequest);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable Long id, @RequestBody MaintenanceRequests requestDetails) throws Exception {
        this.maintenanceService.updateMaintenanceRequest(id, requestDetails);
    }

    @PutMapping({"/{id}/schedule"})
    public void addSchedule(@PathVariable Long id, @RequestBody MaintenanceRequests scheduleDetails) throws Exception {
        this.maintenanceService.addSchedule(id, scheduleDetails);
    }

    @DeleteMapping({"/attended/{id}"})
    public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Long id, AttendedRequest attendedRequestDetails) {
        return this.maintenanceService.deleteRequest(id, attendedRequestDetails);
    }
}
