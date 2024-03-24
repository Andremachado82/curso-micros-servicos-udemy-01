package com.andre.mstrabalhadores.controllers;

import com.andre.mstrabalhadores.entities.Trabalhadores;
import com.andre.mstrabalhadores.services.TrabalhadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value= "trabalhadores")
public class TrabalhadoresController {

    @Autowired
    private TrabalhadoresService trabalhadoresService;

    @GetMapping
    public ResponseEntity<List<Trabalhadores>> findAll() {
        return ResponseEntity.ok(trabalhadoresService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Trabalhadores> findById(@PathVariable Long id) {
        return ResponseEntity.ok(trabalhadoresService.findById(id));
    }
}
