package com.example.project;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas de Integración - Módulo Facturación")
class SistemaIntegracionTest {

    private GestorInventario inventario;
    private CalculadoraFinanciera calculadora;
    private ServicioFacturacion servicio;

    @BeforeEach
    void setUp() {
        inventario = new GestorInventario();
        calculadora = new CalculadoraFinanciera();
        servicio = new ServicioFacturacion(inventario, calculadora);
        
        inventario.darDeAltaProducto("PROD-01", 100);
    }

    @Test
    @DisplayName("Test 1: Integración Exitosa - Verificación de reserva y flujo básico")
    void testFlujoReservaVenta() {
        boolean reservaExitosa = inventario.verificarYReservar("PROD-01", 10);
        assertTrue(reservaExitosa, "El inventario debería permitir la reserva");
        
        String resultado = servicio.procesarFacturaCompleta("PROD-01", 5, 10.0);
        
        assertFalse(resultado.contains("ERROR"), "La factura debería haberse generado");
    }

    // El cálculo real es el siguiente:
    // 2 unidades x 10€ = 20€ base
    // Con IVA general (21%): 20 * 1.21 = 24.2€
    // Descuento fidelidad 5% (2 años, no VIP): 24.2 * 0.05 = 1.21€
    // Envío NACIONAL con base <= 100: 5 + (2.0 * 1.2) = 7.4€
    // Total final: 24.2 - 1.21 + 7.4 = 30.39€
    @Test
    @DisplayName("Test 2: Cálculo de precio con envío")
    void testCalculoPrecioFinalConEnvio() {
        
        String resultado = servicio.procesarFacturaCompleta("PROD-01", 2, 10.0);

        assertFalse(resultado.contains("ERROR"),
            "La factura debería haberse generado sin errores");
        assertTrue(resultado.contains("30.39"), 
            "La factura da un resultado incorrecto. Resultado obtenido: " + resultado);
    }
}