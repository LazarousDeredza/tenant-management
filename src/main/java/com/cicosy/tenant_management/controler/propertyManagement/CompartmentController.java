//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.controler.propertyManagement;

import com.cicosy.tenant_management.controler.leaseManagement.LeaseController;
import com.cicosy.tenant_management.controler.tenantManagement.TenantController;
import com.cicosy.tenant_management.model.propertyManagement.Compartment;
import com.cicosy.tenant_management.service.propertyManagement.CompartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(
        path = {"/api/compartment"}
)
public class CompartmentController {
    CompartmentService compartmentService;
    TenantController tenantController;
    LeaseController leaseController;

    @Autowired
    public CompartmentController(CompartmentService compartmentService, TenantController tenantController, LeaseController leaseController) {
        this.compartmentService = compartmentService;
        this.tenantController = tenantController;
        this.leaseController = leaseController;
    }

    @PostMapping({"/save-compartment"})
    public Compartment saveCompartment(@RequestBody Compartment compartment) {
        return this.compartmentService.save(compartment);
    }

    @GetMapping({"/get-compartments"})
    public List<Compartment> getCompartments() {
        List<Compartment> compartments = this.compartmentService.getCompartments();

        for(int i = 0; i < compartments.size(); ++i) {
            if (((Compartment)compartments.get(i)).getTenant() != null) {
                ((Compartment)compartments.get(i)).setTenantObject(this.tenantController.getTenant(((Compartment)compartments.get(i)).getTenant()));
            }
        }

        return compartments;
    }

    @GetMapping({"/get-compartments-for-specific-property/{id}"})
    public List<Compartment> getCompartmentsForSpecificPropertyApi(@PathVariable Long id) {
        List<Compartment> compartments = this.compartmentService.getCompartmentsForSpecificProperty(id);

        for(int i = 0; i < compartments.size(); ++i) {
            if (((Compartment)compartments.get(i)).getTenant() != null) {
                ((Compartment)compartments.get(i)).setTenantObject(this.tenantController.getTenant(((Compartment)compartments.get(i)).getTenant()));
            }
        }

        return compartments;
    }

    public List<Compartment> getCompartmentsForSpecificProperty(Long id) {
        List<Compartment> compartments = this.compartmentService.getCompartmentsForSpecificProperty(id);

        for(int i = 0; i < compartments.size(); ++i) {
            if (((Compartment)compartments.get(i)).getTenant() != null) {
                ((Compartment)compartments.get(i)).setTenantObject(this.tenantController.getTenant(((Compartment)compartments.get(i)).getTenant()));
            }
        }

        return compartments;
    }

    @GetMapping({"/get-compartment/{id}"})
    public Compartment getCompartmentSpecificCompartment(@PathVariable Long id) {
        Compartment compartment = this.compartmentService.getCompartment(id);
        if (compartment.getTenant() != null) {
            compartment.setTenantObject(this.tenantController.getTenant(compartment.getTenant()));
        }

        return compartment;
    }

    public Compartment getCompartment(Long id) {
        Compartment compartment = this.compartmentService.getCompartment(id);
        if (compartment.getTenant() != null) {
            compartment.setTenantObject(this.tenantController.getTenant(compartment.getTenant()));
        }

        return compartment;
    }

    @PutMapping({"/update-compartment/{id}"})
    public Compartment updateCompartment(@PathVariable Long id, @RequestBody Compartment compartment) {
        return this.compartmentService.update(id, compartment);
    }
}
