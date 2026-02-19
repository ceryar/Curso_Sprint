package com.pruebaTiket.tiket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaTiket.tiket.dto.UserDto;
import com.pruebaTiket.tiket.model.User;
import com.pruebaTiket.tiket.repository.UserRepository;

@Service
public class UserService {
    @Autowired //intecta el metodo UserRepository
    private UserRepository userRepository;

    public List<User> findAList(){
        return userRepository.findAll();
    }

    public User findById(Long id){ // para buscar el usuario
        return userRepository.findById(id).
        orElseThrow(() -> new IllegalArgumentException("Usuario no disponible"));
    }

    public User save(UserDto userDto){ // para crear el usuario
        User user = User.builder()
        .name(userDto.getName())
        .email(userDto.getEmail())
        .build();
        return userRepository.save(user);
    }
    
    public User update(Long id, UserDto userDto){

        User user = findById(id); //buscamos el usuario con el id
        user.setName(userDto.getName()); // se cambian los datos del usua rio
        user.setEmail(userDto.getEmail());

        return userRepository.save(user); // se aplican los datos

    }

    public void deleteById(Long id)
    {
        userRepository.deleteById(id);
    }
}
