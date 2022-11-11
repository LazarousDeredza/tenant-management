//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.maintenanceManagement;

import com.cicosy.tenant_management.model.maintenanceManagement.AttendedRequest;
import com.cicosy.tenant_management.repository.maintenaceManagement.AttendedRequestRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendedRequestService {
    @Autowired
    private AttendedRequestRepo attendedRequestRepo;

    public AttendedRequestService() {
    }

    public List<AttendedRequest> getAll() {
        return this.attendedRequestRepo.findAll();
    }

    public void addAttended(AttendedRequest attendedRequestDetails) {
        this.attendedRequestRepo.save(attendedRequestDetails);
    }

    public List<AttendedRequest> getAttend() {
        return this.attendedRequestRepo.findAll();
    }
}
