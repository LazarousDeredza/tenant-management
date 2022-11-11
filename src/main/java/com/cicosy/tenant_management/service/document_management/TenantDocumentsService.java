//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.document_management;

import com.cicosy.tenant_management.model.document_management.TenantDocuments;
import com.cicosy.tenant_management.repository.document_management.TenantsDocumentRepo;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TenantDocumentsService {
    private static final Logger log = LogManager.getLogger(TenantDocumentsService.class);
    @Autowired
    TenantsDocumentRepo tenantsDocumentRepo;
    public static String uploadDirectory;
    private final Path fileStorageLocation;

    public TenantDocumentsService() {
        this.fileStorageLocation = Paths.get(uploadDirectory).toAbsolutePath().normalize();
    }

    public String saveFile(TenantDocuments tenantDocuments) throws IOException {
        this.tenantsDocumentRepo.save(tenantDocuments);
        return "success";
    }

    public void store(String tenantId, Long id, String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        int id1 = Integer.parseInt(tenantId);
        String uploadPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "TenantDocuments" + File.separator + "Tenant" + id1;
        new File(uploadPath);
        if (!Files.exists(Paths.get(uploadPath), new LinkOption[0])) {
            Files.createDirectories(Paths.get(uploadPath));
        }

        if (fileName.contains(" ")) {
            fileName = fileName.replace(" ", "_");
        }

        byte[] data = multipartFile.getBytes();
        Path path = Paths.get(uploadPath + File.separator + fileName);
        Files.write(path, data, new OpenOption[0]);
    }

    public Resource loadFileAsResource(Long id, String fileName) {
        String DocumentPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "Tenant" + id;
        Path path = Paths.get(DocumentPath).toAbsolutePath().resolve(fileName);

        UrlResource resource;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException var7) {
            throw new RuntimeException("Issue in reading the file", var7);
        }

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new RuntimeException("the file doesn't exist or not readable");
        }
    }

    public List<TenantDocuments> findDoc(String id) {
        return this.tenantsDocumentRepo.findLeaseBySearch(id);
    }

    static {
        uploadDirectory = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "tenantDocuments";
    }
}
