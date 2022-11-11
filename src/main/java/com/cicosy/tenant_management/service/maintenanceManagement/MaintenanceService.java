//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.maintenanceManagement;

import com.cicosy.tenant_management.model.maintenanceManagement.AttendedRequest;
import com.cicosy.tenant_management.model.maintenanceManagement.MaintenanceRequests;
import com.cicosy.tenant_management.repository.maintenaceManagement.AttendedRequestRepo;
import com.cicosy.tenant_management.repository.maintenaceManagement.MaintenanceRepo;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepo maintenanceRepo;
    @Autowired
    private AttendedRequestRepo attendedRequestRepo;

    public void setStatus() {
        List<MaintenanceRequests> maintenanceRequest = this.maintenanceRepo.findAll();

        for(int i = 0; i < this.maintenanceRepo.findAll().size(); ++i) {
            Long maintenanceRequestId = ((MaintenanceRequests)maintenanceRequest.get(i)).getId();
            MaintenanceRequests maintenanceRequests = (MaintenanceRequests)this.maintenanceRepo.findById(maintenanceRequestId).orElseThrow(() -> {
                return new IllegalStateException("Request with Id" + maintenanceRequestId + "does not exist");
            });
            if (maintenanceRequests.getOverdueDate().isBefore(LocalDate.now())) {
                maintenanceRequests.setStatus("Overdue");
            } else {
                maintenanceRequests.setStatus("Pending");
            }
        }

    }

    @Transactional
    public List<MaintenanceRequests> getAllMaintenanceRequests() {
        this.setStatus();
        return this.maintenanceRepo.findAll();
    }

    public List<MaintenanceRequests> getScheduled() {
        this.setStatus();
        return this.maintenanceRepo.findByScheduleNotNull();
    }

    public MaintenanceRequests getMaintenanceRequestsById(long Id) throws Exception {
        return (MaintenanceRequests)this.maintenanceRepo.findById(Id).orElseThrow(() -> {
            return new Exception("MaintenanceRequest is not found");
        });
    }

    @Transactional
    public List<MaintenanceRequests> overdueRequest(String status) {
        this.setStatus();
        return this.maintenanceRepo.getMaintenanceRequestsByStatus(status);
    }

    public void addMaintenanceRequest(MaintenanceRequests maintenanceRequest) {
        this.maintenanceRepo.save(maintenanceRequest);
    }

    public void updateMaintenanceRequest(Long id, MaintenanceRequests requestDetails) throws Exception {
        MaintenanceRequests maintenanceRequest = (MaintenanceRequests)this.maintenanceRepo.findById(id).orElseThrow(() -> {
            return new Exception("Employee with id :" + id + " does not exist");
        });
        maintenanceRequest.setRequest(requestDetails.getRequest());
        maintenanceRequest.setDateLogged(requestDetails.getDateLogged());
        maintenanceRequest.setLevelOfUrgency(requestDetails.getLevelOfUrgency());
        maintenanceRequest.setDescription(requestDetails.getDescription());
        maintenanceRequest.setStatus(requestDetails.getStatus());
        MaintenanceRequests updatedMaintenanceRequest = (MaintenanceRequests)this.maintenanceRepo.save(maintenanceRequest);
    }

    public void addSchedule(Long id, MaintenanceRequests scheduleDetails) throws Exception {
        MaintenanceRequests maintenanceRequest = (MaintenanceRequests)this.maintenanceRepo.findById(id).orElseThrow(() -> {
            return new Exception("Employee not exist with id :" + id);
        });
        maintenanceRequest.setSchedule(scheduleDetails.getSchedule());
        this.maintenanceRepo.save(maintenanceRequest);
    }

    public ResponseEntity<Map<String, Boolean>> deleteRequest(@PathVariable Long id, AttendedRequest attendedRequestDetails) {
        AttendedRequest attendedRequest = new AttendedRequest();
        attendedRequest.setRequest(attendedRequestDetails.getRequest());
        attendedRequest.setDescription(attendedRequestDetails.getDescription());
        attendedRequest.setDateLogged(attendedRequestDetails.getDateLogged());
        this.maintenanceRepo.deleteById(id);
        Map<String, Boolean> response = new HashMap();
        return ResponseEntity.ok(response);
    }

    public MaintenanceService(final MaintenanceRepo maintenanceRepo, final AttendedRequestRepo attendedRequestRepo) {
        this.maintenanceRepo = maintenanceRepo;
        this.attendedRequestRepo = attendedRequestRepo;
    }
}
