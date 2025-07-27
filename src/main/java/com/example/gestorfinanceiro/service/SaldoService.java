package com.example.gestorfinanceiro.service;

import com.example.gestorfinanceiro.repository.ReceitaRepository;
import com.example.gestorfinanceiro.repository.DespesaRepository;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {

    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    public SaldoService(ReceitaRepository receitaRepository, DespesaRepository despesaRepository) {
        this.receitaRepository = receitaRepository;
        this.despesaRepository = despesaRepository;
    }

    public double calcularSaldo() {
        double totalReceitas = receitaRepository.findAll()
                .stream()
                .mapToDouble(r -> r.getValor())
                .sum();

        double totalDespesas = despesaRepository.findAll()
                .stream()
                .mapToDouble(d -> d.getValor())
                .sum();

        return totalReceitas - totalDespesas;
    }
}
