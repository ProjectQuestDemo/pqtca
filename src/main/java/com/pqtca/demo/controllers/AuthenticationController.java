package com.pqtca.demo.controllers;


import com.pqtca.demo.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    private UserRepo user;

    public AuthenticationController(UserRepo user) {
        this.user = user;
    }

    @GetMapping(value = {"/", "/home", "/index", ""})
    public String home() {
        return "/index";
    }
}
