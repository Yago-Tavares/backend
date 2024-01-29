package com.example.backend.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.backend.demo.dtos.BolsistaRecordDto;
import com.example.backend.demo.model.Bolsista;
import com.example.backend.demo.repository.BolsistaRepository;

import jakarta.validation.Valid;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BolsistaController {

    @Autowired
    private BolsistaRepository bolsistaRepository;

    @PostMapping("/bolsista")
    public ResponseEntity<Bolsista> createBolsista(@RequestBody @Valid BolsistaRecordDto bolsistaRecordDto) {        
        var data = new Date();
        System.out.println(data.getTime());
        System.out.println(data.toString());
        var bolsista = new Bolsista();
        BeanUtils.copyProperties(bolsistaRecordDto, bolsista);
        return ResponseEntity.status(HttpStatus.CREATED).body(bolsistaRepository.save(bolsista));

    }

    @GetMapping("/bolsista")    
    public ResponseEntity<Iterable<Bolsista>> getBolsista() {
        return ResponseEntity.status(HttpStatus.OK).body(bolsistaRepository.findAll());
    }

    @PutMapping("/bolsista/{id}")
    public ResponseEntity<Object> putBolsista(@PathVariable UUID id, @RequestBody @Valid BolsistaRecordDto bolsistaRecordDto) {
        Optional<Bolsista> bolsistaObject = bolsistaRepository.findById(id);

        if(bolsistaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bosista não encontrado");
        }
        
        var bolsista = bolsistaObject.get();
        BeanUtils.copyProperties(bolsistaRecordDto, bolsista);
        return ResponseEntity.status(HttpStatus.OK).body(bolsistaRepository.save(bolsista));
    }
    
    @DeleteMapping("/bolsista/{id}")
    public ResponseEntity<Object> deleteBolsista(@PathVariable("id") UUID id){
        Optional<Bolsista> bolsistaObject = bolsistaRepository.findById(id);

        if(bolsistaObject.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bolsista não encontrado");
        }

        bolsistaRepository.delete(bolsistaObject.get());
        return ResponseEntity.status(HttpStatus.OK).body("Bolsista removido com sucesso");
    }
    
}
