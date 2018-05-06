package com.pqtca.controllers;

import com.pqtca.models.Application;
import com.pqtca.models.User;
import com.pqtca.repos.ApplicationRepo;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping(value = {"/app"})
    public String userApp(Model model) {
        Application app = new Application();
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.toString().equalsIgnoreCase("anonymousUser")) {
            return "redirect:/login";
        }

        model.addAttribute("app", app);
        return "app";
    }

    @PostMapping("/app")
    public String submitApp(@ModelAttribute Application app) {
        appDao.save(app);
        return "redirect:/profile";
    }
}
