package com.example.gestorfinanceiro.repository;

import com.example.gestorfinanceiro.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
