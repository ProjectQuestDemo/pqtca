package com.pqtca.demo.controllers;


import com.pqtca.demo.models.User;
import com.pqtca.demo.repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class AuthenticationController {

    private UserRepo usersDao;
    private PasswordEncoder passwordEncoder;

    public AuthenticationController(UserRepo usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/adminRegister")
    public String showSignUpForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/adminRegister";
    }

    @PostMapping("/adminRegister")
    public String registerUser(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:adminLogin";
    }

    @GetMapping("/admin/adminLogin")
    public String showLoginForm() {
//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "/adminLogin";
    }

}