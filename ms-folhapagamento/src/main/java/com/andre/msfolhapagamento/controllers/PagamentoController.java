package com.andre.msfolhapagamento.controllers;

import com.andre.msfolhapagamento.entities.Pagamento;
import com.andre.msfolhapagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping(value = "/{idTrabalhador}/dias/{dias}")
    public ResponseEntity<Pagamento> getPagamento(@PathVariable Long idTrabalhador, @PathVariable Integer dias) {
        return ResponseEntity.ok(pagamentoService.getPagamento(idTrabalhador, dias));
    }
}
