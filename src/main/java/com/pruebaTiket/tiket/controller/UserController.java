package com.pruebaTiket.tiket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.pruebaTiket.tiket.dto.UserDto;
import com.pruebaTiket.tiket.model.User;

//import ch.qos.logback.core.model.Model;


@Controller

public class UserController {
    /* se debe crear una carpeta en Template con el nombre de users y crear las vistas
     index.html y show.html
    */

    @GetMapping("/users")
    public String index(
        Model model //para pasarle informacion a a vista utiliza el molelo

    ){
        User user1 = new User(//listado de usuarios
            1L,
            "Cesar castro",
             "cesar@gmail.com");
        User user2 = new User(
            2L,
            "Antonio Hurtado",
             "antonio@gmail.com");
        User user3 = new User(
            3L,
            "Felipe Lopez",
             "felipe@gmail.com");
        List<User>  users = List.of(user1, user2, user3);
        model.addAttribute("users", users); // paso de informacion a la vista
        return "users/index"; // especifica la vista amostar
    }

    @GetMapping("/users/{id}")
    public String show(
        Model model,
        @PathVariable Long id // para poder recibir la variable id
        
    ){
        model.addAttribute("usersId", id); //  paso de variable a a la vista
        return "users/show";

    }

    @GetMapping("/users/create") // vista formulario crear user 
    public String create(){
        return "users/create";
    }

    @PostMapping("/users")
    @ResponseBody // retorna el cuerpo del html, no una vista 
    public UserDto store(//retorna un objeto de UserDto con los atrivutos y metos definidos
        @ModelAttribute UserDto userDto //captura los elementos de userDto
    ){
        return userDto; // retorna los valores del formulario administrados por la clase UserDto
        
    }

 
}