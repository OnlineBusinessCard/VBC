package com.vbc.vbc.controllers;

import com.vbc.vbc.repositories.CardOwnerRepository;
import com.vbc.vbc.repositories.CardRepository;
import com.vbc.vbc.repositories.LeadRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.stereotype.Controller;

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
}
