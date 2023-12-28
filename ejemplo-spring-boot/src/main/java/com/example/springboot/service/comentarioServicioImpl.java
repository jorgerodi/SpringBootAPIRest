package com.example.springboot.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.ComentarioDTO;
import com.example.springboot.entity.Comentario;
import com.example.springboot.entity.Publicacion;
import com.example.springboot.excepciones.BlogAppException;
import com.example.springboot.excepciones.ResourceNotFoundException;
import com.example.springboot.repository.ComentarioRepository;
import com.example.springboot.repository.PublicacionRepository;

@Service
public class comentarioServicioImpl implements ComentarioServicio {

    @Autowired
    private ComentarioRepository comentarioRepositorio;
    @Autowired
    private PublicacionRepository publicacionRepository;

    @Override
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO) {
        Comentario comentario = mapearEntidad(comentarioDTO);
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));
        comentario.setPublicacion(publicacion);
        Comentario nuevoComentario = comentarioRepositorio.save(comentario);
        return mapearDTO(nuevoComentario);
    }

     @Override
    public ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId) {
         Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));
                Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));
            
                
                if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
                    throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece  a la pulicacion ");
                }
                return mapearDTO(comentario);

    }

    // MAPEAR DE ENTIDAD A DTO
    private ComentarioDTO mapearDTO(Comentario comentario) {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setId(comentario.getId());
        comentarioDTO.setNombre(comentario.getNombre());
        comentarioDTO.setEmail(comentario.getEmail());
        comentarioDTO.setCuerpo(comentario.getCuerpo());
        return comentarioDTO;

    }

    // MAPEAR DTO A ENTIDAD
    private Comentario mapearEntidad(ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();
        comentario.setId(comentarioDTO.getId());
        comentario.setNombre(comentarioDTO.getNombre());
        comentario.setEmail(comentarioDTO.getEmail());
        comentario.setCuerpo(comentarioDTO.getCuerpo());
        return comentario;

    
}

    @Override
    public List<ComentarioDTO> obtenerComentarioPorPubliucacionId(long publicacionId) {
     List <Comentario> comentarios = comentarioRepositorio.findByPublicacionId(publicacionId);

       return comentarios.stream().map(comentario -> mapearDTO(comentario)).collect(Collectors.toList());    
}

   
}