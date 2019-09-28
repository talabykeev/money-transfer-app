package com.tal.moneytransferapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String homePage(Model model) {
        model.addAttribute("name","Tal");
        return "home";
    }
}
