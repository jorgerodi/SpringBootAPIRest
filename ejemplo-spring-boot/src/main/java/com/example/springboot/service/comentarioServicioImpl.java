package com.example.springboot.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
public class ComentarioServicioImpl implements ComentarioServicio {


    @Autowired
    ModelMapper modelMaper;
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

  

    // MAPEAR DE ENTIDAD A DTO
    private ComentarioDTO mapearDTO(Comentario comentario) {
        ComentarioDTO comentarioDTO = modelMaper.map(comentario, ComentarioDTO.class);
        return comentarioDTO;

    }

    // MAPEAR DTO A ENTIDAD
    private Comentario mapearEntidad(ComentarioDTO comentarioDTO) {
        Comentario comentario = modelMaper.map(comentarioDTO, Comentario.class);
        return comentario;

    
}

    @Override
    public List<ComentarioDTO> obtenerComentarioPorPubliucacionId(Long publicacionId) {
     List <Comentario> comentarios = comentarioRepositorio.findByPublicacionId(publicacionId);

       return comentarios.stream().map(comentario -> mapearDTO(comentario)).collect(Collectors.toList());    
}
   @Override
    public ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId) {
         Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));
                Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));
            
                
                if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
                    throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece  a la pulicacion ");
                }
                return mapearDTO(comentario);

    }


    @Override
    public ComentarioDTO actualizarComentario(Long publicacionId, Long comentarioId ,ComentarioDTO solicitudComentario) {
      Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));
                Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));
            
                
                if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
                    throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece  a la pulicacion ");
                }
               comentario.setNombre((solicitudComentario.getNombre()));
               comentario.setEmail(solicitudComentario.getEmail());
               comentario.setCuerpo(solicitudComentario.getCuerpo());
               Comentario comentarioActualizado = comentarioRepositorio.save(comentario);

            return mapearDTO(comentarioActualizado);
}



    @Override
    public void eliminarComentario(Long publicacionId, Long comentarioId) {
         Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));
                Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));
            
                
                if(!comentario.getPublicacion().getId().equals(publicacion.getId())){
                    throw new BlogAppException(HttpStatus.BAD_REQUEST, "El comentario no pertenece  a la pulicacion ");
                }
                comentarioRepositorio.delete(comentario);
   
    }
}