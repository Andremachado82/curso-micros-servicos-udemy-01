package com.andre.msfolhapagamento.services;

import com.andre.msfolhapagamento.clients.TrabalhadorFeignClient;
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

    @Autowired
    private TrabalhadorFeignClient feignClient;

    public Pagamento getPagamento(Long idTrabalhador, Integer dias) {
        Trabalhadores trabalhadores = feignClient.findById(idTrabalhador).getBody();
        if (trabalhadores != null) return new Pagamento(trabalhadores.getNome(), trabalhadores.getRendaDiaria(), dias);

        return null;
    }
}
