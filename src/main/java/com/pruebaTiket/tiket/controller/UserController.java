package com.pruebaTiket.tiket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pruebaTiket.tiket.dto.UserDto;
import com.pruebaTiket.tiket.model.User;
import com.pruebaTiket.tiket.repository.UserRepository;

import jakarta.validation.Valid;

//import ch.qos.logback.core.model.Model;


@Controller

public class UserController {
    /* se debe crear una carpeta en Template con el nombre de users y crear las vistas
     index.html y show.html
    */
   private final UserRepository userRepository;  // llamar al repositorio del usuario "Interfaz"

   public UserController(UserRepository userRepository){ //inyectamos repositorio
    this.userRepository = userRepository;
   }


    @GetMapping("/users")
    public String index(
        Model model //para pasarle informacion a a vista utiliza el molelo

    ){
        
        List<User>  users = userRepository.findAll();// consulta todos usuarios de la base de datos con el repositorio
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
    public String create(Model model){ //pasar modeo a la vista 
        //<!-- contexto de userDTO -->
        model.addAttribute("userDto", new UserDto());
        return "users/create";
    }

    @PostMapping("/users")
    
    public String store(//retorna un objeto de UserDto con los atrivutos y metos definidos
       @Valid @ModelAttribute UserDto userDto, //captura los elementos de userDto y validacion
       BindingResult result,// objeto contine el resultado de la validacion.
       Model model
    ){
        if(result.hasErrors()){
            //<!-- contexto de userDTO -->
            model.addAttribute("userDto", userDto); // sepasa el userDto que existe
            return "users/create";
        }
        //Crear usuaario
        /*
        User user = new User();
        user.setName(userDto.getName());
        user.equals(userDto.getEmail());
         */
        //crear objeto en memoria
        User user = User.builder()
        .name(userDto.getName())
        .email(userDto.getEmail())
        .build();
        userRepository.save(user); // almacenamiento en la base de datos con el objeto user
        
       return "redirect:/users";// redireciona a la ruta /create
    }
}

