package com.pruebaTiket.tiket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pruebaTiket.tiket.model.User;

@Controller
public class WelcomeController {


    @GetMapping("/")
    public String wolcome( Model model){

        
        return "welcome";

    }

    
}