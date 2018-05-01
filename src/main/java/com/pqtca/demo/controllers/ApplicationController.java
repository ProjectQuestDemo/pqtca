package com.pqtca.demo.controllers;

import com.pqtca.demo.models.Application;
import com.pqtca.demo.repos.ApplicationRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationController {
    private final ApplicationRepo appRepo;

    public ApplicationController(ApplicationRepo appRepo) {
        this.appRepo = appRepo;
    }

    @GetMapping("/app")
    public String newApp(Model model) {
        Application appRepo = new Application();
        model.addAttribute("app", new Application());
        return "/app";
    }

    @PostMapping("/app")
    public String submitApp(@ModelAttribute Application app) {
        appRepo.save(app);
        return "redirect:/index";
    }
}
