package com.andre.msoauth.controllers;


import com.andre.msoauth.entities.Usuario;
import com.andre.msoauth.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioService usarioService;

    @GetMapping(value = "/search")
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(usarioService.findByEmail(email));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
