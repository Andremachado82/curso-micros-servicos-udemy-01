package com.andre.msfolhapagamento.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trabalhadores {

    private Long id;

    private String nome;

    private BigDecimal rendaDiaria;
}
