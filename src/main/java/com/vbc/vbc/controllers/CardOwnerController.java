package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Card;
import com.vbc.vbc.models.CardOwner;
import com.vbc.vbc.models.Lead;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.CardOwnerRepository;
import com.vbc.vbc.repositories.CardRepository;
import com.vbc.vbc.repositories.LeadRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CardOwnerController {

    private final UserRepository usersDao;
    private final CardOwnerRepository cardOwnersDao;
    private final CardRepository cardsDao;
    private final LeadRepository leadsDao;

    public CardOwnerController(UserRepository usersDao, CardOwnerRepository cardOwnersDao, CardRepository cardsDao, LeadRepository leadsDao) {
        this.usersDao = usersDao;
        this.cardOwnersDao = cardOwnersDao;
        this.cardsDao = cardsDao;
        this.leadsDao = leadsDao;
    }

    @GetMapping("card-owner/profile")
    public String cardOwnerProfile(@ModelAttribute Card card, Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        List<Lead> leads = leadsDao.findAll();
        model.addAttribute("user", user);
        model.addAttribute("leads", leads);
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

}
