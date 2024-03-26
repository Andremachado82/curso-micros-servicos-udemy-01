package com.andre.msoauth.services;

import com.andre.msoauth.clients.UsuarioFeignClient;
import com.andre.msoauth.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    public Usuario findByEmail(String email) {
        Usuario usuario = usuarioFeignClient.findByEmail(email).getBody();
        if (usuario == null) {
            logger.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: " + email);

        return usuario;
    }
}
