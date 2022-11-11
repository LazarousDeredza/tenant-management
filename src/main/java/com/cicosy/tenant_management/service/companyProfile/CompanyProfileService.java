//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.companyProfile;

import com.cicosy.tenant_management.model.company_details.Company;
import com.cicosy.tenant_management.repository.companyProfile.CompanyProfileRepo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CompanyProfileService {
    @Autowired
    private CompanyProfileRepo companyProfileRepo;
    public static String uploadDirectory = System.getProperty("user.dir") + "/assets/uploads/Company";
    private final Path fileStorageLocation;

    public CompanyProfileService() {
        this.fileStorageLocation = Paths.get(uploadDirectory).toAbsolutePath().normalize();
    }

    public Company saveCompany(Company company) {
        return (Company)this.companyProfileRepo.save(company);
    }

    public void store(Long id, String uploadDir, String fileName, MultipartFile multipartFile, String location, String company_name) throws IOException {
        String uploadPath = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "Company" + id;
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
}
