package com.pqtca.controllers;

import com.pqtca.models.Application;
import com.pqtca.repos.ApplicationRepo;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.HashMap;
import java.util.List;

@Controller
public class ApplicationController {
    private ApplicationRepo appDao;

    public ApplicationController(ApplicationRepo appDao) {
        this.appDao = appDao;
    }

//    used for pie chart, ethnic graphing
    @GetMapping("/graphEthnicity")
    @ResponseBody
    public String getGraphEthnicity() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("white", appDao.countByAEthnicity("white"));
        map.put("black", appDao.countByAEthnicity("black"));
        return gson.toJson(map);
    }
// used for pie chart, education graphing
    @GetMapping("/graphCity")
    @ResponseBody
    public String getGraphCity() {
        Gson gson = new Gson();
        HashMap<String, Long> map = new HashMap<>();
        map.put("San Antonio", appDao.countByBCity("San Antonio"));
        map.put("Austin", appDao.countByBCity("Austin"));
        return gson.toJson(map);
    }

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
