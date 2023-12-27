package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.PublicacionDTO;
import com.example.springboot.entity.Publicacion;
import com.example.springboot.repository.PublicacionRepository;




@Service
public class PublicacionServiceImpl implements PublicacionService {
	
	@Autowired
	public  PublicacionRepository publicacionRepository;

    
    @Override
    public PublicacionDTO crearPublicacionDTO(PublicacionDTO publicacionDTO) {
        // Convertimos de DTO a entidad
        Publicacion publicacion = new Publicacion();

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());
       
        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);


        // Convertimos de entidad   a DTO
        PublicacionDTO publicacionResponse = new PublicacionDTO();
        publicacionResponse.setId(nuevaPublicacion.getId());
        publicacionResponse.setTitulo(nuevaPublicacion.getTitulo());
        publicacionResponse.setDescripcion(nuevaPublicacion.getDescripcion());
        publicacionResponse.setContenido(nuevaPublicacion.getContenido());
        
        return publicacionResponse;
    }

}