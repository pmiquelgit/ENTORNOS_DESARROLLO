package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculadoraFinancieraTest {

    ///////////////////////////////////////////////////////////////////////////////
    /// CREO ESTA CLASE DE TEST PARA CUBRIR LAS FUNCIONES DE CALCULADORA FINANCIERA
    ///////////////////////////////////////////////////////////////////////////////
    CalculadoraFinanciera calc = new CalculadoraFinanciera();

    // Cubro el switch
    @Test
    void testAplicarIVA() {
        // Añadimos 0.001 al final para evitar errores de precisión de decimales
        assertEquals(121.0, calc.aplicarIVA(100.0, "GENERAL"), 0.001);
        assertEquals(110.0, calc.aplicarIVA(100.0, "REDUCIDO"), 0.001);
        assertEquals(104.0, calc.aplicarIVA(100.0, "SUPER"), 0.001);
        assertEquals(100.0, calc.aplicarIVA(100.0, "OTRO"), 0.001); // Cubre el default
    }

    // Cubro las función de calcularGastosEnvio
    @Test
    void testCalcularGastosEnvio() {
        // Pedido > 100 debe retornar 0.0
        assertEquals(0.0, calc.calcularGastosEnvio(10.0, 150.0, "NACIONAL"));
        // Pedido < 100, Internacional
        assertEquals(27.0, calc.calcularGastosEnvio(10.0, 50.0, "INTERNACIONAL")); // 15.0 + (10 * 1.2)
        // Pedido < 100, Nacional
        assertEquals(17.0, calc.calcularGastosEnvio(10.0, 50.0, "NACIONAL")); // 5.0 + (10 * 1.2)
    }

    // Cubro la función de "calcularComisionPasarela"
    @Test
    void testCalcularComisionPasarela() {
        assertEquals(3.0, calc.calcularComisionPasarela(100.0, "PAYPAL"));
        assertEquals(1.5, calc.calcularComisionPasarela(100.0, "TARJETA"));
    }
}