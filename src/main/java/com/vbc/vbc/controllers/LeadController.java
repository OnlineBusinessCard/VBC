package com.vbc.vbc.controllers;

import com.vbc.vbc.models.Lead;
import com.vbc.vbc.repositories.LeadRepository;
import com.vbc.vbc.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

}
