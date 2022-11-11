
package com.cicosy.tenant_management.controler.accounting;

import com.cicosy.tenant_management.model.accounting.Services;
import com.cicosy.tenant_management.service.accounting.ServiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/services"})
public class ServiceController {
    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping({"/save-service"})
    public Services saveService(@RequestBody Services service) {
        return this.serviceService.save(service);
    }

    @GetMapping({"/get-all-services"})
    public List<Services> getAllServices() {
        return this.serviceService.getAllServices();
    }

    @GetMapping({"/get-specific-service/{id}"})
    public Services getService(@PathVariable Long id) {
        return this.serviceService.getService(id);
    }

    @DeleteMapping({"/delete-service/{id}"})
    public void deleteService(@PathVariable Long id) {
        this.serviceService.deleteService(id);
    }

    @PutMapping({"/updateService/{id}"})
    public void updateService(@PathVariable Long id, @RequestBody Services updateDetails) throws Exception {
        System.out.println(updateDetails);
        this.serviceService.updateService(id, updateDetails);
    }
}
