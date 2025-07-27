package com.example.gestorfinanceiro.service;

import com.example.gestorfinanceiro.model.Despesa;
import com.example.gestorfinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> listar() {
        return despesaRepository.findAll();
    }

    public Despesa buscarPorId(Long id) {
        return despesaRepository.findById(id).orElse(null);
    }

    public void salvar(Despesa despesa) {
        despesaRepository.save(despesa);
    }

    public void remover(Long id) {
        despesaRepository.deleteById(id);
    }
}
