//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.cicosy.tenant_management.service.ProductToken;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
    private SecretKey key;
    private int KEY_SIZE = 128;
    private int T_LEN = 128;
    private byte[] IV;

    public Decrypt() {
    }

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(this.KEY_SIZE);
        this.key = generator.generateKey();
    }

    public void initFromStrings(String secretKey, String IV) {
        this.key = new SecretKeySpec(this.decode(secretKey), "AES");
        this.IV = this.decode(IV);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = this.decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(this.T_LEN, this.IV);
        decryptionCipher.init(2, this.key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }

    private byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }
}
