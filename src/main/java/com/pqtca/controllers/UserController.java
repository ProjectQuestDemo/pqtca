package com.pqtca.controllers;

import com.pqtca.models.User;
import com.pqtca.models.UserRole;
import com.pqtca.repos.UserRepo;
import com.pqtca.repos.UserRoles;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class UserController {
    private final UserRepo usersDao;
    private final PasswordEncoder passwordEncoder;
    private final UserRoles userRoles;
    private final UserDetailsService userDetailsService;


    public UserController(UserRepo usersDao, PasswordEncoder passwordEncoder, UserRoles userRoles, UserDetailsService userDetailsService) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.userRoles = userRoles;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping({"/", "/home", "/index", ""})
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String newReg(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
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
        userRole.setRole("ROLE_USER");
        userRole.setUserId(user.getId());
        userRoles.save(userRole);

        model.addAttribute("user", user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String userDash() {
        return "profile";
    }


    /**
     *
     * @param model Model should contain current users info to populate form
     * @return Form fields pre-populated with current user's info.
     */
    @GetMapping("/profile/edit")
    public String userShowEditProfile(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId() == 0) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        return "profile/edit";
    }

    @PostMapping("/profile/edit")
    public String userUpdateInfo(@ModelAttribute User user) {

        User profileUser = usersDao.findOne(user.getId());
        profileUser.setUsername(user.getUsername());
        profileUser.setEmail(user.getEmail());
        profileUser.setPassword(user.getPassword());

        usersDao.save(profileUser);
        return "redirect:/profile";
    }
}
