package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.dto.PublicacionDTO;
import com.example.springboot.service.PublicacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
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
}
