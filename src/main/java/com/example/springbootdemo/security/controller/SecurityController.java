package com.example.springbootdemo.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

    @GetMapping("/admin")
    public String testAdmin() {
        return "Admin";
    }

    @GetMapping("/user")
    public String testUser() {
        return "User";
    }
}
