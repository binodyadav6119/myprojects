package com.authentication.auth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.*;
import java.util.Base64;

@RestController
@RequestMapping("/digital-sign")
public class DigitalSignatureController {

    @GetMapping("auth")
    public String digitalSign() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {


        /*
            in digital sign data is signed with private key to ensure data is coming from the same person it was sent
            meaning data integrity
            issue is we have the to send original data to verify. but we can encrypt the original data using other algo
            and decrypt while verifiying it
         */

        //Generate key pair using RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey= keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        String data = "this is the data";
        byte[] dataBytes = data.getBytes();



        Signature signature = Signature.getInstance("SHA256withRSA");
        //algo SHA256withRSA means first the data is hashed to get hash value and same hashed data is encrypted using RSA
        signature.initSign(privateKey);
        signature.update(dataBytes);
        byte[] digitalSignature = signature.sign();

        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        signature.initVerify(publicKey);
        signature.update(dataBytes);
        boolean isVerified =  signature.verify(digitalSignature);
        System.out.println("Data verification:"+isVerified);
        return "test";
    }
}
