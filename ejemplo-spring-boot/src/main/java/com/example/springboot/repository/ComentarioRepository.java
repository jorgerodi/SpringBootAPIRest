package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entity.Comentario;
import java.util.List;


public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    public  List<Comentario> findByPublicacionId(long publicacionId); 
    
}
