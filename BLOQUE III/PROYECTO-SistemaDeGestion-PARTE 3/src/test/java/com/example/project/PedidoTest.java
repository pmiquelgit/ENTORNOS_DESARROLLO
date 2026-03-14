package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PedidoTest {
    
    /////////////////////////////
    //CASOS DE PRUEBA POSITIVOS//
    /////////////////////////////


    //SUMAR EL TOTAL DEL PEDIDO, ESTE LO HARÉ UNA "PARAMETERIZED TEST" COMO ME PIDE EL ENUNCIADO QUE HAGA
    @ParameterizedTest
    @DisplayName("Sumar el total del pedido")
    @CsvSource({
        "100.0, 16.0, 110.0, 0, 0, 226", //Este caso lo haré con los datos que he introducido en QASphere
        "50.0, 5.0, 20.0, 10.0, 2.0, 75.0", //Aquí introduciré datos aleatorios para probar
        "0.0, 0.0, 0.0, 0.0, 0.0, 0.0" //En este caso sería todo gratis
    })
    void calcularSumaPedidoTest(double precioProducFisico, double envioFisico, double precioProducDig, double iva, double descuentoDigital, double totalEsperado) {
        //Creo un cliente para poder agregarlo al pedido y no dejarlo en null
        Cliente clienteTest = new Cliente("Paco", "pacomilagros123@gmail.com", "calle de la juventud");
        Pedido pedidoTest = new Pedido(clienteTest);

        //Creo los productos con los que voy a trabajar en este test
        Producto productoTest2 = new ProductoFisico("Juguete", precioProducFisico, envioFisico);
        Producto productoTest1 = new ProductoDigital("Mario Bros", precioProducDig, 10.0, iva, descuentoDigital);
        
        pedidoTest.agregarProducto(productoTest1);
        pedidoTest.agregarProducto(productoTest2);

        double totalPedido = pedidoTest.calcularTotal();

        assertEquals(totalPedido, totalEsperado, "El total del pedido no ha sido calculado correctamente.");
    }


    //VALIDAR EL COSTE DE ENVÍO DE UN PRODUCTO FÍSICO´
    @Test
    @DisplayName("Validar el coste de envío de un producto físico")
    void validarCosteEnvio() {
        ProductoFisico productoFisicoTest = new ProductoFisico("producto de prueba", 34.99, 15.99);
        double costeEnvioDeProducto = productoFisicoTest.getCosteEnvio();

        assertEquals(costeEnvioDeProducto, 15.99, "El coste de envío recibido no ha sido el esperado");

    }

    //AGREGAR UN PRODUCTO VÁLIDO AL PEDIDO
    @Test
    @DisplayName("Agregar un producto válido al pedido")
    void agregarProductoValido() {

        Cliente clienteTest = new Cliente("Lara", "lara@ejemplo.com", "Calle locuras");
        Pedido pedidoTest = new Pedido(clienteTest);

        Producto producto = new ProductoFisico("Ratón", 50.0, 5.0);

        pedidoTest.agregarProducto(producto);

        assertEquals(55.0, pedidoTest.calcularTotal(), "El total del pedido tiene que mostrar el total del producto, pero no ha sido así.");
    }


    /////////////////////////////
    //CASOS DE PRUEBA NEGATIVOS//
    /////////////////////////////


    //DEVOLVER UN PEDIDO SIN PRODUCTOS
    @Test
    @DisplayName("Devolver un pedido sin productos")
    void verificarUnPedidoVacio() {
        Cliente clienteTest = new Cliente("Marta", "marta@pruebas.com", "País de las maravillas");
        Pedido pedidoTest = new Pedido(clienteTest);

        assertThrows(IllegalStateException.class, () -> {
            pedidoTest.calcularTotal();
        }, "El sistema no debería permitir calcular el total o manejar pedidos que no contengan productos.");

    }

    //DESCUENTO MAYOR QUE EL PRECIO DE UN PRODUCTO
    @Test
    @DisplayName("Descuento mayor que el precio total del producto")
    void descuentoMayorQuePrecio() {
        ProductoDigital productoTest = new ProductoDigital("Mario kart", 19.99, 12.0, 21.0, 50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            productoTest.calcularPrecioFinal();
        }, "El sistema no debería permitir un producto cuyo descuento sea mayor que su propio precio");
    }

    //SI SE AGREGA UN PRODUCTO NULO
    @Test
    @DisplayName("Agregar un producto nulo en el sistema")
    void agregacionProductoNulo() {
        Cliente clienteTest = new Cliente("Carlos", "carlitosepico@gmail.com", "pais de las locuras 2");
        Pedido pedidoTest = new Pedido(clienteTest);

        assertThrows(NullPointerException.class, () -> {
            pedidoTest.agregarProducto(null);
        }, "El sistema no debería permitir añadir productos nulos");
    }

    //NOMBRE VACÍO EN EL CLIENTE
    @Test
    @DisplayName("Cliente se registra con nombre vacío")
    void clienteNombreVacio() {

        String nombre = "";
        String email = "correoprueba@gmail.com";
        String direccion = "Calle de prueba 123";

        assertThrows(NullPointerException.class, () -> {
            new Cliente(nombre, email, direccion);
        }, "Un cliente no debería poder tener un nombre nulo");
    }
}
