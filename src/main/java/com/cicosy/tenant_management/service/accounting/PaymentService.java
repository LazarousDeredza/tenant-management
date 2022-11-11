//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.accounting;

import com.cicosy.tenant_management.model.accounting.Payment;
import com.cicosy.tenant_management.repository.accounting.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        this.paymentRepository.save(payment);
        return (Payment)this.paymentRepository.findById(payment.getId()).orElseThrow(() -> {
            return new IllegalStateException("Saving Failed");
        });
    }

    public List<Payment> getAll() {
        return this.paymentRepository.findAll();
    }

    public List<Payment> getByTenant(Long id) {
        return this.paymentRepository.getByTenant(id);
    }
}
