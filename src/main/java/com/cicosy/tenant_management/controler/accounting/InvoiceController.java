
package com.cicosy.tenant_management.controler.accounting;

import com.cicosy.tenant_management.controler.propertyManagement.CompartmentController;
import com.cicosy.tenant_management.model.accounting.Invoice;
import com.cicosy.tenant_management.service.accounting.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/invoice"})
public class InvoiceController {
    public final InvoiceService invoiceService;
    private final CompartmentController compartmentController;

    @Autowired
    public InvoiceController(InvoiceService invoiceService, CompartmentController compartmentController) {
        this.invoiceService = invoiceService;
        this.compartmentController = compartmentController;
    }

    @PostMapping({"/save-invoice"})
    public Invoice saveInvoice(@RequestBody Invoice invoice) {
        return this.invoiceService.save(invoice);
    }

    @GetMapping({"/get-all-invoices"})
    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = this.invoiceService.getAll();

        for(int i = 0; i < invoices.size(); ++i) {
            ((Invoice)invoices.get(i)).setCompartmentObject(this.compartmentController.getCompartmentSpecificCompartment(((Invoice)invoices.get(i)).getCompartment()));
        }

        System.out.println(invoices);
        return invoices;
    }

    @GetMapping({"/get/invoices-by-tenant/{id}"})
    public List<Invoice> getByTenant(@PathVariable Long id) {
        return this.invoiceService.getByTenant(id);
    }

    @GetMapping({"/get-specifc-invoice/{id}"})
    public Invoice getSpecificInvoice(Long id) {
        return this.invoiceService.getById(id);
    }

    @GetMapping({"/get-invoice-for-specic-compartment/{id}"})
    public List<Invoice> getInvoiceForCompartment(@PathVariable Long id) {
        return this.invoiceService.getInvoiceForSpecificCompartment(id);
    }

    @DeleteMapping({"/delete/{id}"})
    public void deleteInvoice(@PathVariable Long id) {
        this.invoiceService.delete(id);
    }
}