package com.example.gestorfinanceiro.service;

import com.example.gestorfinanceiro.model.Categoria;
import com.example.gestorfinanceiro.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void remover(Long id) {
        categoriaRepository.deleteById(id);
    }
}
