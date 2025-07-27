package com.example.gestorfinanceiro.repository;

import com.example.gestorfinanceiro.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
