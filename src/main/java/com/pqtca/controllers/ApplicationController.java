package com.pqtca.controllers;


import com.pqtca.models.Application;
import com.pqtca.repos.ApplicationRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ApplicationController {
    private ApplicationRepo appDao;

    @GetMapping("/app")
    public String newApp(Model model) {
        Application app = new Application();
        model.addAttribute("app", app);
        return "app";
    }

    @PostMapping("/app")
    public String submitApp(@ModelAttribute Application app) {
        appDao.save(app);
        return "redirect:/index";
    }
}
