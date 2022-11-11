//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.propertyManagement;

import com.cicosy.tenant_management.model.propertyManagement.Insurance;
import com.cicosy.tenant_management.repository.propertyManagement.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Insurance getInsurance(Long id) {
        return (Insurance)this.insuranceRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Insurance with id: " + id + " does not exist");
        });
    }
}
