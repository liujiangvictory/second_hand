package com.example.secondhand_springboot.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
