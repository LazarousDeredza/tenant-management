
package com.cicosy.tenant_management.controler.maintenanceManagement;

import com.cicosy.tenant_management.model.maintenanceManagement.AttendedRequest;
import com.cicosy.tenant_management.service.maintenanceManagement.AttendedRequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/maintenance"})
public class AttendedRequestController {
    @Autowired
    AttendedRequestService attendedRequestService;

    public AttendedRequestController() {
    }

    @PostMapping({"/attended"})
    public void attendedRequest(@RequestBody AttendedRequest attendedRequestDetails) {
        this.attendedRequestService.addAttended(attendedRequestDetails);
    }

    @RequestMapping({"getAllAttended"})
    public List<AttendedRequest> getAllAttended() {
        return this.attendedRequestService.getAttend();
    }
}
