package com.example.springboot.dto;
import com.example.springboot.entity.*;
import java.util.Set;


public class PublicacionDTO {
   
    private Long id;
    private String titulo;
    private String descripcion;
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
