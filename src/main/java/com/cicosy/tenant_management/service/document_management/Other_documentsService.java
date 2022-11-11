//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.document_management;

import com.cicosy.tenant_management.model.document_management.Other_documents;
import com.cicosy.tenant_management.repository.document_management.Other_documentsRepo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Other_documentsService {
    @Autowired
    private Other_documentsRepo other_documentsRepo;
    public static String uploadDirectory;
    private final Path fileStorageLocation;

    public Other_documentsService() {
        this.fileStorageLocation = Paths.get(uploadDirectory).toAbsolutePath().normalize();
    }

    public String store3(Other_documents other_documents) throws IOException {
        this.other_documentsRepo.save(other_documents);
        return "success";
    }

    public List<Other_documents> getAll_OtherDocuments(String id) {
        return this.other_documentsRepo.findAllOther(id);
    }

    public String saveFile(Other_documents other_documents) throws IOException {
        this.other_documentsRepo.save(other_documents);
        return "success";
    }

    public void store(String document_name, String tenantId, Long id, String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        int id1 = Integer.parseInt(tenantId);
        String uploadPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "other_documents" + File.separator + "Tenant" + id1;
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

    public String getOth(String tenantId, String document_name) {
        return this.other_documentsRepo.findOther(tenantId, document_name);
    }

    static {
        uploadDirectory = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "otherDocuments";
    }
}
