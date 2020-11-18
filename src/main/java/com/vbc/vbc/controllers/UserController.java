package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Card;
import com.vbc.vbc.models.Lead;
import com.vbc.vbc.models.Review;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;
    private final LeadRepository leadsDao;
    private final ReviewRepository reviewsDao;
    private final CardRepository cardsDao;
    private final ImageRepository imagesDao;


    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, LeadRepository leadsDao, ReviewRepository reviewsDao, CardRepository cardsDao, ImageRepository imagesDao) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.leadsDao = leadsDao;
        this.reviewsDao = reviewsDao;
        this.cardsDao = cardsDao;
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
//        List<Image> myImage = imagesDao.findAll();
        List<Lead> lead = leadsDao.findAll();
        List<Card> cards = cardsDao.findAll();
        List<Review> review = reviewsDao.findAll();
//        model.addAttribute("images", myImage);
        model.addAttribute("user", user);
        model.addAttribute("leads", lead);
        model.addAttribute("review", review);
        model.addAttribute("card", cards);
        return "users/dashboard";
    }

    @GetMapping("/profile/{id}")
    public String userProfile(@PathVariable long id, Model model){
        User user = userDao.getOne(id);
        List<Review> review = reviewsDao.findAll();
        List<Card> cards = cardsDao.findAll();
        model.addAttribute("user", user);
        model.addAttribute("review", review);
        model.addAttribute("card", cards);
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
//        Image img = new Image();
//        img.setFilestackUrl(imageUpload);
//        img.setUser(user);
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setUsername(user.getUsername());
        currentUser.setEmail(user.getEmail());
//        imagesDao.save(img);
        userDao.save(currentUser);
        return "redirect:/dashboard";
    }

    @GetMapping("/profile/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        User user = userDao.getOne(id);
        model.addAttribute("user", user);
        return "settings/delete-profile";
    }

    @PostMapping("/profile/delete/{id}")
    public String deleteUser(@ModelAttribute User user){
        User deleteUser = userDao.getOne(user.getId());
        userDao.delete(deleteUser);
        return "redirect:/";
    }

    @GetMapping("/users/all")
    public String viewAll(Model model){
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "users/index";
    }

    @RequestMapping
    public String searchUser(@ModelAttribute("User") User user , Model model){
        List<User> users = userDao.findByFirstNameAndLastName(user.getFirstName(), user.getLastName());
        model.addAttribute("users", users);
        return "users/search";
    }

}
