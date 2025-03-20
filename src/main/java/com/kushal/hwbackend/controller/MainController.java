package com.kushal.hwbackend.controller;

import com.kushal.hwbackend.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserRequest req;

    @PostMapping("/post")
    public String postMethod(@RequestBody UserRequest req) {
        return "Received: " + req.getName();
    }
}

