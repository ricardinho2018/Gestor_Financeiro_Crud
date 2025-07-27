package com.example.gestorfinanceiro.controller;

import com.example.gestorfinanceiro.model.Despesa;
import com.example.gestorfinanceiro.model.Categoria;
import com.example.gestorfinanceiro.repository.DespesaRepository;
import com.example.gestorfinanceiro.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    @GetMapping
    public String listarDespesas(Model model) {
        model.addAttribute("despesas", despesaRepo.findAll());
        return "despesas/lista";
    }

    @GetMapping("/nova")
    public String novaDespesa(Model model) {
        model.addAttribute("despesa", new Despesa());
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "despesas/form";
    }

    @PostMapping
    public String salvarDespesa(@ModelAttribute Despesa despesa) {
        despesaRepo.save(despesa);
        return "redirect:/despesas";
    }

    @GetMapping("/editar/{id}")
    public String editarDespesa(@PathVariable Long id, Model model) {
        model.addAttribute("despesa", despesaRepo.findById(id).orElseThrow());
        model.addAttribute("categorias", categoriaRepo.findAll());
        return "despesas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDespesa(@PathVariable Long id) {
        despesaRepo.deleteById(id);
        return "redirect:/despesas";
    }
}
