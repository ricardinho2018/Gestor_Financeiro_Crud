package com.example.gestorfinanceiro.controller;

import com.example.gestorfinanceiro.service.SaldoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaldoController {

    private final SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @GetMapping("/saldo")
    public String verSaldo(Model model) {
        double saldo = saldoService.calcularSaldo();
        model.addAttribute("saldo", saldo);
        return "saldo";
    }
}
