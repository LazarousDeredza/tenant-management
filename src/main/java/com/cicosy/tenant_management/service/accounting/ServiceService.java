//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.accounting;

import com.cicosy.tenant_management.model.accounting.Services;
import com.cicosy.tenant_management.repository.accounting.ServiceRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Services save(Services service) {
        Optional<Services> serviceName = this.serviceRepository.findServicesByServiceName(service.getServiceName());
        if (serviceName.isPresent()) {
            throw new IllegalStateException("Record with provided name already Exists");
        } else {
            this.serviceRepository.save(service);
            return (Services)this.serviceRepository.findById(service.getId()).orElseThrow(() -> {
                return new IllegalStateException("Saving Failed");
            });
        }
    }

    public List<Services> getAllServices() {
        return this.serviceRepository.findAll();
    }

    public Services getService(Long id) {
        return (Services)this.serviceRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Service with " + id + " not found");
        });
    }

    public void deleteService(Long id) {
        this.serviceRepository.deleteAllById(Collections.singleton(id));
    }

    public void updateService(Long id, Services updateDetails) throws Exception {
        System.out.println(updateDetails);
        Services service = (Services)this.serviceRepository.findById(id).orElseThrow(() -> {
            return new Exception("Service with id :" + id + " does not exist");
        });
        service.setServiceName(updateDetails.getServiceName());
        service.setAmount(updateDetails.getAmount());
        this.serviceRepository.save(service);
    }
}
