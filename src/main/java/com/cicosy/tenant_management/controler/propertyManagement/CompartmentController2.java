//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.controler.propertyManagement;

import com.cicosy.tenant_management.model.propertyManagement.Compartment;
import com.cicosy.tenant_management.model.tenantManagement.Tenant;
import com.cicosy.tenant_management.service.propertyManagement.CompartmentService;
import com.cicosy.tenant_management.service.tenantService.TenantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/compartment2"}
)
public class CompartmentController2 {
    private CompartmentService compartmentService;
    private TenantService tenantService;

    @Autowired
    public CompartmentController2(CompartmentService compartmentService, TenantService tenantService) {
        this.compartmentService = compartmentService;
        this.tenantService = tenantService;
    }

    public List<Compartment> getCompartmentsForSpecificTenant(Long id) {
        return this.compartmentService.getCompartmentsForSpecificTenant(id);
    }

    public Tenant getTenantForSpecificLease(int tenant_id) {
        return this.tenantService.getTenantByID(Long.parseLong(String.valueOf(tenant_id)));
    }
}
