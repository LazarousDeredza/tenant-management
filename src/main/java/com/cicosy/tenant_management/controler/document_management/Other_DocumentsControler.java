
package com.cicosy.tenant_management.controler.document_management;

import com.cicosy.tenant_management.model.document_management.Other_documents;
import com.cicosy.tenant_management.repository.document_management.Other_documentsRepo;
import com.cicosy.tenant_management.service.document_management.NoticeDocumentsService;
import com.cicosy.tenant_management.service.document_management.Other_documentsService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping({"api/v1"})
public class Other_DocumentsControler {
    @Autowired
    private Other_documentsService other_documentsService;
    @Autowired
    private NoticeDocumentsService noticeDocumentsService;
    @Autowired
    private Other_documentsRepo other_documentsRepo;

    public Other_DocumentsControler() {
    }

    @GetMapping(
            path = {"/getAll_other/{id}"}
    )
    public List<Other_documents> getAll(@PathVariable String id) {
        return this.other_documentsService.getAll_OtherDocuments(id);
    }

    @PostMapping({"/uploadOther/{id}"})
    public String uploadFile(@RequestParam("file") MultipartFile file0, @RequestParam("document_name") String document_name, @RequestParam("tenantId") @PathVariable String tenantId, Long id) throws IOException {
        String otherF = StringUtils.cleanPath(file0.getOriginalFilename());
        if (otherF.contains(" ")) {
            otherF = otherF.replace(" ", "_");
        }

        document_name = document_name.replaceAll("^\"|\"$", "");
        Other_documents documents = new Other_documents();
        documents.setDocument_name(document_name);
        documents.setOtherFile(otherF);
        documents.setTenantId(tenantId);
        Other_documents docs = (Other_documents)this.other_documentsRepo.save(documents);
        String uploadDir = System.getProperty("user.dir") + "assets/uploads/other_documents/Tenant" + docs.getId();
        this.other_documentsService.store(document_name, tenantId, id, uploadDir, otherF, file0);
        return "success";
    }

    @GetMapping({"/getoth/{tenantId}/{document_name}"})
    public String getForm(@PathVariable String tenantId, @PathVariable String document_name) {
        return this.other_documentsService.getOth(tenantId, document_name);
    }
}
