package com.example.gestorfinanceiro.controller;

import com.example.gestorfinanceiro.model.Receita;
import com.example.gestorfinanceiro.model.Categoria;
import com.example.gestorfinanceiro.service.ReceitaService;
import com.example.gestorfinanceiro.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;
    private final CategoriaRepository categoriaRepository;

    public ReceitaController(ReceitaService receitaService, CategoriaRepository categoriaRepository) {
        this.receitaService = receitaService;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("receitas", receitaService.listar());
        return "receitas/lista";
    }

    @GetMapping("/nova")
    public String nova(Model model) {
        model.addAttribute("receita", new Receita());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "receitas/form";
    }

    @PostMapping
    public String salvar(@ModelAttribute Receita receita) {
        receitaService.guardar(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Receita receita = receitaService.buscarPorId(id);
        if (receita != null) {
            model.addAttribute("receita", receita);
            model.addAttribute("categorias", categoriaRepository.findAll());
            return "receitas/form";
        }
        return "redirect:/receitas";
    }

    @GetMapping("/apagar/{id}")
    public String apagar(@PathVariable Long id) {
        receitaService.apagar(id);
        return "redirect:/receitas";
    }
}
