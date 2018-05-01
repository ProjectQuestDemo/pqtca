package com.pqtca.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = {"/admin"})
    public String adminDash() {
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
