package com.andre.mstrabalhadores.repositories;

import com.andre.mstrabalhadores.entities.Trabalhadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhadoresRepository extends JpaRepository<Trabalhadores, Long> {
}
