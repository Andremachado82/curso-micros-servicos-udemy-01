package com.andre.msfolhapagamento.clients;

import com.andre.msfolhapagamento.entities.Trabalhadores;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-trabalhadores", path = "/trabalhadores")
public interface TrabalhadorFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Trabalhadores> findById(@PathVariable Long id);
}
