package com.pqtca.controllers;

import com.pqtca.Services.UserService;
import com.pqtca.models.Application;
import com.pqtca.repos.ApplicationRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.Instant;
import java.util.Date;

@Controller
public class ApplicationController {


    private final ApplicationRepo appDao;
    private final UserService userService;

    public ApplicationController(ApplicationRepo appDao, UserService userService) {
        this.appDao = appDao;
        this.userService = userService;
    }


    @GetMapping("/app")
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
    public String submitApp(@Valid Application app, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("errors", errors);
            return "app";
        }
        app.setUser(userService.loggedInUser());
        app.setfEmpId("");
        appDao.save(app);
        return "redirect:/profile";
    }

    @GetMapping("/show={id}")
    public String pendingApp (@PathVariable Long id, Model model) {
        Application app = appDao.findOne(id);
        model.addAttribute("app", app);
        return "admin/show";
    }

    @PostMapping("/confirm-app")
    public String confirmApp(@Valid Application app, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("errors", errors);
            return "admin";
        }
        app.setfEmpId(userService.loggedInUser().getId() + userService.loggedInUser().getUsername());
        appDao.save(app);
        return "redirect:/admin";
    }
}
