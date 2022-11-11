//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.controler.tenantManagement;

import com.cicosy.tenant_management.controler.propertyManagement.CompartmentController2;
import com.cicosy.tenant_management.model.tenantManagement.Tenant;
import com.cicosy.tenant_management.repository.leaseManagement.LeaseRepository;
import com.cicosy.tenant_management.service.tenantService.TenantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/tenants"})
public class TenantController {
    @Autowired
    private TenantService tenantService;
    private LeaseRepository leaseRepository;
    private CompartmentController2 compartmentController;

    @Autowired
    public TenantController(TenantService tenantService, CompartmentController2 compartmentController) {
        this.tenantService = tenantService;
        this.compartmentController = compartmentController;
    }

    @GetMapping({"/get-all-tenants"})
    public List<Tenant> getTenants() {
        List<Tenant> tenants = this.tenantService.getAllTenants();

        for(int i = 0; i < tenants.size(); ++i) {
            ((Tenant)tenants.get(i)).setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(((Tenant)tenants.get(i)).getId()));
        }

        return tenants;
    }

    @PostMapping({"/addTenant"})
    public Tenant addTenant(@RequestBody Tenant tenant) {
        return this.tenantService.addTenant(tenant);
    }

    @PostMapping({"/addTenants"})
    public List<Tenant> addTenants(@RequestBody List<Tenant> tenants) {
        return this.tenantService.addTenants(tenants);
    }

    @PutMapping({"/updateTenant/{id}"})
    public String updateTenant(@PathVariable Long id, @RequestBody Tenant tenant) {
        return this.tenantService.updateTenant(id, tenant);
    }

    @GetMapping({"/getTenant/{id}"})
    public Tenant getTenantById(@RequestBody Tenant tenant, @PathVariable Long id) {
        return this.tenantService.getTenantById(tenant, id);
    }

    @GetMapping({"/getTenantByID/{id}"})
    public Tenant getTenantByID(@PathVariable Long id) {
        Tenant tenant = this.tenantService.getTenantByID(id);
        tenant.setCompartmentObjectlist(this.compartmentController.getCompartmentsForSpecificTenant(tenant.getId()));
        return tenant;
    }

    public Tenant getTenant(Long id) {
        return this.tenantService.getTenant(id);
    }

    @GetMapping({"/getTenant/{name}"})
    public Tenant getTenantByName(@RequestBody Tenant tenant, @PathVariable String name) {
        return this.tenantService.getTenantByName(tenant, name);
    }
}
