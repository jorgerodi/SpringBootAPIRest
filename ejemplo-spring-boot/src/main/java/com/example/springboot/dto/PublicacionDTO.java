package com.example.springboot.dto;
import com.example.springboot.entity.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Set;


public class PublicacionDTO {
   
   
    private Long id;
     @NotEmpty
     @Size(min = 2, message = "El titulo de la publicacion  deberia  tener  al menos  2  caracteres")
    private String titulo;
      @NotEmpty
     @Size(min = 10, message = "La descripcion de la publicacion deberioa tener  minimo 10 caracteres")
    private String descripcion;
   
    @NotEmpty(message = "El contenido de la publicacion no debe estar vacio ")
    private String contenido;

    private Set<Comentario> comentarios;


    public PublicacionDTO() {

    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Long getId() {
        return id;
    }
    public Set<Comentario> getComentarios() {
        return comentarios;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
