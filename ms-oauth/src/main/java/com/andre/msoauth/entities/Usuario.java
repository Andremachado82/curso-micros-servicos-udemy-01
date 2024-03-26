package com.andre.msoauth.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private Set<Role> roles = new HashSet<>();
}
