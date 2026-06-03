package com.example.project;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests de Integración: Flujo de Pedidos y Productos")
class GestionPedidosIntegrationTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        // Inicializamos el escenario: Un pedido vacío antes de cada test
        Cliente Paco = new Cliente("Paco", "paco@gmail.com", "casa de paco");
        pedido = new Pedido(Paco);
    }

    @Test
    @DisplayName("Integración: Cálculo de total con múltiples tipos de productos")
    void deberiaCalcularTotalConProductosMixtos() {
        // 1. Arrange (Preparar)
        // Creamos productos reales para ver cómo interactúan con el pedido
        // ProductoFisico: precio 30 + costeEnvio 1.5 = 31.5
        // ProductoDigital: precio 50, iva 15% -> 50*1.15=57.5, descuento 10 -> 57.5-10 = 47.5
        Producto libro = new ProductoFisico("Libro Java", 30.0, 1.5);
        Producto curso = new ProductoDigital("Curso Online", 50.0, 40, 15, 10);

        // 2. Act (Actuar)
        // Aquí ocurre la integración: Pedido recibe y almacena objetos Producto
        pedido.agregarProducto(libro);
        pedido.agregarProducto(curso);
        double totalObtenido = pedido.calcularTotal();

        // 3. Assert (Verificar)
        // El total esperado es la suma de los cálculos internos de cada producto
        double totalEsperado = 31.5 + 47.5; // = 79.0
        
        assertEquals(totalEsperado, totalObtenido, "El pedido no integró correctamente los precios finales de los productos");
    }

    @Test
    @DisplayName("Integración: Pedido vacío lanza excepción")
    void deberiaDarCeroSiNoHayProductos() {
        // CORRECCIÓN: calcularTotal() lanza IllegalStateException si el pedido está vacío,
        // ya que no tiene sentido calcular el total de un pedido sin productos.
        assertThrows(IllegalStateException.class,
            () -> pedido.calcularTotal(),
            "Un pedido vacío debe lanzar IllegalStateException");
    }

    @Test
    @DisplayName("Integración: Robustez ante productos nulos")
    void noDeberiaFallarSiSeAgregaProductoNulo() {
        // Test de integración para asegurar que el sistema no "explota" (NullPointerException)
        // al interactuar con datos erróneos.
        assertThrows(NullPointerException.class,
            () -> pedido.agregarProducto(null),
            "Agregar un producto nulo debe lanzar NullPointerException");
    }
}