package com.pqtca.demo.controllers;

import com.pqtca.demo.models.User;
import com.pqtca.demo.repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserRepo usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/register")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/register";
    }

    @PostMapping("/admin/register")
    public String registerUser(@Valid User user, Errors errors, Model model
    ) {
        if(errors.hasErrors()) {
            model.addAttribute("message", "There are errors here...");
            return "admin/register";
        }

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/admin/success";
    }

    @GetMapping("/admin/login")
    public String showLoginForm() {
        Object person = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       System.out.println("Who am i?" + person);

        if (person.toString().equalsIgnoreCase("anonymousUser")) {
            return "admin/login";
        }

        return "redirect:/app";
    }


    @GetMapping("/admin/success")
    public String success(){
        return "admin/success";
    }


}
