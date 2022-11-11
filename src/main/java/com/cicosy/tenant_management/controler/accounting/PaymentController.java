package com.cicosy.tenant_management.controler.accounting;

import com.cicosy.tenant_management.controler.propertyManagement.CompartmentController;
import com.cicosy.tenant_management.controler.propertyManagement.propertyController;
import com.cicosy.tenant_management.controler.tenantManagement.TenantController;
import com.cicosy.tenant_management.model.accounting.Payment;
import com.cicosy.tenant_management.service.accounting.PaymentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/payment"})
public class PaymentController {
    private final PaymentService paymentService;
    private final CompartmentController compartmentController;
    private final propertyController propertyController;
    private final TenantController tenantController;

    @Autowired
    public PaymentController(PaymentService paymentService, CompartmentController compartmentController, propertyController propertyController, TenantController tenantController) {
        this.paymentService = paymentService;
        this.compartmentController = compartmentController;
        this.propertyController = propertyController;
        this.tenantController = tenantController;
    }

    @PostMapping({"/save-payment"})
    public Payment savePayment(@RequestBody Payment payment) {
        System.out.println(payment.toString());
        return this.paymentService.save(payment);
    }

    @GetMapping({"/get-payments"})
    public List<Payment> getPayments() {
        List<Payment> payments = this.paymentService.getAll();

        for(int i = 0; i < payments.size(); ++i) {
            ((Payment)payments.get(i)).setCompartmentObject(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()));
            if (((Payment)payments.get(i)).getProperty() == null) {
                ((Payment)payments.get(i)).setPropertyObject(this.propertyController.getProperty(this.compartmentController.getCompartmentSpecificCompartment(((Payment)payments.get(i)).getCompartment()).getProperty()));
            } else {
                ((Payment)payments.get(i)).setPropertyObject(this.propertyController.getProperty(((Payment)payments.get(i)).getProperty()));
            }

            ((Payment)payments.get(i)).setTenantObject(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()).getTenantObject());
            System.out.println(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()).getTenantObject() + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        }

        System.out.println(payments);
        return payments;
    }

    @GetMapping({"/get-payments-for-specific-tenant/{id}"})
    public List<Payment> getByTenant(@PathVariable Long id) {
        if (this.compartmentController.getCompartment(id).getTenant() == null) {
            return null;
        } else {
            List<Payment> payments = this.paymentService.getByTenant(this.compartmentController.getCompartment(id).getTenant());

            for(int i = 0; i < payments.size(); ++i) {
                ((Payment)payments.get(i)).setTenantObject(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()).getTenantObject());
                System.out.println(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()).getTenantObject() + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
                ((Payment)payments.get(i)).setTenantObject(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()).getTenantObject());
                System.out.println(this.compartmentController.getCompartment(((Payment)payments.get(i)).getCompartment()).getTenantObject() + "mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
            }

            return payments;
        }
    }
}
