package com.pqtca.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/login")
    private String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/admin")
    private String adminDash() {
        return "/admin/dashboard";
    }
}
