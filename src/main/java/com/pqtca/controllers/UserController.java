package com.pqtca.controllers;

import com.pqtca.models.User;
import com.pqtca.repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepo usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepo usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = {"/", "/home", "/index", ""})
    public String home() {
        return "index";
    }

    @GetMapping("/user")
    public String userDash() {
        return "user/profile";
    }

    @GetMapping(value = {"/user-app"})
    public String userApp() {
        return "user/user-profile-application";
    }

    @GetMapping("/user/edit")
    public String userShowEditProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == 0) {
            return "redirect:/login";
        }
        User userProfile = usersDao.findOne(user.getId());
        model.addAttribute("user", userProfile);
        return "users/edit";
    }

    @PostMapping("/profile/edit")
    public String userUpdateInfo(@ModelAttribute User user) {

        User profileUser = usersDao.findOne(user.getId());

        profileUser.setFirstName(user.getFirstName());
        profileUser.setLastName(user.getFirstName());
        profileUser.setUsername(user.getUsername());
        profileUser.setEmail(user.getEmail());
        profileUser.setPassword(user.getPassword());

        usersDao.save(profileUser);
        return "redirect:/profile";
    }
}
