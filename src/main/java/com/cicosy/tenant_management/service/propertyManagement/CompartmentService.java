//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.propertyManagement;

import com.cicosy.tenant_management.model.propertyManagement.Compartment;
import com.cicosy.tenant_management.repository.propertyManagement.CompartmentRepository;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompartmentService {
    CompartmentRepository compartmentRepository;

    @Autowired
    public CompartmentService(CompartmentRepository compartmentRepository) {
        this.compartmentRepository = compartmentRepository;
    }

    public Compartment save(Compartment compartment) {
        this.compartmentRepository.save(compartment);
        return (Compartment)this.compartmentRepository.findById(compartment.getId()).orElseThrow(() -> {
            return new IllegalStateException("Compartment with id: " + compartment.getId() + " does not exist");
        });
    }

    public Compartment getCompartment(Long id) {
        return (Compartment)this.compartmentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Compartment with id: " + id + " does not exist");
        });
    }

    public List<Compartment> getCompartments() {
        return this.compartmentRepository.findAll();
    }

    public List<Compartment> getCompartmentsForSpecificProperty(Long id) {
        return this.compartmentRepository.findByProperty(id);
    }

    @Transactional
    public Compartment update(Long id, Compartment update) {
        Compartment compartment = (Compartment)this.compartmentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Compartment with id: " + id + " does not exist");
        });
        if (update.getTenant() != null && !Objects.equals(compartment.getTenant(), update.getTenant())) {
            compartment.setTenant(update.getTenant());
        }

        if (update.getStatus() != null && !Objects.equals(compartment.getStatus(), update.getStatus())) {
            compartment.setStatus(update.getStatus());
        }

        return (Compartment)this.compartmentRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Compartment with id: " + id + " does not exist");
        });
    }

    public List<Compartment> getCompartmentsForSpecificTenant(Long id) {
        return this.compartmentRepository.findByTenant(id);
    }
}
