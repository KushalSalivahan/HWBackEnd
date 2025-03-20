package com.kushal.hwbackend.controller;

import com.kushal.hwbackend.dto.UserRequest;
import org.springframework.web.bind.annotation.*;
import com.kushal.hwbackend.util.AESUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EncryptionController {


    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String data) {
        try {
            return AESUtil.encrypt(data);
        } catch (Exception e) {
            return "Encryption Error: " + e.getMessage();
        }
    }

    @PostMapping("/decrypt")
    public UserRequest decrypt(@RequestBody String encryptedData) {
        UserRequest response = new UserRequest();
        try {
            String decryptedValue = AESUtil.decrypt(encryptedData);
            response.setName(decryptedValue); // Set decrypted value
            response.setKey(AESUtil.SECRET_KEY); // Set the key
        } catch (Exception e) {
            response.setName("Decryption Error: " + e.getMessage());
            response.setKey(AESUtil.SECRET_KEY);
        }
        return response;
    }
}
