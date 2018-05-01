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
    private ApplicationRepo appDao;

    public ApplicationController(ApplicationRepo appDao) {
        this.appDao = appDao;
    }

    @GetMapping("/app")
    public String newApp(Model model) {
        Application app = new Application();
        model.addAttribute("app", app);
        return "/app";
    }

    @PostMapping("/app")
    public String submitApp(@ModelAttribute Application app) {
        appDao.save(app);
        return "redirect:/index";
    }
}
