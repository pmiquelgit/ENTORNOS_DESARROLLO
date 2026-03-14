package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoTest {
    
    /////////////////////////////
    //CASOS DE PRUEBA POSITIVOS//
    /////////////////////////////


    // CALCULAR PRECIO DE PRODUCTO FÍSICO
    @Test
    @DisplayName("Calcular precio de producto físico")
    void calcularPrecioFisicoTest() {
        ProductoFisico productoTestFisico = new ProductoFisico("Ordenador", 100.0, 15);
        double resultado = productoTestFisico.calcularPrecioFinal();
        assertEquals(115.0, resultado, "El producto no ha dado el resultado esperado"); 
        //Aquí al final coloco un mensaje de error en caso de que el producto que he creado no sea el resultado que esperamos
    }

    // CALCULAR PRECIO DE PRODUCTO DIGITAL
    @Test@DisplayName("Calcular precio de producto digital")
    void calcularPrecioDigitalTest() {
        ProductoDigital productoDigitalTest = new ProductoDigital("Videojuego", 75, 20.0, 15, 0.0);
        double resultado = productoDigitalTest.calcularPrecioFinal();
        assertEquals(resultado, 86.25, "Algo salió mal, el precio obtenido no fue el correcto.");
    }

    /////////////////////////////
    //CASOS DE PRUEBA NEGATIVOS//
    /////////////////////////////

    //COMPROBAR PRECIO NEGATIVO EN UN PRODUCTO
    @Test
    @DisplayName("Comprobar precio negativo en un producto")
    void comprobarPrecioNegativo() {
        Producto productoTest = new ProductoFisico("Monitor", 50.0, 10.0);

        assertThrows(IllegalArgumentException.class, () -> {
            productoTest.setPrecio(-15.0);
        }, "El sistema no debería permitir productos con precio negativo");

    }    
}
