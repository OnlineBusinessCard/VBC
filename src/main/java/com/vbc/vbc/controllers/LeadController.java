package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Lead;
import com.vbc.vbc.models.User;
import com.vbc.vbc.repositories.LeadRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LeadController {

    private final LeadRepository leadDao;
    private final UserRepository userDao;

    public LeadController(LeadRepository leadDao, UserRepository userDao) {
        this.leadDao = leadDao;
        this.userDao = userDao;
    }

    @GetMapping("/leads")
    public String index(Model model){
        List<Lead> myLead = leadDao.findAll();
        model.addAttribute("lead", myLead);
        return "leads/index";
    }

    @GetMapping("/leads/{id}")
    public String showLead(@PathVariable long id, Model model){
        Lead pulledLead = leadDao.getOne(id);
        model.addAttribute("leads", pulledLead);
        return "leads/show";
    }

    @GetMapping("/leads/create/{id}")
    public String showCreateLeadForm(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("lead", new Lead());
        return "leads/create";
    }

    @PostMapping("/leads/create")
    public String createLead(@ModelAttribute Lead lead, @RequestParam(name="userId") long userId){
        User user = userDao.findById(userId);
        lead.setUser(user);
        lead.setCreateDateTime(lead.getCreateDateTime());
        leadDao.save(lead);
        return "redirect:/";
    }

}
