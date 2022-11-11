//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.repository.leaseManagement;

import com.cicosy.tenant_management.model.leaseManagement.LeaseHistory;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaseHistoryRepository extends JpaRepository<LeaseHistory, Long> {
    @Query("select s from LeaseHistory s where  s.action='Renewed' order by s.actionDate desc ")
    List<LeaseHistory> getRenewed();
}
