package com.example.backend.demo.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.demo.model.Bolsista;

@Repository
public interface BolsistaRepository extends CrudRepository<Bolsista, UUID>{
    
}
