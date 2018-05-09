package com.pqtca.controllers;

import com.pqtca.Services.EmailService;
import com.pqtca.Services.UserService;
import com.pqtca.models.User;
import com.pqtca.repos.UserRepo;
import com.pqtca.repos.UserRoles;
import org.springframework.mail.SimpleMailMessage;
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
    private UserService userService;
    private EmailService emailService;


    public UserController(UserRepo usersDao, PasswordEncoder passwordEncoder, UserRoles userRoles, UserService userService, EmailService emailService) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.userRoles = userRoles;
        this.userService = userService;
        this.emailService = emailService;
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
            model.addAttribute("errors", "That username is already in use.");
            return "register";
        }

        if (existEmailCheck != null) {
            model.addAttribute("errors", "That email is already in use.");
            return "register";
        }

        if (errors.hasErrors()) {
            model.addAttribute("errors", errors);
            model.addAttribute("user", user);
            return "register";
        }

        SimpleMailMessage registrationEmail = new SimpleMailMessage();
        registrationEmail.setTo(user.getEmail());
        registrationEmail.setSubject("Registration Confirmation");
        registrationEmail.setText("Thank you for registering with Project Quest! Please take the time to fill out an application.");
        registrationEmail.setFrom("noreply@domain.com");

        emailService.sendEmail(registrationEmail);
        return "login";
    }

    @GetMapping("/profile")
    public String userDash(Model model) {
        User loggedInUser = userService.loggedInUser();
        model.addAttribute("user", loggedInUser);
        return "user/profile";
    }


    /**
     * @return Form fields pre-populated with current user's info.
     */
    @PostMapping("/profile/edit")
    public String userUpdateInfo(@ModelAttribute User user) {
        User loggedInUser = userService.loggedInUser();
        if (loggedInUser.getUsername().equalsIgnoreCase(user.getUsername())) {
            return "redirect:/login";
        }
        User profileUser = usersDao.findOne(user.getId());
        profileUser.setUsername(user.getUsername());
        profileUser.setEmail(user.getEmail());
        profileUser.setPassword(user.getPassword());

        usersDao.save(profileUser);
        return "redirect:/profile";
    }
}
