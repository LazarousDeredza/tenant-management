//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.document_management;

import com.cicosy.tenant_management.model.document_management.ExpiredLeaseDocuments;
import com.cicosy.tenant_management.repository.document_management.ExpiredDocumentsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpiredLeaseService {
    @Autowired
    private ExpiredDocumentsRepo expiredDocumentsRepo;

    public ExpiredLeaseService(ExpiredDocumentsRepo expiredDocumentsRepo) {
        this.expiredDocumentsRepo = expiredDocumentsRepo;
    }

    public String storeDetails(ExpiredLeaseDocuments expiredLeaseDocuments) {
        this.expiredDocumentsRepo.save(expiredLeaseDocuments);
        return "success";
    }

    public ExpiredLeaseDocuments getEx(Long id) throws Exception {
        return (ExpiredLeaseDocuments)this.expiredDocumentsRepo.findById(id).orElseThrow(() -> {
            return new Exception("details not found");
        });
    }

    public List<ExpiredLeaseDocuments> getAllDocuments() {
        return this.expiredDocumentsRepo.findAll();
    }
}
