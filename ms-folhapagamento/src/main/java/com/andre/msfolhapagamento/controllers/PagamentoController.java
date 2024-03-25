package com.andre.msfolhapagamento.controllers;

import com.andre.msfolhapagamento.entities.Pagamento;
import com.andre.msfolhapagamento.services.PagamentoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @HystrixCommand(fallbackMethod = "getPagamentoAlternativo")
    @GetMapping(value = "/{idTrabalhador}/dias/{dias}")
    public ResponseEntity<Pagamento> getPagamento(@PathVariable Long idTrabalhador, @PathVariable Integer dias) {
        return ResponseEntity.ok(pagamentoService.getPagamento(idTrabalhador, dias));
    }

    public ResponseEntity<Pagamento> getPagamentoAlternativo(Long workerId, Integer days) {
        Pagamento pagamento = new Pagamento("Brann", new BigDecimal(400), days);
        return ResponseEntity.ok(pagamento);
    }
}
