package com.example.springboot.service;

import java.util.List;

import com.example.springboot.dto.PublicacionDTO;

public interface PublicacionService {
    //Metodos para trabajar con publicaciones de usuarios 
    //CREAR
    public PublicacionDTO crearPublicacionDTO(PublicacionDTO publicacionDTO);
    //LEER TODAS LAS PUBLICACIONES
    public List<PublicacionDTO> obtenerTodasLasPublicaciones();
    public PublicacionDTO obtenerPublicacionPorID(long id);
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id);
    public void eliminarPublicacion(long id);
    
}
