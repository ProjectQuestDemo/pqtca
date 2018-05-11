package com.pqtca.controllers;

import com.pqtca.Services.UserService;
import com.pqtca.models.Application;
import com.pqtca.models.User;
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
        User user = userService.loggedInUser();
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("userId", user.getId());
        model.addAttribute("email", user.getEmail());
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

    @PostMapping("/show={id}")
    public String confirmApp(@PathVariable Long id, @Valid Application app, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("errors", errors);
            return "admin";
        }
        app.setfEmpId(userService.loggedInUser().getId() + userService.loggedInUser().getUsername());
        app.setId(id);
        appDao.save(app);
        model.addAttribute("success", "Application successfully reviewed.");
        return "redirect:/admin";
    }
}
