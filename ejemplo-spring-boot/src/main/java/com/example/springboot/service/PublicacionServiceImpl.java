package com.example.springboot.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.PublicacionDTO;
import com.example.springboot.dto.PublicacionRespuesta;
import com.example.springboot.entity.Publicacion;
import com.example.springboot.excepciones.ResourceNotFoundException;
import com.example.springboot.repository.PublicacionRepository;

@Service
public class PublicacionServiceImpl implements PublicacionService {

    @Autowired
    ModelMapper modelMaper;

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
    // se añadio el paginado  para  cargar   ciertos  registros  por pagina  y no sobrecargar la conulta 
    @Override
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor,String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Publicacion> publicaciones = publicacionRepository.findAll(pageable);
        List<Publicacion> ListaDePublicaciones = publicaciones.getContent();
        List<PublicacionDTO> contenido = ListaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());
        PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();
        publicacionRespuesta.setContenido(contenido);
        publicacionRespuesta.setNumeroPagina(publicaciones.getNumber());
        publicacionRespuesta.setMedidaPagina(publicaciones.getSize());
        publicacionRespuesta.setTotalElementos(publicaciones.getTotalElements());
        publicacionRespuesta.setTotalPaginas(publicaciones.getTotalPages());
        publicacionRespuesta.setUltima(publicaciones.isLast());
        return publicacionRespuesta;
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

  // ESTE METODO CONVIERTE DE ENTIDAD A DTO
    private PublicacionDTO mapearDTO(Publicacion publicacion) {
      PublicacionDTO publicacionDTO = modelMaper.map(publicacion, PublicacionDTO.class);

        return publicacionDTO;
    }

    // ESTE METODO CONVIERTE DE DTO A ENTIDAD
    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
        Publicacion publicacion  = modelMaper.map(publicacionDTO, Publicacion.class);

        return publicacion;
    }

}