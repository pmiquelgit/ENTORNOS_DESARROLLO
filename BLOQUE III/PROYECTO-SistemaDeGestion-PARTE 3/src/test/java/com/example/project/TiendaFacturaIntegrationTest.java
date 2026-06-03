package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test de Integración: Tienda + Factura (Flujo E2E)")
class TiendaFacturaIntegrationTest {

    private Tienda tienda;
    private Cliente clienteEspana;
    private Cliente clienteVip;
    private Cliente clienteExtranjero;

    @BeforeEach void setUp() {
        tienda = new Tienda();

        // Creo de ejemplo un Cliente estándar de España con los siguientes atributos
        // 2 años de antiguedad, sin VIP y el descuento de 5%
        clienteEspana = new Cliente("Ana García", "ana@gmail.com", "Calle Mayor 1", 2, false, "ESPAÑA");

        // Cliente VIP con más de 5 años (por lo que tendría un descuento de 15%)
        clienteVip = new Cliente("Carlos López", "carlos@gmail.com", "Av. Libertad", 6, true, "ESPAÑA");

        // Cliente en Alemania (para que tenga envio de 10€)
        clienteExtranjero = new Cliente("John Smith", "john@mail.com", "123 Main St", 1, false, "ALEMANIA");

    }


    ///////////////////////////////////
    // CASOS DE INTEGRACIÓN POSITIVOS//
    ///////////////////////////////////
    @Test
    @DisplayName("Integración: La venta genera una factura no nula")
    void ventaGeneraFacturaNoNula() {

        // ARRANGE
        Pedido pedido = new Pedido(clienteEspana);
        pedido.agregarProducto(new ProductoFisico("Teclado", 50.0, 0.0));

        //ACT
        Factura factura = tienda.realizarVenta(clienteEspana, pedido);

        // ASSERT
        assertNotNull(factura, "La factura no debería ser null tras una venta correcta");
    }


    @Test
    @DisplayName("Integración: El código de factura se genera automáticamente")
    void facturaContieneCodigoGenerado() {

        // ARRANGE
        Pedido pedido = new Pedido(clienteEspana);
        pedido.agregarProducto(new ProductoFisico("Ratón", 30.0, 0.0));

        // ACT
        Factura factura = tienda.realizarVenta(clienteEspana, pedido);

        // ASSERT
        assertTrue(factura.getCodigoFactura().startsWith("FACT-"), "El código de la factura debe empezar por FACT-");
    }


    @Test
    @DisplayName("Integración: Cliente en España = gastos de envío 0€")
    void clienteEspanaSinGastosEnvio() {

        // ARRANGE + ACT
        double envio = tienda.calcularGastoEnvioPorPais("ESPAÑA");

        // ASSERT
        assertEquals(0.0, envio, "El envío en España debe ser gratuito");

    }


    @Test
    @DisplayName("Integración: Cliente en Francia = gastos de envío 5€")
    void clienteFranciaEnvioCincoEuros() {

        // ARRANGE + ACT
        double envio = tienda.calcularGastoEnvioPorPais("FRANCIA");

        // ASSERT
        assertEquals(5.0, envio, "El envío a Francia debe ser 5€");
    }


    @Test
    @DisplayName("Integración: Cliente en Alemania = gastos de envío 10€")
    void clienteExtranjeroDiezEuros() {

        // ARRANGE
        Pedido pedido = new Pedido(clienteExtranjero);
        pedido.agregarProducto(new ProductoFisico("Monitor", 200.0, 0.0));

        // ACT
        Factura factura = tienda.realizarVenta(clienteExtranjero, pedido);

        // ASSERT
        assertEquals(10.0, factura.getTotalEnvio(), "El envío a Alemania debe ser 10€");

    }


    @Test
    @DisplayName("Integración: Cliente VIP con +5 años = descuento del 15%")
    void clienteVipDescuentoMaximo() {

        // ARRANGE + ACT
        double descuento = tienda.calcularDescuentoFidelidad(100.0, 6, true);

        // ASSERT
        assertEquals(15.0, descuento, 0.01, "Un cliente VIP con más de 5 años debe tener un 15% de descuento");
    }


    @Test
    @DisplayName("Integración: La factura contiene el nombre del cliente correcto")
    void facturaContieneNombreCliente() {

        // ARRANGE
        Pedido pedido = new Pedido(clienteEspana);
        pedido.agregarProducto(new ProductoFisico("Silla", 150.0, 0.0));

        // ACT
        Factura factura = tienda.realizarVenta(clienteEspana, pedido);

        // ASSERT
        assertEquals("Ana García", factura.getNombreCliente(), "El nombre del cliente en la factura debe coincidir con el cliente real");

    }


    //////////////////////////////
    // CASOS DE PRUEBA NEGATIVOS//
    //////////////////////////////

    @Test
    @DisplayName("Robustez: realizarVenta con cliente null lanza excepción")
    void ventaConClienteNuloLanzaExcepcion() {

        // ARRANGE
        Pedido pedido = new Pedido(clienteEspana);
        pedido.agregarProducto(new ProductoFisico("Producto", 10.0, 0.0));

        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> tienda.realizarVenta(null, pedido), "Debe lanzar excepción si el cliente es null");
    }


    @Test
    @DisplayName("Robustez: realizarVenta con pedido null lanza excepción")
    void ventaConPedidoNuloLanzaExcepcion() {

        // ASSERT
        assertThrows(IllegalArgumentException.class, () -> tienda.realizarVenta(clienteEspana, null), "Debe lanzar excepción si el pedido es null");
    }



    @Test
    @DisplayName("Robustez: Pedido vacío lanza excepción antes de generar factura")
    void pedidoVacioLanzaExcepcion() {

        // ARRANGE
        Pedido pedidoVacio = new Pedido(clienteEspana);

        // ASSERT
        assertThrows(IllegalStateException.class, () -> tienda.realizarVenta(clienteEspana, pedidoVacio), "No se puede facturar un pedido sin productos");
    }


    @Test
    @DisplayName("Robustez: País null se trata como envío internacional (10€)")
    void paisNullTratadoComoInternacional() {

        // ARRANGE + ACT
        double envio = tienda.calcularGastoEnvioPorPais(null);

        // ASSERT
        assertEquals(10.0, envio, "Un país null debe tratarse como zona internacional (10€)");

    }
}

