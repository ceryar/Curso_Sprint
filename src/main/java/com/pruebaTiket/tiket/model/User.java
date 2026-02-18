package com.pruebaTiket.tiket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
/*Con lombok solo se define los atributos de las clases
 */
@Getter // para que la clase Lombook cree kis get
@Setter // para que la clase Lombook cree kis set
@NoArgsConstructor // crea construtor sin parametros
@AllArgsConstructor // constructor con parametros
@Builder
@Entity//crear tabla en la base de datos
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}