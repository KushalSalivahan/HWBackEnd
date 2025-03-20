package com.kushal.hwbackend.controller;

import com.kushal.hwbackend.dto.InData;
import com.kushal.hwbackend.dto.UserRequest;
import org.springframework.web.bind.annotation.*;
import com.kushal.hwbackend.util.AESUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EncryptionController {


    @PostMapping("/encrypt")
    public String encrypt(@RequestBody InData in) {
        System.out.println(in.getData());
        try {
            return AESUtil.encrypt(in.getData());
        } catch (Exception e) {
            return "Encryption Error: " + e.getMessage();
        }
    }

    @PostMapping("/decrypt")
    public UserRequest decrypt(@RequestBody InData in) {
        System.out.println(in.getData());
        UserRequest response = new UserRequest();
        try {
            String decryptedValue = AESUtil.decrypt(in.getData());
            response.setName(decryptedValue); // Set decrypted value
            response.setKey(AESUtil.SECRET_KEY); // Set the key
        } catch (Exception e) {
            response.setName("Decryption Error: " + e.getMessage());
            response.setKey(AESUtil.SECRET_KEY);
        }
        return response;
    }
}
