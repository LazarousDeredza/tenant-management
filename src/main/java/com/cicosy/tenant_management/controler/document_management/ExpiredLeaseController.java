package com.cicosy.tenant_management.controler.document_management;

import com.cicosy.tenant_management.model.document_management.ExpiredLeaseDocuments;
import com.cicosy.tenant_management.service.document_management.ExpiredLeaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

@RestController
@RequestMapping({"/api/v1"})
public class ExpiredLeaseController {
    @Autowired
    ExpiredLeaseService expiredLeaseService;
    ObjectMapper objectmapper = new ObjectMapper();
    private static final SimpleDateFormat filenameDate = new SimpleDateFormat("ddMMyyyyHHmmss");
    private static final SimpleDateFormat readableDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public ExpiredLeaseController() {
    }

    @PostMapping({"/expiredDocuments"})
    public void SaveDetails(@RequestParam(required = true,value = "jsondata") String jsondata) throws JsonProcessingException, JsonMappingException {
        ExpiredLeaseDocuments expiredLeaseDocuments = (ExpiredLeaseDocuments)this.objectmapper.readValue(jsondata, ExpiredLeaseDocuments.class);
        expiredLeaseDocuments.setToday(LocalDate.now());
        this.expiredLeaseService.storeDetails(expiredLeaseDocuments);
    }

    @GetMapping({"/getexpiredlease/{id}"})
    public ExpiredLeaseDocuments getDetails(@PathVariable Long id, HttpServletRequest request) throws Exception {
        return this.expiredLeaseService.getEx(id);
    }

    @RequestMapping({"/getExpiredoc/{id}"})
    public RestResponse singleDocument(@PathVariable Long id) {
        RestResponse response = new RestResponse();
        ExpiredLeaseDocuments realldocuments = null;
        List<ExpiredLeaseDocuments> alldocuments = this.expiredLeaseService.getAllDocuments();
        Iterator var5 = alldocuments.iterator();

        while(var5.hasNext()) {
            ExpiredLeaseDocuments expireddocuments = (ExpiredLeaseDocuments)var5.next();
            if (expireddocuments.getId().equals(id)) {
                realldocuments = expireddocuments;
                break;
            }
        }

        if (realldocuments == null) {
            response.setResponseStatus("Not found");
            response.setResponse("");
        } else {
            response.setResponseStatus("Ok");
            response.setResponse(realldocuments);
        }

        return response;
    }

    @RequestMapping(
            value = {"/export/{id}"},
            method = {RequestMethod.GET},
            produces = {"application/pdf"}
    )
    public ResponseEntity<byte[]> getExport(@PathVariable Long id) {
        ITextRenderer renderer = new ITextRenderer();
        ByteArrayOutputStream boas = null;

        try {
            String inputFile = "C:/Users/cicosy/Documents/tenant_management/src/main/resources/static/html/documentsManagement/expiredleasedocuments.html";
            String outputFile = "uploads" + filenameDate.format(new Date()) + ".pdf";
            String html = new String(Files.readAllBytes(Paths.get(inputFile)));
            Document document = Jsoup.parse(html);
            document.outputSettings().syntax(Syntax.xml);
            document.body().select(".DOC_GENERATED_DATE").html(readableDate.format(new Date()));
            renderer.setDocumentFromString(document.html());
            renderer.layout();

            try {
                OutputStream os = Files.newOutputStream(Paths.get(outputFile));
                Throwable var9 = null;

                try {
                    renderer.createPDF(os);
                    os.close();
                    PdfReader reader = new PdfReader(outputFile);
                    boas = new ByteArrayOutputStream();
                    PdfStamper stamper = new PdfStamper(reader, boas);
                    stamper.setPageAction(PdfWriter.PAGE_OPEN, new PdfAction(5), 1);
                    stamper.close();
                } catch (Throwable var21) {
                    var9 = var21;
                    throw var21;
                } finally {
                    if (os != null) {
                        if (var9 != null) {
                            try {
                                os.close();
                            } catch (Throwable var20) {
                                var9.addSuppressed(var20);
                            }
                        } else {
                            os.close();
                        }
                    }

                }
            } catch (DocumentException var23) {
                Logger.getLogger(ExpiredLeaseController.class.getName()).log(Level.SEVERE, (String)null, var23);
            }
        } catch (IOException var24) {
            Logger.getLogger(ExpiredLeaseController.class.getName()).log(Level.SEVERE, (String)null, var24);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity(boas.toByteArray(), headers, HttpStatus.OK);
        return response;
    }
}
