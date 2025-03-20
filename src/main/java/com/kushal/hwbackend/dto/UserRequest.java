package com.kushal.hwbackend.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRequest {
    private String name;
    private String key;
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

