package com.example.springboot.controller;
import com.example.springboot.dto.PublicacionDTO;
import com.example.springboot.service.PublicacionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionService;
 
    @PostMapping
    public ResponseEntity<PublicacionDTO> guardarPublicacion(@RequestBody PublicacionDTO publicacionDTO) {
        // Realiza cualquier validación necesaria antes de crear la publicación

        // Llama al servicio para crear la publicación y devuelve la respuesta
        PublicacionDTO nuevaPublicacion = publicacionService.crearPublicacionDTO(publicacionDTO);
        
        // Devuelve la respuesta con el código de estado 201 CREATED
        return new ResponseEntity<>(nuevaPublicacion, HttpStatus.CREATED);
    }

    @GetMapping
    public List<PublicacionDTO> listarPublicaciones (){
        return publicacionService.obtenerTodasLasPublicaciones();
    }

    @GetMapping("/{id}")
    public  ResponseEntity<PublicacionDTO> obtenerPublicacionPorId(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(publicacionService.obtenerPublicacionPorID(id));
    }
    @PutMapping("/{id}")
      public  ResponseEntity<PublicacionDTO> actualizarPublicacion(@RequestBody PublicacionDTO publicacionDTO, @PathVariable(name = "id") long id){

      PublicacionDTO publicacionResponse = publicacionService.actualizarPublicacion(publicacionDTO, id);
        return new ResponseEntity<>(publicacionResponse,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> eliminarPublicacion(@PathVariable(name = "id") long id){
        publicacionService.eliminarPublicacion(id);
        return new ResponseEntity<>("Publicacion eliminada con exito", HttpStatus.OK);
    }
    }
    
    
    

