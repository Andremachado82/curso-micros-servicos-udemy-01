package com.andre.msoauth.clients;

import com.andre.msoauth.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "ms-usuario", path = "/usuarios")
public interface UsuarioFeignClient {

    @GetMapping(value = "/search")
    ResponseEntity<Usuario> findByEmail(@RequestParam String email);
}
