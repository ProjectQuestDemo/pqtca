package com.pqtca.demo.controllers;

import com.google.gson.Gson;
import com.pqtca.demo.models.Application;
import com.pqtca.demo.models.User;
import com.pqtca.demo.repos.ApplicationRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @GetMapping(value = {"/admin"})
    public String adminDash(Model model) {
//        model.addAttribute("test", test);
        return "admin/admin-dashboard";
    }

    @GetMapping(value = {"/pending"})
    public String adminPendingApps() {
        return "admin/admin-pending";
    }

    @GetMapping(value = {"/complete"})
    public String adminCompleteApps() {
        return "admin/admin-complete";
    }

    @GetMapping(value = {"/devTeam"})
    public String adminDevTeam() {
        return "admin/admin-dev";
    }


}
