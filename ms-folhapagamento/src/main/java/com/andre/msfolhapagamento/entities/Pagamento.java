package com.andre.msfolhapagamento.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pagamento {

    private String nome;
    private BigDecimal rendaDiaria;
    private Integer dias;

    public BigDecimal getTotal() {
        return rendaDiaria.multiply(BigDecimal.valueOf(dias)).setScale(2, RoundingMode.UP);
    }
}
