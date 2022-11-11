//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.repository.document_management;

import com.cicosy.tenant_management.model.document_management.ExpiredLeaseDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpiredDocumentsRepo extends JpaRepository<ExpiredLeaseDocuments, Long> {
}
