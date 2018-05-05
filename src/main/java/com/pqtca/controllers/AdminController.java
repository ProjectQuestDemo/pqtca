package com.pqtca.controllers;


import com.pqtca.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
