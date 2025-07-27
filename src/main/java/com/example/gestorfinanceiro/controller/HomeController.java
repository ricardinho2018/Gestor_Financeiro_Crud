package com.example.gestorfinanceiro.controller;

import com.example.gestorfinanceiro.repository.ReceitaRepository;
import com.example.gestorfinanceiro.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ReceitaRepository receitaRepo;

    @Autowired
    private DespesaRepository despesaRepo;

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        double totalReceitas = receitaRepo.findAll()
                .stream()
                .mapToDouble(r -> r.getValor())
                .sum();

        double totalDespesas = despesaRepo.findAll()
                .stream()
                .mapToDouble(d -> d.getValor())
                .sum();

        double saldo = totalReceitas - totalDespesas;

        model.addAttribute("saldo", String.format("%.2f", saldo));
        return "index";
    }
}
