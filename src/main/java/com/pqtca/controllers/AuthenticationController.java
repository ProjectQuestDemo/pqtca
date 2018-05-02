package com.pqtca.controllers;


import com.pqtca.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    private UserRepo user;

    public AuthenticationController(UserRepo user) {
        this.user = user;
    }

    @GetMapping(value = {"/", "/home", "/index", ""})
    public String home() {
        return "index";
    }
}
