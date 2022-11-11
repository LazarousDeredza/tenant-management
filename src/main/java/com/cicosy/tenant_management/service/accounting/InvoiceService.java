//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.accounting;

import com.cicosy.tenant_management.model.accounting.Invoice;
import com.cicosy.tenant_management.repository.accounting.InvoiceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Invoice save(Invoice invoice) {
        this.invoiceRepository.save(invoice);
        return (Invoice)this.invoiceRepository.findById(invoice.getId()).orElseThrow(() -> {
            return new IllegalStateException("Saving Failed");
        });
    }

    public List<Invoice> getAll() {
        return this.invoiceRepository.findAll();
    }

    public List<Invoice> getByTenant(Long id) {
        return this.invoiceRepository.findByCompartment(id);
    }

    public Invoice getById(Long id) {
        return (Invoice)this.invoiceRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Invoice with " + id + " does not exist");
        });
    }

    public void delete(Long id) {
        this.invoiceRepository.deleteById(id);
    }

    public List<Invoice> getInvoiceForSpecificCompartment(Long id) {
        return this.invoiceRepository.findByCompartment(id);
    }
}
