package com.pruebaTiket.tiket.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter // para que la clase Lombook cree kis get
@Setter // para que la clase Lombook cree kis set
@NoArgsConstructor // crea construtor sin parametros
@AllArgsConstructor // constructor con parametros 
public class UserDto {
    /*  se definen los elemensos que se van amanejar entre los controladores
        para mejor seguridad.
     */
    @NotBlank(message = "Name is mandatory")//mensaje  para el error
    @Size(min = 2, max = 100, message = "el campo debe tener 2 o mas caracteres")
    private String name;

    @NotBlank(message = "Name is mandatory")//mensaje  para el error
    @Email(message = "el campo no es de tipo email")
    private String email;
}

