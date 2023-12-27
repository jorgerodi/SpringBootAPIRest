package com.example.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PublicacionDTO {
    @JsonProperty("id")
    private Long id;

	@JsonProperty("titulo")
    private String titulo;

    @JsonProperty("descripcion")
    private String descripcion;


    @JsonProperty("contenido")
    private String contenido;
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
    public void setId(Long id) {
        this.id = id;
    }
}
