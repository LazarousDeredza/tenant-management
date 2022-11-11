//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.ProductToken;

import com.cicosy.tenant_management.model.ProductToken.ProductToken;
import com.cicosy.tenant_management.repository.ProductToken.ProductTokenRepo;
import java.security.SecureRandom;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTokenService {
    @Autowired
    private ProductTokenRepo productTokenRepo;

    public ProductTokenService() {
    }

    public ProductToken store(ProductToken productToken) {
        return (ProductToken)this.productTokenRepo.save(productToken);
    }

    public String getProductToken(Long id) {
        return this.productTokenRepo.get_token(id);
    }

    public ProductToken Update(Long id) throws Exception {
        ProductToken product = (ProductToken)this.productTokenRepo.findById(id).orElseThrow(() -> {
            return new Exception("Product does not exist with id :" + id);
        });
        StringBuilder sb = new StringBuilder(27);

        String chars;
        int p;
        try {
            chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
            Random random = new SecureRandom();

            for(p = 0; p < 27; ++p) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
        } catch (Exception var10) {
            System.out.println("Token not found");
        }

        chars = sb.toString();
        String newkey = "";
        newkey = chars.replace(chars.substring(11, 12), "-").replace(chars.substring(17, 18), "-");
        System.out.println(newkey);
        p = 10 - product.getPeriod() + 5 - 2;
        int num = 26 - product.getNum_users();
        String new_char = "";
        if (p >= 9) {
            new_char = newkey.replace(newkey.substring(3, 5), String.valueOf(p)).replace(newkey.substring(5, 6), "-");
        } else {
            new_char = newkey.replace(newkey.substring(3, 4), "0").replace(newkey.substring(4, 5), String.valueOf(p)).replace(newkey.substring(5, 6), "-");
        }

        System.out.println(new_char);
        String final_key = "";
        if (num >= 9) {
            final_key = new_char.replace(new_char.substring(20, 22), String.valueOf(num)).replace(new_char.substring(22, 23), "-");
        } else {
            final_key = new_char.replace(new_char.substring(20, 21), "0").replace(new_char.substring(21, 22), String.valueOf(num)).replace(new_char.substring(22, 23), "-");
        }

        System.out.println(final_key);
        product.setToken(final_key);
        this.productTokenRepo.save(product);
        return product;
    }
}
