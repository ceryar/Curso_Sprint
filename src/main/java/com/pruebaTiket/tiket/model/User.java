package com.pruebaTiket.tiket.model;

import lombok.*;

@Getter // para que la clase Lombook cree kis get
@Setter // para que la clase Lombook cree kis set
@NoArgsConstructor // crea construtor sin parametros
@AllArgsConstructor // constructor con parametros
@Builder

/*Con lombok solo se define los atributos de las clases
 */

public class User {

    private Long id;
    private String name;
    private String email;
}