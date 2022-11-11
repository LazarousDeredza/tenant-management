
package com.cicosy.tenant_management.controler.accounting;

import com.cicosy.tenant_management.model.accounting.TransactionType;
import com.cicosy.tenant_management.service.accounting.TransactionTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/transaction-type"})
public class TransactionTypeController {
    private TransactionTypeService transactionTypeService;

    @Autowired
    public TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @PostMapping({"/save-type"})
    public TransactionType saveTrasactionType(@RequestBody TransactionType transactionType) {
        return this.transactionTypeService.save(transactionType);
    }

    @GetMapping({"get-all-types"})
    public List<TransactionType> getTransationtypes() {
        return this.transactionTypeService.getAllTransationTypes();
    }

    @GetMapping({"/get-service/{id}"})
    public TransactionType getTransactionType(@PathVariable Long id) {
        return this.transactionTypeService.getTransactionType(id);
    }
}
