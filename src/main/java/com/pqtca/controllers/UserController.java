<<<<<<< HEAD:src/main/java/com/pqtca/controllers/UserController.java
package com.pqtca.controllers;

import com.pqtca.models.User;
import com.pqtca.repos.UserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
package com.pqtca.demo.controllers;
import com.pqtca.demo.models.User;
>>>>>>> allies:src/main/java/com/pqtca/demo/controllers/UserController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD:src/main/java/com/pqtca/controllers/UserController.java
=======
import com.pqtca.demo.repos.UserRepo;
import org.springframework.validation.Errors;
>>>>>>> allies:src/main/java/com/pqtca/demo/controllers/UserController.java
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



    @GetMapping(value = {"/admin"})
    public String adminDash(Model model) {
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

