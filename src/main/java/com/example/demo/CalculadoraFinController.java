package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CalculadoraFinService;

@SpringBootApplication
@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*")
public class CalculadoraFinController {
    @Autowired
    private CalculadoraFinService service;

    public static void main(String[] args) {
        SpringApplication.run(CalculadoraFinController.class, args);
    }

    @PostMapping("/pacote")
    public double pacote(@RequestParam double aluguel,
                        @RequestParam double condominio,
                        @RequestParam double iptu) {
        return service.calcularPacoteLocacao(aluguel, condominio, iptu);
    }

    @PostMapping("/seguro")
    public double seguro(@RequestParam double pacote,
                        @RequestParam double taxa) {
        return service.calcularSeguroFianca(pacote, taxa);
    }

    @PostMapping("/seguro-mensal")
    public double seguroMensal(@RequestParam double valorSeguroAnual,
                              @RequestParam int parcelas) {
        return service.calcularSeguroMensal(valorSeguroAnual, parcelas);
    }

    @PostMapping("/renda-minima")
    public boolean rendaMinima(@RequestParam double rendaBruta,
                              @RequestParam double aluguel,
                              @RequestParam double multiplicador) {
        return service.verificarRendaMinima(rendaBruta, aluguel, multiplicador);
    }

    @PostMapping("/comprometimento")
    public double comprometimento(@RequestParam double rendaMensal,
                                  @RequestParam double pacoteLocacao) {
        return service.comprometimentoMaximoRenda(rendaMensal, pacoteLocacao);
    }
}
