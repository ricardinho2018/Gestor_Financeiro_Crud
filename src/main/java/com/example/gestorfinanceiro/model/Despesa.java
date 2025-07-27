package com.example.gestorfinanceiro.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private double valor;

    private LocalDate data;

    @ManyToOne
    private Categoria categoria;

    // Getters e setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }

    public LocalDate getData() { return data; }

    public void setData(LocalDate data) { this.data = data; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
