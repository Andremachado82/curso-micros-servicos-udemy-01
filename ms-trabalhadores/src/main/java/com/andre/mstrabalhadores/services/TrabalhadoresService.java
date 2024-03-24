package com.andre.mstrabalhadores.services;

import com.andre.mstrabalhadores.TrabalhadoresRepository;
import com.andre.mstrabalhadores.entities.Trabalhadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhadoresService {
    @Autowired
    private TrabalhadoresRepository trabalhadoresRepository;

    public List<Trabalhadores> findAll() {
        return trabalhadoresRepository.findAll();
    }

    public Trabalhadores findById(Long id) {
        return trabalhadoresRepository.findById(id).orElseThrow();
    }
}
