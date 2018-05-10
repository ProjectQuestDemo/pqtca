package com.pqtca.controllers;


import com.pqtca.models.User;
import com.pqtca.models.UserRole;
import com.pqtca.repos.UserRepo;
import com.pqtca.repos.UserRoles;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AdminController {
    private final UserRepo usersDao;
    private final PasswordEncoder passwordEncoder;
    private final UserRoles userRoles;
    private final UserDetailsService userDetailsService;

    public AdminController(UserRepo usersDao, PasswordEncoder passwordEncoder, UserRoles userRoles, UserDetailsService userDetailsService) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.userRoles = userRoles;
        this.userDetailsService = userDetailsService;
    }


    @GetMapping("/admin/register")
    public String newReg(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/register";
    }

    @PostMapping("/admin/register")
    public String regUser(@Valid User user, Errors errors, Model model) {

        String username = user.getUsername();
        String email = user.getEmail();
        User existCheckName = usersDao.findByUsername(username);
        User existEmailCheck = usersDao.findByEmail(email);

        if (existCheckName != null) {
            errors.rejectValue("username", "user.username", "That username is already in use.");
        }

        if (existEmailCheck != null) {
            errors.rejectValue("email", "user.email", "That username is already in use.");
        }

        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        usersDao.save(user);

        UserRole userRole = new UserRole();
        userRole.setRole("ADMIN");
        userRole.setUserId(user.getId());
        userRoles.save(userRole);

        model.addAttribute("user", user);
        model.addAttribute("success", "You have added " + user.getUsername() + " as an admin.");
        return "redirect:/admin";
    }

    @PostMapping("/admin/profile/edit")
    public String userUpdateInfo(@ModelAttribute User user) {

        User profileUser = usersDao.findOne(user.getId());
        profileUser.setUsername(user.getUsername());
        profileUser.setEmail(user.getEmail());
        profileUser.setPassword(user.getPassword());

        usersDao.save(profileUser);
        return "redirect:/admin/profile";
    }


}
