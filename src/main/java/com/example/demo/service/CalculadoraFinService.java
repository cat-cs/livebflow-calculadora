package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service

public class CalculadoraFinService {
    public double calcularPacoteLocacao (double aluguel, double condominio, double iptu) {

       if (aluguel <= 0) {
           throw new IllegalArgumentException("Valor do aluguel deve ser positivo");
       }
       if (condominio < 0) {
           throw new IllegalArgumentException("Condominio não pode ser negativo");
       }
       if (iptu < 0) {
           throw new IllegalArgumentException("IPTU não pode ser negativo");
       }

       return aluguel + condominio + iptu;
    }

    public double calcularSeguroFianca (double pacoteLocacao, double taxaPercentual){

        if (pacoteLocacao <= 0) {
            throw new IllegalArgumentException("Pacote de locação deve ser positivo");
        }
        if (taxaPercentual <= 0 || taxaPercentual > 15) {
            throw new IllegalArgumentException("Taxa deve estar entre 0 e 15%");
        }

        return pacoteLocacao * 12 * (taxaPercentual / 100);
    }

    public double calcularSeguroMensal (double valorSeguroAnual, int parcelas) {

        if (valorSeguroAnual <= 0) {
            throw new IllegalArgumentException("Valor do seguro anual deve ser positivo");
        }
        if (parcelas <= 0 || parcelas > 12) {
            throw new IllegalArgumentException ("Parcelas deve ser entre 1 e 12");
        }

        return valorSeguroAnual / parcelas;
    }

    public boolean verificarRendaMinima(double rendaBruta, double aluguel, double multiplicador) {

        if (rendaBruta <= 0 || aluguel <= 0) {
            throw new IllegalArgumentException("Renda e aluguel devem ser positivos");
        }
        if (multiplicador < 3.0 || multiplicador > 4.0) {
            throw new IllegalArgumentException("Multiplicador deve estar entre 3 e 4");
        }

        return rendaBruta >= (aluguel * multiplicador);
    }

    public double comprometimentoMaximoRenda(double rendaMensal, double pacoteLocacao) {
        if (rendaMensal <=0 || pacoteLocacao <= 0) {
            throw new IllegalArgumentException("Renda e pacote devem ser positivos");
        }
        return (pacoteLocacao / rendaMensal) * 100;
    }
 }
