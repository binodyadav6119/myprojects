package com.authentication.auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Base64;

import javax.crypto.Cipher;
import java.security.*;

@RestController
@RequestMapping("/rsa")
public class RsaController {
    private static final String ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;

    @GetMapping("/test")
    public String test() throws Exception {
        /*
            using public key for encryption and private key for decryption
            using public key for changing plain text to cipher text using public key
            why public key because we can not use private key for encryption.
            public key is known to all even if it is known by other people then they cannot decrypt because private key is not known to them


        */
        KeyPairGenerator keyPair = KeyPairGenerator.getInstance(ALGORITHM);
        keyPair.initialize(KEY_SIZE);
        KeyPair keyPair1 = keyPair.generateKeyPair();

        PrivateKey aPrivate = keyPair1.getPrivate();
        PublicKey aPublic = keyPair1.getPublic();
        String originalMessage = "password123";
        String encryptedMessage = encrypt(originalMessage, aPublic);
        String decryptedMessage = decrypt(encryptedMessage, aPrivate);

        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);

        System.out.println("fghjk");

        return "test";
    }
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyGen.initialize(KEY_SIZE);
        return keyGen.generateKeyPair();
    }

    public static String encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }


}
