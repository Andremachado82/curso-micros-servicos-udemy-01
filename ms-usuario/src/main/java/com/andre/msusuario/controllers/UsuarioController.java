package com.andre.msusuario.controllers;

import com.andre.msusuario.entities.Usuario;
import com.andre.msusuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {

        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {

        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }
}
