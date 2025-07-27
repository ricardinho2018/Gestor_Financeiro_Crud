package com.example.gestorfinanceiro.service;

import com.example.gestorfinanceiro.model.Receita;
import com.example.gestorfinanceiro.repository.ReceitaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReceitaService {
    private final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public List<Receita> listar() {
        return receitaRepository.findAll();
    }

    public Receita guardar(Receita receita) {
        return receitaRepository.save(receita);
    }

    public Receita buscarPorId(Long id) {
        return receitaRepository.findById(id).orElse(null);
    }

    public void apagar(Long id) {
        receitaRepository.deleteById(id);
    }
}
