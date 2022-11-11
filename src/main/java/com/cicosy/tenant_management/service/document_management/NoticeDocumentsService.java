//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.document_management;

import com.cicosy.tenant_management.model.document_management.NoticeDocuments;
import com.cicosy.tenant_management.repository.document_management.NoticeDocumentRepo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class NoticeDocumentsService {
    @Autowired
    NoticeDocumentRepo noticeDocumentRepo;
    public static String uploadDirectory;
    private final Path fileStorageLocation;

    public NoticeDocumentsService() {
        this.fileStorageLocation = Paths.get(uploadDirectory).toAbsolutePath().normalize();
    }

    public NoticeDocuments store(MultipartFile file, String ID) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String DocumentPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "other_doc";
        new File(DocumentPath);
        if (!Files.exists(Paths.get(DocumentPath), new LinkOption[0])) {
            Files.createDirectories(Paths.get(DocumentPath));
        }

        if (fileName.contains(" ")) {
            fileName = fileName.replace(" ", "_");
        }

        byte[] data = file.getBytes();
        Path path = Paths.get(DocumentPath + File.separator + fileName);
        Files.write(path, data, new LinkOption[0]);
        NoticeDocuments noticeDocuments = new NoticeDocuments(fileName, ID);
        return (NoticeDocuments)this.noticeDocumentRepo.save(noticeDocuments);
    }

    static {
        uploadDirectory = System.getProperty("user.dir") + File.separator + "assets" + File.separator + "uploads" + File.separator + "other_doc";
    }
}
