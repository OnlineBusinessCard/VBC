package com.vbc.vbc.controllers;

import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String userDashboard(Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getOne(sessionUser.getId());
        model.addAttribute("user", user);
        return "users/dashboard";
    }


    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable long id, Model model){
        User user = userDao.getOne(id);
        model.addAttribute("user", user);
        return "users/profile";
    }

    @GetMapping("/profile/edit/{id}")
    public String editProfile(@PathVariable long id, Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", userDao.getOne(sessionUser.getId()));
        return"settings/edit-profile";
    }

    @PostMapping("/profile/edit/{id}")
    public String update(@PathVariable long id, @ModelAttribute User user){
        User currentUser = userDao.findById(id);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        userDao.save(currentUser);
        return "redirect:/dashboard";
    }

}
