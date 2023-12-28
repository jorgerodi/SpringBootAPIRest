package com.example.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.PublicacionDTO;
import com.example.springboot.entity.Publicacion;
import com.example.springboot.excepciones.ResourceNotFoundException;
import com.example.springboot.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    public PublicacionRepository publicacionRepository;

    // crear un nuevo registro
    @Override
    public PublicacionDTO crearPublicacionDTO(PublicacionDTO publicacionDTO) {
        // Convertimos de DTO a entidad
        Publicacion publicacion = mapearEntidad(publicacionDTO);
        Publicacion nuevaPublicacion = publicacionRepository.save(publicacion);
        PublicacionDTO publicacionResponse = mapearDTO(nuevaPublicacion);

        return publicacionResponse;
    }

    // cargar todos los registros
    // se añadio el paginado  para  cargar   ciertos  registros  por pagina  y no s
    @Override
    public List<PublicacionDTO> obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina) {

        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina);
        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);
        List<Publicacion> ListaDePublicaciones = publicaciones.getContent();
        return ListaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());
    }

    // ESTE METODO CONVIERTE DE ENTIDAD A DTO
    private PublicacionDTO mapearDTO(Publicacion publicacion) {
        PublicacionDTO publicacionDTO = new PublicacionDTO();
        publicacionDTO.setId(publicacion.getId());
        publicacionDTO.setTitulo(publicacion.getTitulo());
        publicacionDTO.setDescripcion(publicacion.getDescripcion());
        publicacionDTO.setContenido(publicacion.getContenido());
        return publicacionDTO;
    }

    // ESTE METODO CONVIERTE DE DTO A ENTIDAD
    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        return publicacion;
    }

    @Override
    public PublicacionDTO obtenerPublicacionPorID(long id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacioion", "id", id));
        return mapearDTO(publicacion);
    }

    @Override
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id) {
        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacioion", "id", id));
        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());
        Publicacion publicacionActualizada = publicacionRepository.save(publicacion);
        return mapearDTO(publicacionActualizada);

    }

    @Override
    public void eliminarPublicacion(long id) {
          Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacioion", "id", id));
                publicacionRepository.delete(publicacion);
    }



}