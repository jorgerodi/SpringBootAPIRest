package com.example.springboot.service;

import java.util.List;

import com.example.springboot.dto.ComentarioDTO;

public interface ComentarioServicio {
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);
    public List<ComentarioDTO> obtenerComentarioPorPubliucacionId(long publicacionId);
    public  ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId)
    
}
