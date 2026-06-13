package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFinServiceTest {
    private CalculadoraFinService service;

    @BeforeEach
    public void setup() {
        service = new CalculadoraFinService();
    }

    @Test
    public void testCalcularPacoteLocacaoComTodosValores() {
        double resultado = service.calcularPacoteLocacao(1500, 300, 100);
        assertEquals(1900, resultado);
    }

    @Test
    public void testCalcularPacoteLocacaoSemCondominio() {
        double resultado = service.calcularPacoteLocacao(1500, 0, 100);
        assertEquals(1600, resultado);
    }

    @Test
    public void testCalcularPacoteLocacaoAluguelNegativoThrow() {
        assertThrows(IllegalArgumentException.class, () ->
            service.calcularPacoteLocacao(-1500, 300, 100)
        );
    }

    @Test
    public void testCalcularSeguroFiancaTaxaMinima() {
        double resultado = service.calcularSeguroFianca(1900, 8);
        assertEquals(1824, resultado);
    }

    @Test
    public void testCalcularSeguroFiancaTaxaMaxima() {
        double resultado = service.calcularSeguroFianca(1900, 15);
        assertEquals(3420, resultado);
    }

    @Test
    public void testCalcularSeguroFiancaTaxaZeroThrow() {
        assertThrows(IllegalArgumentException.class, () ->
            service.calcularSeguroFianca(1900, 0)
        );
    }

    @Test
    public void testCalcularSeguroMensalDodecassilabo() {
        double resultado = service.calcularSeguroMensal(2400, 12);
        assertEquals(200, resultado);
    }

    @Test
    public void testCalcularSeguroMensalUmaParcela() {
        double resultado = service.calcularSeguroMensal(2400, 1);
        assertEquals(2400, resultado);
    }

    @Test
    public void testCalcularSeguroMensalParcelasAcimaLimiteThrow() {
        assertThrows(IllegalArgumentException.class, () ->
            service.calcularSeguroMensal(2400, 13)
        );
    }

    @Test
    public void testVerificarRendaMinimaAprovada() {
        boolean resultado = service.verificarRendaMinima(6000, 1500, 3);
        assertTrue(resultado);
    }

    @Test
    public void testVerificarRendaMinimaReprovada() {
        boolean resultado = service.verificarRendaMinima(4000, 1500, 3);
        assertFalse(resultado);
    }

    @Test
    public void testVerificarRendaMinimaMultiplicadorInvalidoThrow() {
        assertThrows(IllegalArgumentException.class, () ->
            service.verificarRendaMinima(6000, 1500, 5)
        );
    }

    @Test
    public void testComprometimentoMaximoRendaIdeal() {
        double resultado = service.comprometimentoMaximoRenda(5000, 1000);
        assertEquals(20.0, resultado);
    }

    @Test
    public void testComprometimentoMaximoRendaAceitavel() {
        double resultado = service.comprometimentoMaximoRenda(5000, 1500);
        assertEquals(30.0, resultado);
    }

    @Test
    public void testComprometimentoMaximoRendaNegativoThrow() {
        assertThrows(IllegalArgumentException.class, () ->
            service.comprometimentoMaximoRenda(-5000, 1500)
        );
    }
}

