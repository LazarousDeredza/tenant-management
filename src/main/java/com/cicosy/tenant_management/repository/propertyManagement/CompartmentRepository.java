//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.repository.propertyManagement;

import com.cicosy.tenant_management.model.propertyManagement.Compartment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompartmentRepository extends JpaRepository<Compartment, Long> {
    @Query("SELECT s FROM Compartment  s WHERE s.property = ?1")
    List<Compartment> findByProperty(Long id);

    List<Compartment> findByTenant(Long id);
}
