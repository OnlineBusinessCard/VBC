package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Image;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.ImageRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;
    private ImageRepository imagesDao;


    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, ImageRepository imagesDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.imagesDao = imagesDao;
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
        List<Image> myImage = imagesDao.findAll();
        model.addAttribute("images", myImage);
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
    public String update(@PathVariable long id, @ModelAttribute User user, @RequestParam String imageUpload){
        User currentUser = userDao.findById(id);
        Image img = new Image();
        img.setFilestackUrl(imageUpload);
        img.setUser(user);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
        imagesDao.save(img);
        userDao.save(currentUser);
        return "redirect:/dashboard";
    }

    @GetMapping("/profile/{id}/delete")
    public String delete(@PathVariable long id, Model model){
        User user = userDao.getOne(id);
        model.addAttribute("user", user);
        return "settings/delete-profile";
    }

    @PostMapping("/profile/{id}/delete")
    public String deleteUser(@ModelAttribute User user){
        User deleteUser = userDao.getOne(user.getId());
        userDao.delete(deleteUser);
        return "redirect:/";
    }

}
