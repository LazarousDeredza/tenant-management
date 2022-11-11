
package com.cicosy.tenant_management.controler.accounting;

import com.cicosy.tenant_management.model.accounting.Method;
import com.cicosy.tenant_management.service.accounting.MethodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/method"})
public class MethodController {
    public MethodService methodService;

    @Autowired
    public MethodController(MethodService methodService) {
        this.methodService = methodService;
    }

    @PostMapping({"/save-method"})
    public Method saveMethod(@RequestBody Method method) {
        return this.methodService.save(method);
    }

    @GetMapping({"/get-methods"})
    public List<Method> getMethods() {
        return this.methodService.getAll();
    }
}
