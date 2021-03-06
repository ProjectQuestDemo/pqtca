package com.pqtca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/login")
    private String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/admin")
    private String adminDash() {
        return "admin/dashboard";
    }

    @GetMapping("/dev-team")
    public String devTeam() { return "dev-team"; }
}
