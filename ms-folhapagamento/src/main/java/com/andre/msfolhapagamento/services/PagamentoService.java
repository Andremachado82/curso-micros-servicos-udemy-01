package com.andre.msfolhapagamento.services;

import com.andre.msfolhapagamento.entities.Pagamento;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PagamentoService {

    public Pagamento getPagamento(Long idTrabalhador, Integer dias) {
        return new Pagamento("Bob", new BigDecimal(200.00), dias);
    }
}
