
package com.cicosy.tenant_management.controler.document_management;

import com.cicosy.tenant_management.service.document_management.NoticeDocumentsService;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/api/v1"})
public class NoticeDocController {
    private static Logger log = LoggerFactory.getLogger(NoticeDocController.class);
    public static String uploadDirectory;
    @Autowired
    NoticeDocumentsService noticeDocumentsService;

    public NoticeDocController() {
    }

    static {
        uploadDirectory = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "other_doc";
    }
}
