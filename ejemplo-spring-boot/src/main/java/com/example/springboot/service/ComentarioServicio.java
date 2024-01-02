package com.example.springboot.service;

import java.util.List;

import com.example.springboot.dto.ComentarioDTO;

public interface ComentarioServicio {
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);
    public List<ComentarioDTO> obtenerComentarioPorPubliucacionId(Long publicacionId);
    public  ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId);
    public ComentarioDTO actualizarComentario(Long publicacionId, Long comentarioId, ComentarioDTO solicitudComentario );
    public void eliminarComentario(Long publicacionId, Long comentarioId) ;
    
}
