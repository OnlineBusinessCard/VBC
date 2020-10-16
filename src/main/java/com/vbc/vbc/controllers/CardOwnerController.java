package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Card;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.CardOwnerRepository;
import com.vbc.vbc.repositories.CardRepository;
import com.vbc.vbc.repositories.LeadRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @GetMapping("cardOwner/profile")
    public String cardOwnerProfile(@ModelAttribute Card card, Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        model.addAttribute("user", user);
        return "cardOwner/profile";
    }

}
