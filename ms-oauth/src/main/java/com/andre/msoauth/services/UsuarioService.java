package com.andre.msoauth.services;

import com.andre.msoauth.clients.UsuarioFeignClient;
import com.andre.msoauth.entities.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioFeignClient usuarioFeignClient;

    public Usuario findByEmail(String email) {
        Usuario usuario = usuarioFeignClient.findByEmail(email).getBody();
        if (usuario == null) {
            logger.error("Email não encontrado: " + email);
            throw new IllegalArgumentException("Email não encontrado");
        }
        logger.info("Email encontrado: " + email);

        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String usuarioEmail) throws UsernameNotFoundException {
        Usuario usuario = usuarioFeignClient.findByEmail(usuarioEmail).getBody();
        if (usuario == null) {
            logger.error("Email não encontrado: " + usuarioEmail);
            throw new UsernameNotFoundException("Email não encontrado");
        }
        logger.info("Email encontrado: " + usuarioEmail);

        return usuario;
    }
}
