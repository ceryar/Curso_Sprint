package com.pruebaTiket.tiket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.pruebaTiket.tiket.dto.UserDto;
import com.pruebaTiket.tiket.model.User;
import com.pruebaTiket.tiket.repository.UserRepository;
import com.pruebaTiket.tiket.service.UserService;

import jakarta.validation.Valid;

//import ch.qos.logback.core.model.Model;


@Controller
public class UserController {
    /* se debe crear una carpeta en Template con el nombre de users y crear las vistas
     index.html y show.html
    */
    @Autowired
     private UserService userService; // inyectamos la clase userService



    @GetMapping("/users")
    public String index(
        Model model //para pasarle informacion a a vista utiliza el molelo
    ){
        
        List<User>  users = userService.findAList();// consulta todos usuarios de la base de datos con servicios
        model.addAttribute("users", users); // paso de informacion a la vista
        return "users/index"; // especifica la vista amostar
    }

    @GetMapping("/users/{id}")
    public String show(
        Model model,
        @PathVariable Long id // para poder recibir la variable id
        )
        {
    
       User user = userService.findById(id); // llamado al servicio para realzarla busqueda por ide
        model.addAttribute("user", user); // pasa el objeto a la vista
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
       
       userService.save(userDto); //guardar usuaario utilizando el servicio
        
         return "redirect:/users";// redireciona a la ruta /create
    }

    @GetMapping("/users/{id}/edit")//desde index.html se envian los datos para editar
    public String edit(
        Model model,
        @PathVariable Long id // para poder recibir la variable id
        ){
            User user = userService.findById(id);
            model.addAttribute("id",id);//enviamos el id
            //utiliza contructor coon     
            model.addAttribute("userDto", new UserDto(//pasar  informacion a la vista name i email 
                user.getName(),
                user.getEmail()
            ));
            return "users/edit"; //pasa la ruta update @PostMapping("/users/{id}")
        }

    @PutMapping("/users/{id}")// peticiones de tipo put 
    public String update(//metodo para actualizar
        //recibe el id del usuario  y inyectamos el modelo para pasarle datos a la vista 
        @PathVariable Long id,
        @Valid @ModelAttribute UserDto userDto, // se pasan los datos escritos por el usuario
        BindingResult result,
        Model model
    ){
        if(result.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "user/edit";
        }
         userService.update(id, userDto); //actualizacion utilizando servicio
        return "redirect:/users"; // se redireciona
    }
    @DeleteMapping("/users/{id}")// peticiones de tipo Delete para eliminar usuario 
    public String delete(
        @PathVariable Long id
    ){
       userService.deleteById(id);//elimina el usuario
        return "redirect:/users"; // se redireciona
    }
}

