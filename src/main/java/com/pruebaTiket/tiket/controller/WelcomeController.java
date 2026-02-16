package com.pruebaTiket.tiket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pruebaTiket.tiket.model.User;

@Controller
public class WelcomeController {


    @GetMapping
    public String wolcome( Model model){

        model.addAttribute("name","Walcome to Prueba1");//pasando parametros a la vista.
        model.addAttribute("user", new User("Cesar", "cesar@gmail.com"));

        return "welcome";

    }

    
}