package com.example.springboot.service;



import com.example.springboot.dto.PublicacionDTO;
import com.example.springboot.dto.PublicacionRespuesta;

public interface PublicacionService {
    //Metodos para trabajar con publicaciones de usuarios 
    //CREAR
    public PublicacionDTO crearPublicacionDTO(PublicacionDTO publicacionDTO);
    //LEER TODAS LAS PUBLICACIONES
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir);
    public PublicacionDTO obtenerPublicacionPorID(long id);
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id);
    public void eliminarPublicacion(long id);
    
}
