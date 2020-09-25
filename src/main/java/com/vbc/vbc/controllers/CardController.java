package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Card;
import com.vbc.vbc.repositories.CardRepository;
import com.vbc.vbc.repositories.ImageRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CardController {

    private final CardRepository cardsDao;
    private final UserRepository usersDao;
    private final ImageRepository imageDao;


    public CardController(CardRepository cardsDao, UserRepository usersDao, ImageRepository imageDao) {
        this.cardsDao = cardsDao;
        this.usersDao = usersDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/card/{id}")
    public String myCard(@PathVariable long id, Model model){
        Card card = cardsDao.getOne(id);
        model.addAttribute("card", card);
        return "card/view";
    }


}
