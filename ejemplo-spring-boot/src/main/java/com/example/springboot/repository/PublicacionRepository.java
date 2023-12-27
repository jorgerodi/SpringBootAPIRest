package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Publicacion;



@Repository
public interface PublicacionRepository extends  JpaRepository<Publicacion, Long>{
    

    
}
