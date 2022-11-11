//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.repository.document_management;

import com.cicosy.tenant_management.model.document_management.TenantDocuments;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantsDocumentRepo extends JpaRepository<TenantDocuments, Long> {
    @Query(
            value = "select * from tenant_documents where tenant_id=?1",
            nativeQuery = true
    )
    List<TenantDocuments> findLeaseBySearch(@Param("tenantId") String id);
}
