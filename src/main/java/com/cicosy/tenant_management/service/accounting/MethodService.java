//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.accounting;

import com.cicosy.tenant_management.model.accounting.Method;
import com.cicosy.tenant_management.repository.accounting.MethodRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MethodService {
    private final MethodRepository methodRepository;

    @Autowired
    public MethodService(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    public Method save(Method method) {
        this.methodRepository.save(method);
        return (Method)this.methodRepository.findById(method.getId()).orElseThrow(() -> {
            return new IllegalStateException("Saving Failed");
        });
    }

    public List<Method> getAll() {
        return this.methodRepository.findAll();
    }
}
