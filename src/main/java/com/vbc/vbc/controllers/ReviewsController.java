package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Review;
import com.vbc.vbc.repositories.ReviewRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
