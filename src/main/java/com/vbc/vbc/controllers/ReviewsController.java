package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Review;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.ReviewRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.security.PermitAll;
import java.util.List;

@Controller
public class ReviewsController {

    private final ReviewRepository reviewsDao;
    private final UserRepository usersDao;


    public ReviewsController(ReviewRepository reviewsDao, UserRepository usersDao) {
        this.reviewsDao = reviewsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/reviews")
    public String index(Model model){
        List<Review> review = reviewsDao.findAll();
        model.addAttribute("reviews", review);
        return "reviews/index";
    }

    @GetMapping("/reviews/{id}")
    public String show(@PathVariable long id, Model model){
        Review pulledReview = reviewsDao.getOne(id);
        model.addAttribute("review", pulledReview);
        return "reviews/show";
    }

    @GetMapping("reviews/create/{id}")
    public String showCreateReviewForm(@PathVariable long id, Model model){
        User user = usersDao.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("review", new Review());
//        model.addAttribute("rating", new Rating());
        return "reviews/create";
    }

    @PostMapping("reviews/create")
    public String createReview(@ModelAttribute Review review, Model model, long id){
        User user = usersDao.findById(id);
        review.setAuthor(user);
        model.addAttribute("rating", review);
        reviewsDao.save(review);
        return "redirect:/";
    }

    @GetMapping("/reviews/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("review", reviewsDao.getOne(id));
        return "reviews/edit";
    }

}
