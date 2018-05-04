package com.pqtca.controllers;

import com.pqtca.models.User;
import com.pqtca.repos.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String showLoginForm(Model model) {
        Object person = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       System.out.println("Who am i?" + person);
//ADDED BY ALLIE
       if(person instanceof String) {
           return "admin/login";
       }

       long userId = ((User) person).getId();

       User user = usersDao.findOne(userId);

       String username = user.getUsername();


        model.addAttribute("username", username);
        //ADDED BY ALLIE
        return "redirect:/app";
    }

    @GetMapping("/admin/success")
    public String success(){
        return "admin/success";
    }


    @GetMapping(value = {"/admin"})
    public String adminDash(Model model) {

        return "admin/admin-dashboard";
    }


    @GetMapping(value = {"/complete"})
    public String adminCompleteApps() {
        return "admin/admin-complete";
    }

    @GetMapping(value = {"/devTeam"})
    public String adminDevTeam() {
        return "/dev-team";
    }

    @GetMapping(value = {"/user"})
    public String userDash() {
        return "user/user-profile";
    }

    @GetMapping(value = {"/user-app"})
    public String userApp() {
        return "user/user-profile-application";
    }

//set up for user editing their profile information
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
