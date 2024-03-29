package com.andre.mstrabalhadores.controllers;

import com.andre.mstrabalhadores.entities.Trabalhadores;
import com.andre.mstrabalhadores.services.TrabalhadoresService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value= "trabalhadores")
public class TrabalhadoresController {

    private static Logger logger = LoggerFactory.getLogger(TrabalhadoresController.class);

    @Value("${test.config}")
    private String testConfig;
    @Autowired
    private Environment environment;
    @Autowired
    private TrabalhadoresService trabalhadoresService;

    @GetMapping
    public ResponseEntity<List<Trabalhadores>> findAll() {
        return ResponseEntity.ok(trabalhadoresService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Trabalhadores> findById(@PathVariable Long id) {

        logger.info("PORT " + environment.getProperty("local.server.port"));

        return ResponseEntity.ok(trabalhadoresService.findById(id));
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }
}
