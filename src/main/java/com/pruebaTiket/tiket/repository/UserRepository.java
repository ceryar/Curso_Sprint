package com.pruebaTiket.tiket.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebaTiket.tiket.model.User;

public interface UserRepository extends JpaRepository<User, Long>{ // definicion elementos de la interfaz

    
}
