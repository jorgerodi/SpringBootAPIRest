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

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class ComentarioController {

    @Autowired
    private ComentarioServicio comentarioServicio;
 
    // LISTA  COMENTARIO S POR ID DE LA PUBLICACION 
    @GetMapping("/publicaciones/{publicacionId}/comentarios")
    public List<ComentarioDTO> listarComentariosPorPublicacionId(@PathVariable(value = "publicacionId") Long publicacionId){
        return comentarioServicio.obtenerComentarioPorPubliucacionId(publicacionId);
    }

    //ENDPOINT PARA  LISTAR COMENTARIOS  POR ID DE LA PUBLICACION 
     @GetMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentariosPorId(@PathVariable(value = "publicacionId") Long publicacionId, @PathVariable(value = "id") Long comentarioId){
        
        ComentarioDTO comentarioDTO = comentarioServicio.obtenerComentarioPorId(publicacionId, comentarioId);
                return new ResponseEntity<>(comentarioDTO, HttpStatus.OK);
    }
    
     // ENDPOINT PARA GUARDAR COMENTARIO 
    @PostMapping("/publicaciones/{publicacionId}/comentarios")
    public ResponseEntity<ComentarioDTO> guardarComentario(@PathVariable(value = "publicacionId") long publicacionId,@Valid @RequestBody ComentarioDTO comentarioDTO ){
            return new  ResponseEntity<>(comentarioServicio.crearComentario(publicacionId, comentarioDTO),HttpStatus.CREATED);
        
    }

    @PutMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<ComentarioDTO> actualizarComentario( @PathVariable(value = "publicacionId") Long publicacionId, @PathVariable(value = "id") Long comentarioId,@Valid  @RequestBody ComentarioDTO comentarioDTO){
        ComentarioDTO comentarioActualizado = comentarioServicio.actualizarComentario(publicacionId, comentarioId, comentarioDTO);
        return new ResponseEntity<>(comentarioActualizado, HttpStatus.OK);
    }
    @DeleteMapping("/publicaciones/{publicacionId}/comentarios/{id}")
    public ResponseEntity<String> eliminarComentario(@PathVariable(value = "publicacionId") Long publicacionId, @PathVariable(value = "id") Long id ){
        comentarioServicio.eliminarComentario(publicacionId, id);
        return new ResponseEntity<>("Comentario Eliminado con exito", HttpStatus.OK);
    }
    
}
