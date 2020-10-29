package com.vbc.vbc.controllers;

import com.vbc.vbc.models.*;
import com.vbc.vbc.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CardOwnerController {

    private final UserRepository usersDao;
    private final CardOwnerRepository cardOwnersDao;
    private final CardRepository cardsDao;
    private final LeadRepository leadsDao;
    private final ReviewRepository reviewsDao;

    public CardOwnerController(UserRepository usersDao, CardOwnerRepository cardOwnersDao, CardRepository cardsDao, LeadRepository leadsDao, ReviewRepository reviewsDao) {
        this.usersDao = usersDao;
        this.cardOwnersDao = cardOwnersDao;
        this.cardsDao = cardsDao;
        this.leadsDao = leadsDao;
        this.reviewsDao = reviewsDao;
    }

    @GetMapping("card-owner/profile")
    public String cardOwnerProfile(@ModelAttribute Card card, Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        List<Lead> leads = leadsDao.findAll();
        List<Review> reviews = reviewsDao.findAll();
        List<Card> cards = cardsDao.findAll();
        model.addAttribute("user", user);
        model.addAttribute("leads", leads);
        model.addAttribute("review", reviews);
        model.addAttribute("cards",cards);
        return "cardOwner/profile";
    }

    @GetMapping("/card-owner/bio")
    public String cardOwnerBio(Model model){
        User owner = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", owner);
        model.addAttribute("cardOwner", new CardOwner());
        return "cardOwner/bio";
    }

    @PostMapping("/card-owner/bio")
    public String createBio(@ModelAttribute CardOwner cardOwner){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User owner = usersDao.getOne(sessionUser.getId());
        cardOwnersDao.getOne(sessionUser.getId());
        cardOwnersDao.save(cardOwner);
        owner.setCardOwner(cardOwner);
        usersDao.save(owner);
        return "redirect:/dashboard";
    }

    @GetMapping("/owners")
    public String showOwners(Model model){
        List<User> allOwners = usersDao.findAllCardOwners();
        model.addAttribute("owners", allOwners);
        return "cardOwner/owners";
    }

    @GetMapping("/cardOwner/profile/{id}")
    public String ownerProfile(@PathVariable long id, Model model){
        User owner = usersDao.getOne(id);
        List<Review> reviews = reviewsDao.findAllReviewsByCardOwner(owner.getCardOwner().getId());
        model.addAttribute("reviews", reviews);
        model.addAttribute("owner", owner);
        return "cardOwner/show";
    }

    @GetMapping("/owner/edit-owner")
    public String editOwner(Model model, @PathVariable long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CardOwner cardOwner = cardOwnersDao.getOne(id);
        model.addAttribute("user", user);
        model.addAttribute("owner", cardOwner);
        return "cardOwner/edit-owner";
    }

    @PostMapping("/owner/edit-owner")
    public String editOwnerPage(@ModelAttribute CardOwner cardOwner, @RequestParam long id){
        CardOwner owner = cardOwnersDao.getOne(id);
        owner.setBio(cardOwner.getBio());
        owner.setPhone(cardOwner.getPhone());
        cardOwnersDao.save(owner);
        return "redirect:/dashboard";
    }


}
