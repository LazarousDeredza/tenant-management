//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.accounting;

import com.cicosy.tenant_management.model.accounting.TransactionType;
import com.cicosy.tenant_management.repository.accounting.TransactionTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {
    private final TransactionTypeRepository transactionTypeRepository;

    @Autowired
    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }

    public TransactionType save(TransactionType transactionType) {
        this.transactionTypeRepository.save(transactionType);
        return (TransactionType)this.transactionTypeRepository.findById(transactionType.getId()).orElseThrow(() -> {
            return new IllegalStateException("Saving Failed");
        });
    }

    public List<TransactionType> getAllTransationTypes() {
        return this.transactionTypeRepository.findAll();
    }

    public TransactionType getTransactionType(Long id) {
        return (TransactionType)this.transactionTypeRepository.getById(id);
    }
}
