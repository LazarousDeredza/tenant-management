//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.tenantService;

import com.cicosy.tenant_management.model.tenantManagement.Tenant;
import com.cicosy.tenant_management.repository.leaseManagement.LeaseRepository;
import com.cicosy.tenant_management.repository.tenantManagement.TenantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {
    private TenantRepository tenantRepository;
    private LeaseRepository leaseRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository, LeaseRepository leaseRepository) {
        this.tenantRepository = tenantRepository;
        this.leaseRepository = leaseRepository;
    }

    public Tenant addTenant(Tenant tenant) {
        return (Tenant)this.tenantRepository.save(tenant);
    }

    public List<Tenant> addTenants(List<Tenant> tenants) {
        return this.tenantRepository.saveAll(tenants);
    }

    public String updateTenant(Long id, Tenant tenant) {
        Tenant existing_tenant = (Tenant)this.tenantRepository.getById(id);
        existing_tenant.setPhone(tenant.getPhone());
        existing_tenant.setName(tenant.getName());
        existing_tenant.setProperty(tenant.getProperty());
        existing_tenant.setId_passport(tenant.getId_passport());
        this.tenantRepository.save(existing_tenant);
        return "Tenant updated successfully";
    }

    public List<Tenant> getAll() {
        return this.tenantRepository.findAll();
    }

    public List<Tenant> getAllTenants() {
        return this.tenantRepository.findAll();
    }

    public Tenant getTenantById(Tenant tenant, Long id) {
        Tenant existing_tenant = (Tenant)this.tenantRepository.getById(id);
        return existing_tenant;
    }

    public Tenant getTenantByID(Long id) {
        return (Tenant)this.tenantRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Tenant With ID " + id + " Does Not Exist");
        });
    }

    public Tenant getTenantByName(Tenant tenant, String name) {
        Tenant existing_tenant = this.tenantRepository.getByName(name);
        return existing_tenant;
    }

    public Tenant getTenant(Long id) {
        return (Tenant)this.tenantRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Tenant with id" + id + " does not exist");
        });
    }
}
