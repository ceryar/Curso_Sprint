package com.pruebaTiket.tiket.dto;

public class UserDto {
    /*  se definen los elemensos que se van amanejar entre los controladores
        para mejor seguridad.
     */
  
    private String name;
    private String email;

    public UserDto(){
        
    }

    
    public UserDto(String name, String email) {
    
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}

