package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Card;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.CardRepository;
import com.vbc.vbc.repositories.ImageRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/card/create")
    public String showCardForm(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("Card", new Card());
        return "card/create";
    }

    @PostMapping("/card/create")
    public String createCard(@ModelAttribute Card card, @RequestParam String imageUpload){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setCard(user.getCard());
        cardsDao.save(card);
        return "redirect:/card/{id}";
    }

    @GetMapping("/card/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("card", cardsDao.getOne(id));
        return "card/edit";
    }

    @PostMapping("/card/{id}/edit")
    public String editCard(@PathVariable long id, @ModelAttribute Card card) {
        User user = usersDao.getOne(1L);
        card.setUser(user);
        cardsDao.save(card);
        return "redirect:/card/view";
    }

}
