package com.pqtca.demo.controllers;

import com.google.gson.Gson;
import com.pqtca.demo.models.Application;
import com.pqtca.demo.repos.ApplicationRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;

@Controller
public class ApplicationController {
    private final ApplicationRepo appRepo;

    public ApplicationController(ApplicationRepo appRepo) {
        this.appRepo = appRepo;
    }

//    used for pie chart, ethnic graphing
    @GetMapping("/graphEthnicity")
    @ResponseBody
    public String getGraphEthnicity() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("white", appRepo.countByEthnicity("white"));
        map.put("black", appRepo.countByEthnicity("black"));
        return gson.toJson(map);
    }
// used for pie chart, education graphing
    @GetMapping("/graphEducation")
    @ResponseBody
    public String getGraphEducation() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("diploma", appRepo.countByEducation("diploma"));
        map.put("associate", appRepo.countByEducation("associate"));
        return gson.toJson(map);
    }

    @GetMapping("/app")
    public String newApp(Model model) {
        model.addAttribute("app1", new Application());
        return "/app";
    }

    @PostMapping("/app")
    public String submitApp(@ModelAttribute Application app) {
        return "redirect:/index";
    }
}
