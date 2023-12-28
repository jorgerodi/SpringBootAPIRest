package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.ComentarioDTO;
import com.example.springboot.service.ComentarioServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class ComentarioController {

    @Autowired
    private ComentarioServicio comentarioServicio;

    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDTO> listarComentariosPorPublicacionId(@PathVariable(value = "publicacionId") Long publicacionId){
        return comentarioServicio.obtenerComentarioPorPubliucacionId(publicacionId);
    }
     @GetMapping("/publicaciones/{publicacionId}/comentarios/{comentarioId}")
    public ResponseEntity<ComentarioDTO> listarComentariosPorId(@PathVariable(value = "publicacionId") Long publicacionId, @PathVariable(value = "comentarioId") Long comentarioId){
        
        ComentarioDTO comentarioDTO = comentarioServicio.obtenerComentarioPorId(publicacionId, comentarioId);
                return new ResponseEntity<>(comentarioDTO, HttpStatus.OK);
    }
    

    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDTO> guardarComentario(@PathVariable(value = "publicacionId") long publicacionId, @RequestBody ComentarioDTO comentarioDTO ){
            return new  ResponseEntity<>(comentarioServicio.crearComentario(publicacionId, comentarioDTO),HttpStatus.CREATED);
        
    }
    
}
