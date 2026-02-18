package com.pruebaTiket.tiket.dto;

import lombok.*;

@Getter // para que la clase Lombook cree kis get
@Setter // para que la clase Lombook cree kis set
@NoArgsConstructor // crea construtor sin parametros
@AllArgsConstructor // constructor con parametros 
public class UserDto {
    /*  se definen los elemensos que se van amanejar entre los controladores
        para mejor seguridad.
     */
  
    private String name;
    private String email;
}

