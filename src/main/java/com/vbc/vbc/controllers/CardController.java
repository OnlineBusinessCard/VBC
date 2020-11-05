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

import java.util.List;

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

    //VIEW ALL CARDS
    @GetMapping("/cards")
    public String cardIndexPage(Model model){
        List<Card> cards = cardsDao.findAll();
        model.addAttribute("cards", cards);
        return "cards/index";
    }

    //VIEW CARD
    @GetMapping("/card/{id}")
    public String myCard(@PathVariable long id, Model model){
        Card card = cardsDao.getOne(id);
        model.addAttribute("card", card);
        return "card/view";
    }

    //CREATE CARD
    @GetMapping("/card/create")
    public String showCardForm(Model model){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        model.addAttribute("user", user);
        model.addAttribute("Card", new Card());
        return "card/create";
    }

    //CREATE CARD
    @PostMapping("/card/create")
    public String createCard(@ModelAttribute Card card){
        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersDao.getOne(sessionUser.getId());
        card.setUser(user);
        cardsDao.save(card);
        return "redirect:/card/{id}";
    }

    //EDIT CARD
    @GetMapping("/card/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("card", cardsDao.getOne(id));
        return "card/edit";
    }

    //EDIT CARD
    @PostMapping("/card/{id}/edit")
    public String editCard(@PathVariable long id, @ModelAttribute Card card) {
        User user = usersDao.getOne(1L);
        Card cards = cardsDao.getOne(id);
        card.setUser(user);
        cards.setCity(card.getCity());
        cards.setCompany(card.getCompany());
        cards.setCountry(card.getCountry());
        cards.setFirstName(card.getFirstName());
        cards.setLastName(card.getLastName());
        cards.setPhone(card.getPhone());
        cards.setState(card.getState());
        cards.setTitle(card.getTitle());
        cards.setWebsite(card.getWebsite());
        cardsDao.save(cards);
        return "redirect:/card/view";
    }

    //DELETE CARD
    @GetMapping("/card/{id}/delete")
    public String deletePage(@PathVariable long id, Model model){
        Card pulledCard = cardsDao.getOne(id);
        model.addAttribute("card", pulledCard);
        return "card/delete";
    }

    // DELETE CARD
    @PostMapping("/card/{id}/delete")
    public String deleteCard(@ModelAttribute Card card){
        Card deleteCard = cardsDao.getOne(card.getId());
        cardsDao.delete(deleteCard);
        return "redirect:/dashboard";
    }

}
