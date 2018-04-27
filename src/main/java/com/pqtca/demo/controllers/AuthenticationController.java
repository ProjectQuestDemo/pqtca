package com.pqtca.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/hey")
    public String home() {
        return "index";
    }

}
