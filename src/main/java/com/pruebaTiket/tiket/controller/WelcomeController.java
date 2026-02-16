package com.pruebaTiket.tiket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pruebaTiket.tiket.model.User;

@Controller
public class WelcomeController {


    @GetMapping
    public String wolcome( Model model){

        model.addAttribute("name","Walcome to Prueba1");//pasando parametros a la vista.
        User user1 = new User("Cesar castro", "cesar@gmail.com");
        User user2 = new User("Antonio Hurtado", "antonio@gmail.com");
        User user3 = new User("Felipe Lopez", "felipe@gmail.com");
        List<User>  users = List.of(user1, user2, user3); // se crea una nueva lista de usuarios 
        model.addAttribute("users", users);// se pasa lista de usuarios con la variable "users"

        return "welcome";

    }

    
}