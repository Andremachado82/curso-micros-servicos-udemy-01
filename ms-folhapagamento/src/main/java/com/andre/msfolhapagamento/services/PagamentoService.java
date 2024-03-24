package com.andre.msfolhapagamento.services;

import com.andre.msfolhapagamento.entities.Pagamento;
import com.andre.msfolhapagamento.entities.Trabalhadores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PagamentoService {

    @Value("${ms-trabalhadores.host}")
    private String hostMsTrabalhadores;

    @Autowired
    private RestTemplate restTemplate;

    public Pagamento getPagamento(Long idTrabalhador, Integer dias) {
        Map<String, String> uriVariaveis = new HashMap<>();
        uriVariaveis.put("id", idTrabalhador.toString());
        Trabalhadores trabalhadores =
                restTemplate.getForObject(hostMsTrabalhadores + "/trabalhadores/{id}", Trabalhadores.class, uriVariaveis);

        if (trabalhadores != null) return new Pagamento(trabalhadores.getNome(), trabalhadores.getRendaDiaria(), dias);

        return null;
    }
}
