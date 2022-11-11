//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.controler.ProductToken;

import com.cicosy.tenant_management.model.ProductToken.ProductToken;
import com.cicosy.tenant_management.security.services.MyUserDetailsService;
import com.cicosy.tenant_management.service.ProductToken.Decrypt;
import com.cicosy.tenant_management.service.ProductToken.EncryptToken;
import com.cicosy.tenant_management.service.ProductToken.ProductTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/v1"})
public class ProductTokenControler {
    @Autowired
    private ProductTokenService productTokenService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    public ProductTokenControler() {
    }

    @PostMapping({"/savedetails"})
    public ProductToken SaveDetails(@RequestBody ProductToken productToken) {
        return this.productTokenService.store(productToken);
    }

    @GetMapping({"/get_product/{id}"})
    public String encry(@PathVariable Long id) throws Exception {
        String encryptedMessage = "op";
        EncryptToken encryptToken = new EncryptToken();
        String encrypted = this.productTokenService.getProductToken(id);

        try {
            encryptToken.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");
            encryptedMessage = encryptToken.encrypt(encrypted);
            System.out.println("Encrypted Message : " + encryptedMessage);
        } catch (Exception var6) {
        }

        System.out.println(encryptedMessage);
        return encryptedMessage;
    }

    @GetMapping({"decrypt/{id}"})
    public String decry(@PathVariable Long id) {
        Decrypt decrypt = new Decrypt();
        String decryptedMessage = "";
        this.productTokenService.getProductToken(id);

        try {
            decrypt.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");
            decryptedMessage = decrypt.decrypt(this.encry(id));
            System.err.println("Decrypted Message : " + decryptedMessage);
        } catch (Exception var6) {
        }

        return decryptedMessage;
    }

    @PutMapping({"Updatetoken/{id}"})
    public ProductToken updateToken(@PathVariable Long id) throws Exception {
        return this.productTokenService.Update(id);
    }

    @PostMapping({"authenticate"})
    public void auth(@RequestBody ProductToken token) {
        System.out.println("Consuming Token :" + token.getToken());
        Decrypt decrypt = new Decrypt();
        String decryptedMessage = "";

        try {
            decrypt.initFromStrings("CHuO1Fjd8YgJqTyapibFBQ==", "e3IYYJC2hxe24/EO");
            decryptedMessage = decrypt.decrypt(token.getToken());
            System.out.println("Decrypted Message : " + decryptedMessage);
        } catch (Exception var5) {
        }

        this.myUserDetailsService.loadByToken(decryptedMessage);
    }
}
