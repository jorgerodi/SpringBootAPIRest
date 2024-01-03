package com.example.springboot.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ComentarioDTO {

    private  long id;
    @NotEmpty(message = "EL nombre no puede estar vacio")
    private String nombre;
   
    @NotEmpty(message = "El email no debe  estar vacio o nulo ")
    @Email
    private String email;
    @NotEmpty
    @Size(min = 10,  message= "El cuerpo del comentario debe contener al menos 10 caracteres")
    private String cuerpo;
    
    public ComentarioDTO() {
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }


    
}
