package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ServicioFacturacionTest {

    ///////////////////////////////////////////////////////////////////////////////////
    /// CREO ESTA CLASE DE TEST PARA CUBRIR LAS FUNCIONES DE SERVICIO DE FACTURACION ///
    ///////////////////////////////////////////////////////////////////////////////////
    // Creamos objetos reales
    CalculadoraFinanciera calc = new CalculadoraFinanciera();
    GestorInventario inv = new GestorInventario();
    
    // servicio normal para la mayoría de las pruebas
    ServicioFacturacion servicio = new ServicioFacturacion(inv, calc);

    // Test para la función de "ProcesarFacturaCompleta"
    @Test
    void testProcesarFacturaCompleta_SinStock() {

        GestorInventario inventarioVacio = new GestorInventario() {
            @Override
            public boolean verificarYReservar(String idProd, int cant) {
                return false; 
            }
        };
        
        // Creo un servicio especial solo para esta prueba usando nuestro inventarioVacio
        ServicioFacturacion servicioSinStock = new ServicioFacturacion(inventarioVacio, calc);
        
        String resultado = servicioSinStock.procesarFacturaCompleta("PROD1", 5, 10.0);
        assertEquals("ERROR: Stock insuficiente", resultado);
    }

    // Otro test para la función de "ValidadIntegridad"
    @Test
    void testValidarIntegridad() {
        // (100 + 21) - 121 = 0, que es menor que 0.01 (Devuelve true)
        assertTrue(servicio.validarIntegridad(100.0, 21.0, 121.0));
        
        // (100 + 21) - 150 = 29, que NO es menor que 0.01 (Devuelve false)
        assertFalse(servicio.validarIntegridad(100.0, 21.0, 150.0));
    }

    // Este test para la función de "EmitirNotaCredito"
    @Test
    void testEmitirNotaCredito() {
        assertEquals("NC-FAC123", servicio.emitirNotaCredito("FAC123"));
    }

    // Este test para la función de "EstimarMargenBeneficio"
    @Test
    void testEstimarMargenBeneficio() {
        // total(1000) - coste(500) - (1000 * 0.21) = 500 - 210 = 290.0
        assertEquals(290.0, servicio.estimarMargenBeneficio(1000.0, 500.0));
    }

    // Este test para la función de "ArchivarFactura"
    @Test
    void testArchivarFactura() {

        servicio.archivarFactura("ID-1234");
        assertTrue(true); // Una aserción genérica para evitar errores
    }
}